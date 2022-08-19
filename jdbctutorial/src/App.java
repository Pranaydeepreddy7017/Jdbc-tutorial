import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        try {
        String url1 ="jdbc:mysql://localhost:3306/student_database";
        String uname="dev";
        String password="Pranay@1606";
        String query1 = "select * from student";
        String query2 = "insert into student values (0,'suryansh','13')";
        String query3 = "delete from student where class = '12'";
        String query4 = "update student set class='9' where class= '8'";
        String query5 = "select * from student";

        System.out.println("Hello, World!");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url1, uname, password);
       
        Statement st= con.createStatement();
        ResultSet rs = st.executeQuery(query1);             // Reading from the database 
        while (rs.next()){
        String result = rs.getString(1)+" "+rs.getString(2)+" "+ rs.getString(3);
        System.out.println(result);
        }


        int rowsinserted = st.executeUpdate(query2);         // Create / Writing to the database
        System.out.println("Rows effected "+ rowsinserted);


        int rowsdeleted = st.executeUpdate(query3);         // Deleting from the database
        System.out.println( "Rows deleted" + rowsdeleted);
        System.out.println("Deleted succesfully");

        int rowsupdated = st.executeUpdate(query4);
        System.out.println("Rows effected "+ rowsupdated);  //Updating the database


        ResultSet rs1 = st.executeQuery(query5);
        while (rs1.next()){
            String result1 = rs1.getString(1)+" "+rs1.getString(2)+" "+ rs1.getString(3);
            System.out.println(result1);
        }


        }catch (Exception e ){
            System.out.println(e.getMessage());
        }

    }
}
