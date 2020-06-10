package dao;

import dao.MessageDao;
import dao.jdbc.JDBCUtil;
import entity.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoImp implements MessageDao{

	@Override
	public List<Message> getMessageByReceiver(String receiver) {
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
		String sql = "select * from message where receiver=?";	
		List<Message> messages = new ArrayList<Message>();		
		try {
			ps = con.prepareStatement(sql);
			ps.setObject(1, receiver);
			rs = ps.executeQuery();
			while(rs.next()){
				Message message = new Message();
				message.setId(rs.getInt("id"));
				message.setReceiver(rs.getString("receiver"));
				message.setSender(rs.getString("sender"));
				message.setContent(rs.getString("content"));
				messages.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.release(con,ps,rs);
		}
		return messages;
	}

	@Override
	public List<Message> getMessageByReceiverAndPage(String receiver, int page) {
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
		String sql = "select * from message where receiver=? limit ?,?";	
		List<Message> messages = new ArrayList<Message>();		
		try {
			ps = con.prepareStatement(sql);
			ps.setObject(1, receiver);
			ps.setObject(2, start);
			ps.setObject(3, 5);
			rs = ps.executeQuery();
			while(rs.next()){
				Message message = new Message();
				message.setId(rs.getInt("id"));
				message.setReceiver(rs.getString("receiver"));
				message.setSender(rs.getString("sender"));
				message.setContent(rs.getString("content"));
				messages.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.release(con,ps,rs);
		}
		return messages;
	}

	@Override
	public Boolean sendMessage(Message message) {
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
		String sql = "insert into message(receiver,sender,content) values(?,?,?)";	
		try {
			ps = con.prepareStatement(sql);
			ps.setObject(1, message.getReceiver());
			ps.setObject(2, message.getSender());
			ps.setObject(3, message.getContent());
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
	public int getMessageCountByReceiver(String receiver) {
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
		String sql = "select * from message where receiver=?";	
		List<Message> messages = new ArrayList<Message>();		
		try {
			ps = con.prepareStatement(sql);
			ps.setObject(1, receiver);
			rs = ps.executeQuery();
			while(rs.next()){
				Message message = new Message();
				message.setId(rs.getInt("id"));
				message.setReceiver(rs.getString("receiver"));
				message.setSender(rs.getString("sender"));
				message.setContent(rs.getString("content"));
				messages.add(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.release(con,ps,rs);
		}
		return messages.size();
	}

	@Override
	public Boolean deleteMessage(int id) {
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
		String sql = "delete from message where id=?";	
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
	public String getContentById(int id) {
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
		String sql = "select * from message where id=?";	
		String content = "";	
		try {
			ps = con.prepareStatement(sql);
			ps.setObject(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				content = rs.getString("content");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			JDBCUtil.release(con,ps,rs);
		}
		return content;
	}

}
