import java.io.*;
import java.util.*;
import java.sql.*;
class Question5
{
    // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/HMS";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "Kaushik@7";
    public static void main(String[] args) throws IOException
    {
        Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();

      String sql = "SELECT TOP * FROM DOCTOR";
      ResultSet rs = stmt.executeQuery(sql);
      while(rs.next()){
        //Retrieve by column name
        int id  = rs.getInt("id");
        int age = rs.getInt("age");

        //Display values
        System.out.print("ID: " + id);
        System.out.print(", Age: " + age);
     }
     rs.close();
    }
    catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
     }catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
     }finally{
        //finally block used to close resources
        try{
           if(stmt!=null)
              conn.close();
        }catch(SQLException se){
        }// do nothing
        try{
           if(conn!=null)
              conn.close();
        }catch(SQLException se){
           se.printStackTrace();
        }//end finally try
     }//end try
    }
}