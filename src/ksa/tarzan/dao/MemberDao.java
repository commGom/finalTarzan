package ksa.tarzan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ksa.tarzan.dto.Member;
import ksa.tarzan.util.Session;

public class MemberDao {

    private final String URL = "jdbc:mysql://localhost:3306/commGom";;
    private final String USER = "root";
    private final String PASSWORD = "1234";
    private Connection connection = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    private static MemberDao mDao = new MemberDao();

    public static MemberDao getInstance() {
        return mDao;
    }

    public MemberDao() {
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

    public boolean register(Member member) {
        boolean result = false;
        try {
            connection = getConnection();
            String sql = "INSERT INTO MEMBER VALUES(?,?,?,?)";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, member.getMemId());
            pstmt.setString(2, member.getMemPw());
            pstmt.setString(3, member.getNickName());
            pstmt.setInt(4, member.getScore());
            int res = pstmt.executeUpdate();
            System.out.println("업데이트 결과 : " + res);
            if (res != -1) {
                result = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return result;
    }

    public Member login(String id, String pw) {
        Member user = null;
        try {
            connection = getConnection();
            String sql = "SELECT * FROM MEMBER WHERE memId=? AND memPw=?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String memId = rs.getString(1);
                String memPw = rs.getString(2);
                String nickName = rs.getString("nickName");
                int score = rs.getInt("score");
                user = new Member(memId, memPw, nickName, score);
            }
            System.out.println(user);
            if (user != null) {
                // 세션에 저장할 로그인한 정보
                Session.setUser(user);
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
        return user;
    }

    // 회원정보수정
    public boolean modify(Member member) {
        boolean result = false;
        try {
            connection = getConnection();
            String sql = "UPDATE MEMBER SET NICKNAME = ? , MEMPW = ?  WHERE MEMID=?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, member.getNickName());
            pstmt.setString(2, member.getMemPw());
            pstmt.setString(3, member.getMemId());
            int res = pstmt.executeUpdate();
            System.out.println("업데이트 결과 : " + res);
            if (res != -1) {
                result = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return result;
    }

    public String[][] sortedMemberListByScore() {
        ArrayList<Member> memberInfoList = new ArrayList<>();
        try {
            connection = getConnection();
            System.out.println(connection);
            String sql = "SELECT * FROM MEMBER ORDER BY SCORE DESC, NICKNAME";
            System.out.println(connection.isClosed());
            pstmt = connection.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String memId = rs.getString(1);
                String memPw = rs.getString(2);
                String nickName = rs.getString("nickName");
                int score = rs.getInt("score");
                memberInfoList.add(new Member(memId, memPw, nickName, score));
            }
            System.out.println("memberlist==>" + memberInfoList);
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

        String[][] memberInfoArr = new String[memberInfoList.size()][3];
        for (int i = 0; i < memberInfoList.size(); i++) {
            Member member = memberInfoList.get(i);
            memberInfoArr[i][0] = (i + 1) + "";
            memberInfoArr[i][1] = member.getNickName();
            memberInfoArr[i][2] = member.getScore() + "";
        }
        return memberInfoArr;
    }

    public void logout() {
        Session.setUser(null);
    }

    public boolean updateScore(Member member) {
        boolean result = false;
        try {
            connection = getConnection();
            String sql = "UPDATE MEMBER SET SCORE = ? WHERE MEMID=?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, member.getScore());
            pstmt.setString(2, member.getMemId());
            int res = pstmt.executeUpdate();
            System.out.println("업데이트 결과 : " + res);
            if (res != -1) {
                result = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return result;
    }

}
