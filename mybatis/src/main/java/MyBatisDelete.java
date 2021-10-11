import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisDelete { 

   public static void main(String args[]) throws IOException{
      
      Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
      SqlSession session = sqlSessionFactory.openSession(); 
	  
      //Delete operation
       deleteOperation(session,8);    
      session.commit();
      session.close();      
      
			
   }
   private static void deleteOperation(SqlSession session, int id) {
	   session.delete("Student.deleteById", id);
	   System.out.println("Record deleted successfully");
   }
   
}