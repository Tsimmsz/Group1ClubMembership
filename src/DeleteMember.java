import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class DeleteMember extends JFrame{
    private final JLabel searchLabel;
    private final JTextField searchField;
    private final JButton searchButton;
    
    public DeleteMember() {
        searchLabel = new JLabel("Enter a member ID to search:");
        searchField = new JTextField();
        searchButton = new JButton("Search");
    }

    public void displayDeleteMenue(){
        setLayout(new GridLayout(1,3));
        add(searchLabel);
        add(searchField);
        add(searchButton);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Long id = Long.parseLong(searchField.getText());
                deleteMember(id);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);
    }
    public void deleteMember(long id) {

        Connection conn = null;

        String SQL = "DELETE FROM members WHERE id = (id) "
                + "VALUES(?)";

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
