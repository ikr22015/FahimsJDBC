import java.sql.*;

public class PreparedStatementDemo {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String pass = "abc123";

        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try{
            //1. Get a connection to database
            myConn = DriverManager.getConnection(url, user, pass);

            //2. Prepare a statement
            myStmt = myConn.prepareStatement("select * from employees " +
                    "where id >? and age<?");

            //3. Set the parameters
            myStmt.setInt(1, 0);
            myStmt.setInt(2, 30);

            //4. Execute the query
            myRs = myStmt.executeQuery();

            //5. Display the result set
            while(myRs.next()){
                System.out.println(myRs.getString("id") + ", " +
                myRs.getString("name") + ", " +
                        myRs.getString("email") + ", " +
                myRs.getString("age"));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(myRs != null){
                myRs.close();
            }
            if(myStmt != null){
                myStmt.close();
            }
            if(myConn != null){
                myConn.close();
            }
        }
    }
}
