package ksa.tarzan.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import ksa.tarzan.dao.QuizDao;
import ksa.tarzan.dto.Quiz;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class QuizPage extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private char answerYN;
    private String alertMessage;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    QuizPage frame = new QuizPage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    // 3. 퀴즈 페이지
    public QuizPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(153, 51, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // 번호 버튼 : RoundedButton_1 클래스 사용
        RoundedButton_1 ansBtn_1 = new RoundedButton_1("1");
        ansBtn_1.setBounds(36, 303, 45, 42);
        contentPane.add(ansBtn_1);

        RoundedButton_1 ansBtn_2 = new RoundedButton_1("2");
        ansBtn_2.setBounds(36, 355, 45, 42);
        contentPane.add(ansBtn_2);

        RoundedButton_1 ansBtn_3 = new RoundedButton_1("3");
        ansBtn_3.setBounds(36, 407, 45, 42);
        contentPane.add(ansBtn_3);

        RoundedButton_1 ansBtn_4 = new RoundedButton_1("4");
        ansBtn_4.setBounds(36, 459, 45, 42);
        contentPane.add(ansBtn_4);

        JLabel quizNum_Label = new JLabel("Q1");
        quizNum_Label.setForeground(Color.BLACK);
        quizNum_Label.setFont(new Font("굴림", Font.BOLD, 25));
        quizNum_Label.setHorizontalAlignment(SwingConstants.CENTER);
        quizNum_Label.setBounds(23, 10, 71, 56);
        contentPane.add(quizNum_Label);

        JLabel ansLabel_1 = new JLabel("보기1");
        ansLabel_1.setFont(new Font("굴림", Font.BOLD, 17));
        ansLabel_1.setBounds(95, 303, 241, 42);
        contentPane.add(ansLabel_1);

        JLabel ansLabel_2 = new JLabel("보기2");
        ansLabel_2.setFont(new Font("굴림", Font.BOLD, 17));
        ansLabel_2.setBounds(95, 355, 241, 42);
        contentPane.add(ansLabel_2);

        JLabel ansLabel_3 = new JLabel("보기3");
        ansLabel_3.setFont(new Font("굴림", Font.BOLD, 17));
        ansLabel_3.setBounds(95, 407, 241, 42);
        contentPane.add(ansLabel_3);

        JLabel ansLabel_4 = new JLabel("보기4");
        ansLabel_4.setFont(new Font("굴림", Font.BOLD, 17));
        ansLabel_4.setBounds(95, 459, 241, 42);
        contentPane.add(ansLabel_4);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.WHITE);
        panel_1.setBounds(23, 256, 335, 297);
        contentPane.add(panel_1);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(23, 104, 335, 155);
        contentPane.add(panel);

        JTextArea quiz_Label = new JTextArea();
        quiz_Label.setFont(new Font("굴림", Font.BOLD, 16));
        quiz_Label.setLineWrap(true);
        quiz_Label.setRows(8);
        quiz_Label.setColumns(20);
        panel.add(quiz_Label);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.WHITE);
        panel_2.setBounds(23, 10, 335, 96);
        contentPane.add(panel_2);

        QuizDao qDao = QuizDao.getInstance();
        Quiz currentQuiz = qDao.serveEachQuiz();
        System.out.println(currentQuiz);
        if (currentQuiz != null) {
            quizNum_Label.setText("Q. " + currentQuiz.getQuizNo());
            quiz_Label.setText(currentQuiz.getQuestion());
            ansLabel_1.setText(currentQuiz.getExOne());
            ansLabel_2.setText(currentQuiz.getExTwo());
            ansLabel_3.setText(currentQuiz.getExThree());
            ansLabel_4.setText(currentQuiz.getExFour());

            setVisible(true);
            setBounds(100, 100, 400, 600);
            setLocationRelativeTo(null);
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else {
            // 다 푼 문제를 Solved_QuizList에 저장(회차, 사용자아이디, 퀴즈세트, 점수 )하고 다음 페이지로 넘김.
            setVisible(false);
            new ResultPage();
        }

        // 문제 버튼 이벤트
        ansBtn_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                answerYN=qDao.solveQuiz(1,currentQuiz);
                if (answerYN=='Y'){
                    alertMessage="정답 여부\n : Yes \n ";
                }else{
                    alertMessage="No";
                }
                JOptionPane.showMessageDialog(null, alertMessage);
                setVisible(false);
                new QuizPage();
            }
        });
        ansBtn_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                answerYN=qDao.solveQuiz(2,currentQuiz);
                if (answerYN=='Y'){
                    alertMessage="정답 여부\n : Yes \n ";
                }else{
                    alertMessage="No";
                }
                JOptionPane.showMessageDialog(null, alertMessage);
                setVisible(false);
                new QuizPage();
            }
        });
        ansBtn_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                answerYN=qDao.solveQuiz(3,currentQuiz);
                if (answerYN=='Y'){
                    alertMessage="정답 여부\n : Yes \n ";
                }else{
                    alertMessage="No";
                }
                JOptionPane.showMessageDialog(null, alertMessage);
                setVisible(false);
                new QuizPage();
            }
        });
        ansBtn_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                answerYN=qDao.solveQuiz(4,currentQuiz);
                if (answerYN=='Y'){
                    alertMessage="정답 여부\n : Yes \n ";
                }else{
                    alertMessage="No";
                }
                JOptionPane.showMessageDialog(null, alertMessage);
                setVisible(false);
                new QuizPage();
            }
        });




    }
}