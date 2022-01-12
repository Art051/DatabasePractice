package Users;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Student {

	public String firstName = "";
	public String lastName = "";
	public String email = "";
	public String password = "";
	public String course = "";
	
	
	public Student(){
		setFirstName();
		setlastName();
		setEmail();
		setPassword();
		setCourse();
	}


	private String[] courses = {"Accounting", "Maths", "Physics", "History","English"};

	private Random rand = new Random();

	
	public void setFirstName() {

		String name = "";
		int countNames = 5163;
		Random random = new Random();
		int randNameLine = random.nextInt(1, countNames);

		FileReader file;
		try {
			file = new FileReader("src/NamesLists/firstNames.txt");
			BufferedReader buffReader = new BufferedReader(file);
			for(int i = 0; i< randNameLine; i++) 
				buffReader.readLine();

			name = buffReader.readLine();
			buffReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.firstName = name;
	}


	public void setlastName() {

		String name = "";
		int countNames = 3706;
		Random random = new Random();
		int randNameLine = random.nextInt(1, countNames);

		FileReader file;
		try {
			file = new FileReader("src/NamesLists/lastNames.txt");
			BufferedReader buffReader = new BufferedReader(file);
			for(int i = 0; i < randNameLine; i++) 
				buffReader.readLine();

			name = buffReader.readLine();
			buffReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.lastName = name;
	}


	public void setEmail() {

		String subFirst = firstName.substring(0,1);
		String subLast = lastName.substring(0,2);
		this.email = "stu." + subFirst + "." + subLast + "@A-Uni.com";
	}


	public void setPassword() {	
		Random rand = new Random();

		char[] passChar = new char[10];
		int currentCategory;

		for(int i = 0; i < passChar.length; i++) {
			currentCategory = rand.nextInt(1,7);
			int selection = 0;
			switch(currentCategory) {
			case(1) :
				selection = rand.nextInt(35, 48); 	break; // characters
			case(2) :
				selection = rand.nextInt(48,58);		break; // numbers
			case(3) : 
				selection = rand.nextInt(58,65);		break; // characters
			case(4) : 
				selection = rand.nextInt(65,91);		break; // uppercase
			case(5) : 
				selection = rand.nextInt(91,97);		break; // characters
			case(6) : 
				selection = rand.nextInt(97,123);	break; // lowercase
			}
			char currentChar = (char)selection;
			passChar[i] = currentChar;
		}

		String pass = new String(passChar);
		this.password = pass;
	}


	public void setCourse(){
		int randomCourse = rand.nextInt(0, 5);
		this.course = courses[randomCourse];
	}



	@Override
	public String toString() {
		return "First name:" + firstName + "\n" +
				"Last name: " + lastName + "\n" +
				"Email: " + email  	   	 + "\n" +
				"Password: " + password + "\n" + 
				"Course: " + course;
	}
}