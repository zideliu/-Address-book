package entity;

public class Message {
    private int id;
    private String sender;
    private String receiver;
    private String content;

    public Message() {
        super();
    }

    public Message(String sender, String receiver, String content) {
        super();
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

    public Message(int id, String sender, String receiver, String content) {
        super();
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message [id=" + id + ", sender=" + sender + ", receiver=" + receiver + ", content=" + content + "]";
    }
}
