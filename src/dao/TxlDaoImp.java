package dao;

import dao.TxlDao;
import dao.jdbc.JDBCUtil;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TxlDaoImp implements TxlDao{

	@Override
	public List<User> getContactByPageAndNowuser(int page, User nowuser) {
		// TODO Auto-generated method stub
		int start = (page-1)*5;
		Connection con = null;
		try {
			con = JDBCUtil.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from user,txl where txl.user=? and user.username=txl.contact limit ?,?";	
		List<User> users = new ArrayList<User>();		
		try {
			ps = con.prepareStatement(sql);
			ps.setObject(1, nowuser.getUsername());
			ps.setObject(2, start);
			ps.setObject(3, 5);	
			rs = ps.executeQuery();
			while(rs.next()){
				User user = new User();
				//user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPhone(rs.getString("phone"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setYoubian(rs.getString("youbian"));
				user.setPic(rs.getString("pic"));
				user.setAddress(rs.getString("address"));
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
	public int getContactCountByNowuser(User nowuser) {
		// TODO Auto-generated method stub
		int count = 0;
		Connection con = null;
		try {
			con = JDBCUtil.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from txl where user=?";			
		try {
			ps = con.prepareStatement(sql);
			ps.setObject(1, nowuser.getUsername());
			rs = ps.executeQuery();
			while(rs.next()){
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.release(con,ps,rs);
		}
		return count;
	}

	@Override
	public boolean addContact(String nowuser, String contact) {
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
		String sql = "insert into txl(user,contact) values(?,?)";	
		try {
			ps = con.prepareStatement(sql);
			ps.setObject(1, nowuser);
			ps.setObject(2, contact);
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
	public Boolean deleteContact(String user,String contact) {
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
		String sql = "delete from txl where user=? and contact=?";	
		try {
			ps = con.prepareStatement(sql);
			ps.setObject(1, user);
			ps.setObject(2, contact);
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
	public List<User> getContactByNowuser(String nowuser) {
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
		String sql = "select * from txl where user=?";		
		List<User> users = new ArrayList<User>();		
		try {
			ps = con.prepareStatement(sql);
			ps.setObject(1, nowuser);
			rs = ps.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setUsername(rs.getString("contact"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.release(con,ps,rs);
		}
		return users;
	}
	
}
