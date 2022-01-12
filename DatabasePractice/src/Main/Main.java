package Main;

import Database.DatabaseInteraction;
import Users.Student;

public class Main extends DatabaseInteraction{

	public static void main(String[] args)  {	

		
		DatabaseInteraction.showTables();
		DatabaseInteraction.showColumns();
		DatabaseInteraction.tableStructure();
		DatabaseInteraction.rowCount();
		DatabaseInteraction.printRows();


		for(int i = 0; i < 10; i ++) {
			Student stu1 = new Student();
			DatabaseInteraction.addStudent(stu1);
		}
	}
}