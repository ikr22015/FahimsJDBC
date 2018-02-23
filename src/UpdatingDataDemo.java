import java.sql.*;

public class UpdatingDataDemo {

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
            String sql = "update employees"
                    + " set age=30"
                    + " where id=1";

            myStmt.executeUpdate(sql);
            System.out.println("Update complete");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}


