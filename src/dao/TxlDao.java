package dao;

import entity.User;

import java.util.List;

public interface TxlDao {
	List<User> getContactByPageAndNowuser(int page, User nowuser);
	List<User> getContactByNowuser(String nowuser);
	int getContactCountByNowuser(User nowuser);
	boolean addContact(String nowuser, String contact);
	Boolean deleteContact(String user, String contact);
}
