import java.io.IOException;

public class ObjectsFactory {
	private String id;
	private String name;
	private String description;
	private int credits;
	private String messageTitle;
	private String messageText;
	private String courseFileTitle;
	private String courseFileContent;
	private double score;
	private int orderId;
	private String orderTitle;
	private String orderContent;
	private YearOfStudy yearOfStudy;
	private String newsTitle;
	private String newsText;

	public ObjectsFactory() {}
	
	public Course createCourse() {
		getCourseData();
		Course course = new Course(id, name, description, credits, yearOfStudy);
		return course;
	}
	
	public void getCourseData() {
		System.out.println("What is the id of Course?");
		try {
			id = Menu.br.readLine();
			System.out.println("What is the name of Course?");
			name = Menu.br.readLine();
			System.out.println("What is the description of Course?");
			description = Menu.br.readLine();
			System.out.println("What is the total number of credits for this Course?");
			credits = Integer.parseInt(Menu.br.readLine());
			yearOfStudy = getYearOfStudy();
			
		} catch (IOException e) {
			System.out.println("Input-Output Error");
			e.printStackTrace();
		}
	}
	
	public YearOfStudy getYearOfStudy() {
		System.out.println("For Students of which year?\n 1. First\n 2. Second\n 3. Third\n 4. Fourth");
		try {
			int year = Integer.parseInt(Menu.br.readLine());
			if (year == 1) return YearOfStudy.FIRST;
			else if (year == 2) return YearOfStudy.SECOND;
			else if (year == 3) return YearOfStudy.THIRD;
			else if (year == 4) return YearOfStudy.FOURTH;
		} catch (NumberFormatException e) {
			System.out.println("Wrong number format");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Input-Output Error");
			e.printStackTrace();
		}
		return null;
	}
	
	public Message createMessage() {
		getMessageData();
		Message message = new Message(messageTitle, messageText);
		return message;
	}
	
	public void getMessageData() {
		System.out.println("What is the title of Message?");
		try {
			messageTitle = Menu.br.readLine();
			System.out.println("What is the text of Message?");
			messageText = Menu.br.readLine();
			
		} catch (IOException e) {
			System.out.println("Input-Output Error");
			e.printStackTrace();
		}
	}
	
	public CourseFile createCourseFile() {
		try {
			getCourseFileData();
			CourseFile cf = new CourseFile(courseFileTitle, courseFileContent);
			return cf;
		} catch (IOException e) {
			System.out.println("Input-Output Error");
			e.printStackTrace();
		}
		return null;
	}
	
	public void getCourseFileData() {
		System.out.println("What is the title of the Course File?");
		try {
			courseFileTitle = Menu.br.readLine();
			System.out.println("What is the content of File?");
			courseFileContent = Menu.br.readLine();
		} catch (IOException e) {
			System.out.println("Input-Output Error");
			e.printStackTrace();
		}
	}
	
	public Mark createMark() {
		System.out.println("What is the score of the student?");
		Mark mark = null;
		try {
			score = Double.parseDouble(Menu.br.readLine());
			mark = new Mark(score);
		} catch (NumberFormatException e) {
			System.out.println("Wrong number format");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Input-Output Error");
			e.printStackTrace();
		}
		return mark;
	}
	
	public Order createOrder() throws NumberFormatException, IOException {
		getOrderData();
		Order order = new Order(orderId, orderTitle, orderContent);
		return order;
	}
	
	public void getOrderData() throws NumberFormatException, IOException {
		System.out.println("What is the id of Order?");
		orderId = Integer.parseInt(Menu.br.readLine());
		System.out.println("What is the title of the Order?");
		orderTitle = Menu.br.readLine();
		System.out.println("What is the message?");
		orderContent = Menu.br.readLine();
	}
	
	public News createNews() throws IOException {
		getNewsData();
		News news = new News(newsTitle, newsText);
		return news;
	}
	
	public void getNewsData() throws IOException {
		System.out.println("What is the title of News?");
		newsTitle = Menu.br.readLine();
		System.out.println("What is the text of News?");
		newsText = Menu.br.readLine();
	}
	
}
