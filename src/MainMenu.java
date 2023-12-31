import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MainMenu extends JFrame {

    private final JButton addButton;
    private final JButton updateButton;
    private final JButton deleteButton;
    private final JButton reportButton;

    public MainMenu() {
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

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddMember addMember = new AddMember();
                addMember.displayAddMember();
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

        setTitle("Club Membership Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);

    }

    public static void main(String[] args) throws Exception {
        MainMenu main = new MainMenu();
        main.displayMenu();
    }
}
