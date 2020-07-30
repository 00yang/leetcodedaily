import java.sql.*;

public class jdbc_test {

    public static void main(String[] args) {
        boolean loginflag =new jdbc_test().login("li","111");

        System.out.println(loginflag);
    }

    public boolean login(String username,String password){
        if(username == null||password == null){
            return false;
        }

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            conn = JDBCUtils.getConnection();

            String sql = "select * from userinfo where name = '"+username+"' and password = '"+password+"'";

            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);

            return rs.next();

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return false;

    }

}
