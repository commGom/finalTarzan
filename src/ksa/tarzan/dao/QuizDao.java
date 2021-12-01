package ksa.tarzan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ksa.tarzan.dto.Member;
import ksa.tarzan.dto.Quiz;
import ksa.tarzan.util.Manager;
import ksa.tarzan.util.Session;

public class QuizDao {
    private final String URL = "jdbc:mysql://localhost:3306/commGom";;
    private final String USER = "root";
    private final String PASSWORD = "1234";
    private Connection connection = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private static List<Quiz> quizList = null;
    private int countQuestion;
    private int point;
    private static QuizDao qDao = new QuizDao();

    public static void setInstance(QuizDao qDao) {
        QuizDao.qDao = qDao;
    }

    public static QuizDao getInstance() {
        return qDao;
    }

    private Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return connection;
    }

    public Quiz serveEachQuiz() {
        System.out.println(countQuestion);
        if (countQuestion == 10) {
            return null;
        } else {
            Quiz temp = quizList.get(countQuestion);
            System.out.println(temp);
            countQuestion++;
            Quiz quiz = new Quiz(countQuestion, temp.getQuestion(), temp.getAnswer(), temp.getExOne(), temp.getExTwo(),
                    temp.getExThree(), temp.getExFour());
            return quiz;
        }
    }

    public void serveRandomQuiz() {
        // 새 문제 출제할 때마다 문제 번호 index 0으로 reset;
        this.countQuestion = 0;
        this.point = 0;
        // 0. 퀴즈DB에 퀴즈가 몇 개 있는지 카운트 한다. sql1
        // 1. 퀴즈DB에서 가져올 퀴즈번호 10개를 무작위로 뽑는다. 뽑아서 RandomQuizList에 번호들을 저장한다 sql2, sql3
        // 2. 뽑은 퀴즈번호 10개를 퀴즈DB로 부터 퀴즈문제들을 가져와서 리스트로 저장하여 반환한다. sql4
        List<Quiz> randomQuizList = new ArrayList<>();
        try {
            connection = getConnection();
            String sql1 = "SELECT COUNT(*) FROM QUIZ";
            pstmt = connection.prepareStatement(sql1);
            rs = pstmt.executeQuery();
            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1);
            }
            System.out.println("퀴즈 개수 : " + count);

            String sql2 = "SELECT COUNT(*) FROM RANDOM_QUIZLIST";
            int sequence = 0;
            pstmt = connection.prepareStatement(sql2);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                sequence = rs.getInt(1);
            }
            int[] randomTenNumbers = (new Manager()).randomNumberPickerTen(count);
            String sql3 = "INSERT INTO RANDOM_QUIZLIST VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            pstmt = connection.prepareStatement(sql3);
            pstmt.setInt(1, sequence + 1);
            pstmt.setInt(2, randomTenNumbers[0]);
            pstmt.setInt(3, randomTenNumbers[1]);
            pstmt.setInt(4, randomTenNumbers[2]);
            pstmt.setInt(5, randomTenNumbers[3]);
            pstmt.setInt(6, randomTenNumbers[4]);
            pstmt.setInt(7, randomTenNumbers[5]);
            pstmt.setInt(8, randomTenNumbers[6]);
            pstmt.setInt(9, randomTenNumbers[7]);
            pstmt.setInt(10, randomTenNumbers[8]);
            pstmt.setInt(11, randomTenNumbers[9]);

            int result = pstmt.executeUpdate();
            if (result != -1) {
                String sql4 = "SELECT * FROM QUIZ WHERE QUIZNO IN (?,?,?,?,?,?,?,?,?,?)";
                pstmt = connection.prepareStatement(sql4);
                pstmt.setInt(1, randomTenNumbers[0]);
                pstmt.setInt(2, randomTenNumbers[1]);
                pstmt.setInt(3, randomTenNumbers[2]);
                pstmt.setInt(4, randomTenNumbers[3]);
                pstmt.setInt(5, randomTenNumbers[4]);
                pstmt.setInt(6, randomTenNumbers[5]);
                pstmt.setInt(7, randomTenNumbers[6]);
                pstmt.setInt(8, randomTenNumbers[7]);
                pstmt.setInt(9, randomTenNumbers[8]);
                pstmt.setInt(10, randomTenNumbers[9]);

                rs = pstmt.executeQuery();
                while (rs.next()) {
                    int quizNo = rs.getInt(1);
                    System.out.print(quizNo+"\t");
                    String question = rs.getString(2);
                    int answer = rs.getInt("answer");
                    String ex01 = rs.getString("exOne");
                    String ex02 = rs.getString(5);
                    String ex03 = rs.getString(6);
                    String ex04 = rs.getString("exFour");
                    Quiz quiz = new Quiz(quizNo, question, answer, ex01, ex02, ex03, ex04);
                    randomQuizList.add(quiz);
                }
                System.out.println("퀴즈 생성 완료" + randomQuizList.size() + " 개");
                System.out.println(randomQuizList);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        quizList = randomQuizList;
        System.out.println(quizList);
    }

    public char solveQuiz(int userAnswer, Quiz quiz) {

        char answerYN = 'N';
        if (userAnswer == quiz.getAnswer()) {
            answerYN = 'Y';
            this.point++;
            System.out.println("채점 중 포인트 : " + point);
        }
        return answerYN;
    }

    public int markQuiz() {
        Member user = Session.getUser();
        // User의 아이디, 시도 횟수(차수) <- PK 퀴즈세트 번호

        return this.point;
    }

}
