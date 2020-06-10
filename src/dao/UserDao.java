package dao;

import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public boolean checkUsername(String username);
    public boolean checkPassword(String username, String password);
    User getUserByCondition(String condition) throws SQLException;
    Boolean save(User user) throws SQLException;
    List<User> getAllUser() throws SQLException;
    List<User> getUserByPage(int page) throws SQLException;
    List<User> FindUserByCondition(String condition, String val);
    int getUserCount() throws SQLException;
    Boolean deleteUser(int id) throws SQLException;
    Boolean updateUser(User user, String username, String password, String email, String youbian);
    Boolean updateUserPic(User user, String pic);
    Boolean updateUsernoPic(User user, String password, String phone, String email, String youbian, String address);

}
