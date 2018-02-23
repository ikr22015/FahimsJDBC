import java.sql.*;

public class InsertingDataDemo {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String pass = "abc123";

        try{
            //1. Get a connection to database
            Connection myConn = DriverManager.getConnection(url, user, pass);

            //2. Create a statement
            Statement myStmt = myConn.createStatement();

            //3. Execute the SQL Query
            String sql = "insert into employees"
                    + "(id, name, email, age)"
                    + "values(3, 'Maria', 'maria2993@hotmail.com', 22)";

            myStmt.executeUpdate(sql);

            System.out.println("Insertion Complete");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
