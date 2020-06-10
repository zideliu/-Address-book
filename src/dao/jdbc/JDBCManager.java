package dao.jdbc;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCManager {

    public static DataSource ds;//数据源对象

    static{
        InitialContext context=null;
        try {
            context=new InitialContext();
            ds= (DataSource) context.lookup("java:/comp/env/jdbc/mydb");

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }


    public static Connection  getConnection(){//通过从数据源对象获取数据库的连接
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            System.out.println("获取数据库的连接对象失败！");
            e.printStackTrace();
            return null;
        }
    }

    public static void close(){
        Connection connection=getConnection();
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
