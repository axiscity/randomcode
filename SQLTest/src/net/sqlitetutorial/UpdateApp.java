package net.sqlitetutorial;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
/**
 *
 * @author sqlitetutorial.net
 */
public class UpdateApp {
 
    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/tests.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
 
    /**
     * Update data of a warehouse specified by the id
     *
     * @param id
     * @param name name of the warehouse
     * @param capacity capacity of the warehouse
     */
    
/*    String sql = "CREATE TABLE IF NOT EXISTS card (\n"
            + "    id integer PRIMARY KEY,\n"
            + "    name text NOT NULL,\n"
            + "    greeting1 text\n"
            + "    greeting2 text\n"
            + "    greeting3 text\n"
            + "    picture1 BLOB\n"
            + "    picture2 BLOB\n"
            + ");";*/
    
    public void update(int id, String name, String greeting1) {
        String sql = "UPDATE card SET name = ? , "
                + "greeting1 = ? ,"
                + "greeting2 = ? ,"
                + "greeting3 = ? ,"
                + "picture1 = ? ,"
                + "picture2 = ? "
                + "WHERE id = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, name);
            pstmt.setString(2, greeting1);
            pstmt.setString(3, greeting1);
            pstmt.setString(4, greeting1);
            pstmt.setString(5, greeting1);
            pstmt.setString(6, greeting1);
            pstmt.setInt(7, id);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        UpdateApp app = new UpdateApp();
        // update the warehouse with id 3
        app.update(3, "Finished Products", "pickle");
    }
 
}