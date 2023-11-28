import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateMember {
    public void updateMember(String first_name, String last_name, String email, int dues_paid, String dues_paid_date, String renewal_date, String membership_level, String status) {

        long id = 0;

        Connection conn = null;

        String SQL = "UPDATE members SET (firstName, lastName, email, duesPaid, duesPaidDate, renewalDate, membershipLevel, status) " 
                + "WHERE (id)"
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

            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, email);
            pstmt.setInt(4, dues_paid);
            pstmt.setString(5, dues_paid_date);
            pstmt.setString(6, renewal_date);
            pstmt.setString(7, membership_level);
            pstmt.setString(8, status);
            pstmt.setLong(9, id);

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
