package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import Users.Student;

public class DatabaseInteraction {

	private static String database = System.getenv("DB_CONN");
	private static String username = System.getenv("DB_USER");
	private static String password = System.getenv("DB_PASS");
	
	public static void showTables() {

		String query = "show tables";

		try {
			Connection connect_string = DriverManager.getConnection(database, username, password);
			Statement sql_command = connect_string.prepareStatement(query);
			ResultSet result = sql_command.executeQuery(query);

			while(result.next()) {
				System.out.println("Tables within database: \n" + result.getString(1));
			}

			sql_command.close();
			System.out.println("Connection closed");
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void showColumns() {

		String query = "show columns FROM students";

		try {
			Connection connect_string = DriverManager.getConnection(database, username, password);
			Statement sql_command = connect_string.prepareStatement(query);
			ResultSet result = sql_command.executeQuery(query);

			System.out.println("Column titles:");

			while(result.next()) {
				System.out.println(result.getString(1));
			}

			sql_command.close();
			System.out.println("Connection closed");
		} 

		catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	public static void tableStructure() {

		String query = "DESC students";

		try {
			Connection connect_string = DriverManager.getConnection(database, username, password);
			Statement sql_command = connect_string.prepareStatement(query);
			ResultSet result = sql_command.executeQuery(query);

			System.out.println("Column structures:");

			while(result.next()) {
				System.out.print(result.getString(1) + " ");
				System.out.print(result.getString(2) + " ");
				System.out.print(result.getString(3) + " ");
				System.out.print(result.getString(4) + "\n");
			}

			sql_command.close();
			System.out.println("Connection closed");
		} 

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rowCount() {

		String query = "SELECT count(*) FROM students";

		int rowCount = 0;


		try { 
			Connection connect_string = DriverManager.getConnection(database, username, password);
			Statement sql_command = connect_string.prepareStatement(query);
			ResultSet result = sql_command.executeQuery(query);


			while(result.next()) {
				System.out.println("Count of rows: " + result.getInt(1));
			}

			sql_command.close();
			System.out.println("Connection closed");
			System.out.println("Total rows: " + rowCount);
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void printRows() {

		String query = "SELECT ID,first_name,last_name,email,password,course FROM students";

		try {
			Connection connect_string = DriverManager.getConnection(database, username, password);
			Statement sql_command = connect_string.prepareStatement(query);
			ResultSet result = sql_command.executeQuery(query);


			while(result.next()) {
				System.out.println("ID: " + result.getInt("ID"));
				System.out.println("First name: " + result.getString("first_name"));
				System.out.println("Last name: " + result.getString("last_name"));
				System.out.println("Email: " + result.getString("email"));
				System.out.println("Password: " + ("Password Hidden"));
				System.out.println("Course name: " + result.getString("course"));
			}

			sql_command.close();
			System.out.println("Connection closed");
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void addStudent(Student student) {

		String query = "INSERT INTO students(first_name,last_name,email,password,course)"
				+ "values(?,?,?,?,?)";

		try {
			Connection connect_string = DriverManager.getConnection(database, username, password);
			PreparedStatement prepStatement = connect_string.prepareStatement(query);

			prepStatement.setString(1, student.firstName);
			prepStatement.setString(2, student.lastName);
			prepStatement.setString(3, student.email);
			prepStatement.setString(4, student.password);
			prepStatement.setString(5, student.course);

			prepStatement.execute();			

			connect_string.close();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}
}