import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddMember {

    public void addMember(String first_name, String last_name, String email, int dues_paid, String dues_paid_date, String renewal_date, String membership_level, String status) {
        
        
        long id = 0;

        Connection conn = null;

        String SQL = "INSERT INTO members(id, firstName, lastName, email, duesPaid, duesPaidDate, renewalDate, membershipLevel, status) "
                + "VALUES(?,?,?,?,?,?,?,?,?)";


        try {
            // db parameters
            String url       = "jdbc:mysql://localhost:3306/clubmembership";
            String user      = "root";
            String password  = "secret";
            
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            
            PreparedStatement pstmt = conn.prepareStatement(SQL,
            Statement.RETURN_GENERATED_KEYS);

            pstmt.setLong(1, id);
            pstmt.setString(2, first_name);
            pstmt.setString(3, last_name);
            pstmt.setString(4, email);
            pstmt.setInt(5, dues_paid);
            pstmt.setString(6, dues_paid_date);
            pstmt.setString(7, renewal_date);
            pstmt.setString(8, membership_level);
            pstmt.setString(9, status);

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows 
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if(conn != null)
                    conn.close();
            } catch(SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
    
}
