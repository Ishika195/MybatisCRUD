import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUpdate {

	public static void main(String args[]) throws IOException {

		Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlSessionFactory.openSession();

		// select a particular student using id
		updateTable(session);
		// verifying the record
		readChanges(session, 4);
		session.commit();
		session.close();
	}

	private static void readChanges(SqlSession session, int id) {
		Student std = (Student) session.selectOne("Student.getById", id);
		System.out.println("Details of the student after update operation");
		System.out.println(std.toString());

	}

	private static void updateTable(SqlSession session) {
		Student student = (Student) session.selectOne("Student.getById", 8);
		System.out.println("Current details of the student are");
		System.out.println(student.toString());

		// Set new values to the mail and phone number of the student
		student.setName("Ishika");
		student.setEmail("ishika1237899@yahoo.com");
		student.setPhone(700988260);
		// Update the student record
		session.update("Student.update", student);
		System.out.println("Record updated successfully");
	}
}