import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Report {
    private JFrame frame;
    private JComboBox<string> reportTypeDropdown;
    private JButton submiButton;
    private JButton cancelButton;

    public Report() {
        frame = new JFrame("Report Options");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout);

        JLabel titLabel = new JLabel("Report Options");
        frame.add(titleLabel1, BorderLayout.North);
    }
}