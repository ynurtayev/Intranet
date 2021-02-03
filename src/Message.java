import java.io.Serializable;

public class Message implements Serializable {
	private String title;
	private String content;
	
	public Message() {}
	public Message(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String toString() {
		return "Message: " + title + "\n" + content + "\n";
	}
}
