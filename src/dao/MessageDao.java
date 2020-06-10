package dao;

import entity.Message;

import java.util.List;

public interface MessageDao {
	List<Message> getMessageByReceiver(String receiver);
	List<Message> getMessageByReceiverAndPage(String receiver, int page);
	Boolean sendMessage(Message message);
	int getMessageCountByReceiver(String receiver);
	Boolean deleteMessage(int id);
	String getContentById(int id);
}
