package dao;

import dao.UserDao;
import dao.jdbc.JDBCUtil;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean checkUsername(String username) {
        // TODO Auto-generated method stub
        Connection con = null;
        try {
            con = JDBCUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flag = false;//标记位，默认为false
        String sql = "select * from user where username=?";
        try {
            con = JDBCUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if(rs.next()) {
                flag = true; //如果结果集非空，说明用户名已被使用
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCUtil.release(con, ps, rs);
        }
        return flag;
    }

    @Override
    public boolean checkPassword(String username, String password) {
        // TODO Auto-generated method stub
        Connection con = null;
        try {
            con = JDBCUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean flag = false;//标记位，默认为false
        String sql = "select * from user where username= ? and password= ?";
        try {
            con = JDBCUtil.getConnection();
            ps = con.prepareStatement(sql);//预编译
            ps.setObject(1, username);
            ps.setObject(2, password);
            rs = ps.executeQuery();
            if(rs.next()) {
                flag = true; //如果结果集非空，说明用户名已被使用
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCUtil.release(con, ps, rs);
        }
        return flag;
    }

    @Override
    public User getUserByCondition(String condition)  {
        // TODO Auto-generated method stub
        Connection con = null;
        try {
            con = JDBCUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from user where username = ? or phone = ?";
        User user = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, condition);
            ps.setObject(2, condition);
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String email=rs.getString(4);
                String phone = rs.getString(5);
                String youbian=rs.getString(6);
                String pic=rs.getString(7);
                String address=rs.getString(8);
                user=new User(id,username,password,email,phone,youbian,pic,address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JDBCUtil.release(con,ps,rs);
        }
        return user;
    }

    @Override
    public Boolean save(User user)  {
        // TODO Auto-generated method stub
        Connection con = null;
        try {
            con = JDBCUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "insert into user(username,password,email,phone,youbian,pic,address) values(?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, user.getUsername());
            ps.setObject(2, user.getPassword());
            ps.setObject(3, user.getEmail());
            ps.setObject(4, user.getPhone());
            ps.setObject(5, user.getYoubian());
            ps.setObject(6, user.getPic());
            ps.setObject(7, user.getAddress());
            if(ps.executeUpdate()==1) {
                    return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JDBCUtil.release(con,ps,rs);
        }
        return false;
    }

    @Override
    public List<User> getAllUser() {
        // TODO Auto-generated method stub
        Connection con = null;
        try {
            con = JDBCUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from user";
        List<User> users = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                User user=null;
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String email=rs.getString(4);
                String phone = rs.getString(5);
                String youbian=rs.getString(6);
                String pic=rs.getString(7);
                String address=rs.getString(8);
                user=new User(id,username,password,email,phone,youbian,pic,address);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JDBCUtil.release(con,ps,rs);
        }
        return users;

    }

    @Override
    public List<User> getUserByPage(int page)  {
        // TODO Auto-generated method stub
        Connection con = null;
        try {
            con = JDBCUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        int start = (page-1)*5;
        List<User> users = new ArrayList<>();
        String sql = "select * from user limit ?,?";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, start);
            ps.setObject(2, 5);
            rs = ps.executeQuery();
            while(rs.next()){
                User user=null;
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String email=rs.getString(4);
                String phone = rs.getString(5);
                String youbian=rs.getString(6);
                String pic=rs.getString(7);
                String address=rs.getString(8);
                user=new User(id,username,password,email,phone,youbian,pic,address);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JDBCUtil.release(con,ps,rs);
        }
        return users;
    }
    @Override
    public List<User> FindUserByCondition(String condition,String val) {
        Connection con = null;
        try {
            con = JDBCUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<User>();
        String sql = String.format("select * from user where %s=?",condition);
        try{
            ps =con.prepareStatement(sql);
            ps.setObject(1, val);
            rs=ps.executeQuery();
            while(rs.next()){
                User user = null;
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String email=rs.getString(4);
                String phone = rs.getString(5);
                String youbian=rs.getString(6);
                String pic=rs.getString(7);
                String address=rs.getString(8);
                user=new User(id,username,password,email,phone,youbian,pic,address);
                list.add(user);
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }finally{
           JDBCUtil.release(con,ps,rs);
        }
        return  list;
        // TODO Auto-generated method stub
    }

    @Override
    public int getUserCount()  {
        // TODO Auto-generated method stub
        Connection con = null;
        try {
            con = JDBCUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from user";
        List<User> users = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                User user=null;
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String email=rs.getString(4);
                String phone = rs.getString(5);
                String youbian=rs.getString(6);
                String pic=rs.getString(7);
                String address=rs.getString(8);
                user=new User(id,username,password,email,phone,youbian,pic,address);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JDBCUtil.release(con,ps,rs);
        }
        return users.size();
    }

    @Override
    public Boolean deleteUser(int id) {
        // TODO Auto-generated method stub
        Connection con = null;
        try {
            con = JDBCUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "delete from user where id=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            if(ps.executeUpdate()==1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JDBCUtil.release(con,ps,rs);
        }
        return false;
    }

    @Override
    public Boolean updateUser(User user, String username, String password, String email, String youbian) {
        // TODO Auto-generated method stub
        Connection con = null;
        try {
            con = JDBCUtil.getConnection();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "update user set username=?,password=?,email=?,youbian=? where username=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, username);
            ps.setObject(2, password);
            ps.setObject(3, email);
            ps.setObject(4, youbian);
            ps.setObject(5, user.getUsername());
            if(ps.executeUpdate()==1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JDBCUtil.release(con,ps,rs);
        }
        return false;
    }

    @Override
    public Boolean updateUserPic(User user, String pic) {
        // TODO Auto-generated method stub
        Connection con = null;
        try {
            con = JDBCUtil.getConnection();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "update user set pic=? where username=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, pic);
            ps.setObject(2, user.getUsername());
            if(ps.executeUpdate()==1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JDBCUtil.release(con,ps,rs);
        }
        return false;
    }

    @Override
    public Boolean updateUsernoPic(User user,String password, String phone, String email, String youbian, String address) {
        Connection con = null;
        try {
            con = JDBCUtil.getConnection();
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "update user set password=?,phone=?,email=?,youbian=?,address=? where username=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setObject(1, password);
            ps.setObject(2, phone);
            ps.setObject(3, email);
            ps.setObject(4,youbian);
            ps.setObject(5,address);
            ps.setObject(6, user.getUsername());
            if(ps.executeUpdate()==1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            JDBCUtil.release(con,ps,rs);
        }
        return false;
    }


}
