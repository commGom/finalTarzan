import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String url="jdbc:mysql://localhost:3306/commGom";
        String user="root";
        String password="1234";

        try {
            connection=DriverManager.getConnection(url,user,password);
            String sql="select * from member where memid=?";
            pstmt=connection.prepareStatement(sql);
            pstmt.setString(1,"mem01");
            rs=pstmt.executeQuery();
            String memId=null;
            String memPw=null;
            String nickName=null;
            int score=0;
            while(rs.next()){
                 memId=rs.getString(1);
                 memPw=rs.getString("memPw");
                 nickName=rs.getString("nickName");
                 score=rs.getInt(4);
            }
            System.out.println(String.format("테스트 결과 : %s, %s, %s, %d",memId,memPw,nickName,score));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
