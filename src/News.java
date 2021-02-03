import java.io.Serializable;

public class News implements Serializable{
	private String text;
	private String title;
	
	public News() {}
	public News(String title, String text) {
		this.text = text;
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public String toString() {
		return "News: " + title + "\n" + text + "\n";
	}
	
}
