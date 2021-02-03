
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CourseFile implements Serializable{
	private String title;
	private String content;
	
	public CourseFile() {}
	public CourseFile(String title, String content) throws IOException {
		this.title = title;
		this.content = content;
		writeCourseFile(title);
	}
	
	public void writeCourseFile(String title) {
		try {
			FileOutputStream fos = new FileOutputStream(title + ".txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			fos.close();
			oos.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} 
		catch (IOException e) {
			System.out.println("Input-Output Error");
			e.printStackTrace();
		}
		
	}
	
	public CourseFile readCourseFile(String title) {
		CourseFile cf = null;
		try {
			FileInputStream fis = new FileInputStream(title + ".txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			cf = (CourseFile)ois.readObject();
			fis.close();
			ois.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("Input-Output Error");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			e.printStackTrace();
		}
		return cf;
		
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
		return "Title: " + title + "\n" + content;
	}
}
