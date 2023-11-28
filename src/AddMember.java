import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import java.awt.*;
import javax.swing.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddMember extends JFrame{

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

    // private final JTextPane welcomeTextPane;
    private final String[] membershipLevels = {"Level 1", "Level 2", "Level 3"};
    private final String[] memberStatus = {"Active", "Inactive"};

    private final JTextField id;
    private final JTextField lastName;
    private final JTextField firstName;
    private final JTextField email;
    private final JTextField duesPaid;
    private final JTextField duesPaidDate;
    private final JTextField renewalDate;
    private final JComboBox membershipLevel;
    private final JComboBox status;

    public AddMember() {
        // welcomeTextPane = new JTextPane();
        id = new JTextField("ID");
        firstName = new JTextField("First name");
        lastName = new JTextField("Last Name");
        email = new JTextField("Email");
        duesPaid = new JTextField("Dues Paid");
        duesPaidDate = new JTextField("Date Dues Paid");
        renewalDate = new JTextField("Renewal Date");
        membershipLevel = new JComboBox(membershipLevels);
        status = new JComboBox(memberStatus);
    }

    public void displayAddMember() {
        setLayout(new GridLayout(4, 1));
        add(id);
        add(firstName);
        add(lastName);
        add(email);
        add(duesPaid);
        add(duesPaidDate);
        add(renewalDate);
        add(membershipLevel);
        add(status);

        setTitle("Club Membership Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);
    }
    
}
