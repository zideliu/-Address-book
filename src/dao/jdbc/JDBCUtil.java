package dao.jdbc;

import java.sql.*;

public class JDBCUtil {

    private static String url = "jdbc:mysql://rm-uf61e4i5z34jgd82s4o.mysql.rds.aliyuncs.com:3306/zzk" ;
    private static String username = "root" ;
    private static String password = "xinyu1973QQ" ;

    static {
        try {
            // 加载MySql的驱动类
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动程序类 ，加载驱动失败！");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException se) {
            System.out.println("数据库连接失败！");
            se.printStackTrace();
        }
        return con;
    }

    public static void release(Connection conn, PreparedStatement st, ResultSet rs) {
        if (rs != null) {
            try {
                // 关闭存储查询结果的ResultSet对象
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (st != null) {
            try {
                // 关闭负责执行SQL命令的Statement对象
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                // 关闭Connection数据库连接对象
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}