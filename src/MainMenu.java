import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MainMenu extends JFrame {

    // private final JTextPane welcomeTextPane;
    private final JButton addButton;
    private final JButton updateButton;
    private final JButton deleteButton;
    private final JButton reportButton;

    public MainMenu() {
        // welcomeTextPane = new JTextPane();
        addButton = new JButton("Add new Member");
        updateButton = new JButton("Update a Member");
        deleteButton = new JButton("Delete a Member");
        reportButton = new JButton("Generate a Report");
    }

    public void displayMenu() {
        setLayout(new GridLayout(4, 1));
        add(addButton);
        add(updateButton);
        add(deleteButton);
        add(reportButton);

        setTitle("Club Membership Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }

    public static void main(String[] args) throws Exception {
        MainMenu main = new MainMenu();
        main.displayMenu();
    }
}
