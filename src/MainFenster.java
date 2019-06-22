
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainFenster extends JFrame {

    public MainFenster() {
        super("To-Do");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1600, 1000);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new BorderLayout());

        // Ein Panel, welches oben ist und den Knopf "Neue Aufgabe", und Zwei TextEingabeFelder und zwei TextLabel hat
        JPanel panel1 = new JPanel();
        add(panel1, BorderLayout.NORTH);
        panel1.setLayout(new FlowLayout());
        panel1.setBackground(Color.white);
        // Ein Panel, welches innerhalb von panel1 ist, um TextArea und Field zu erstellen
        JPanel panel2 = new JPanel();
        panel1.add(panel2);
        panel2.setLayout(new FlowLayout());

        // Die Label und Textfelder für die Eingabe von dem Aufgabennamen und der Deadline
        panel2.add(new JLabel("Aufgabe"));
        JTextField aufgabeFeld = new JTextField(10);
        panel2.add(aufgabeFeld);

        JTextField deadlineFeld = new JTextField(10);
        panel2.add(deadlineFeld);

        // Ein JPanel für die To-Do-Liste
        JPanel liste = new JPanel();
        add(liste, BorderLayout.CENTER);
        liste.setLayout(new BoxLayout(liste, BoxLayout.Y_AXIS));

        // Der Knopf zum Aufgaben-Hinzufügen wird erstellt 
        JButton neueAufgabe = new JButton("Neue Aufgabe");
        panel1.add(neueAufgabe);
        pack();
        neueAufgabe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liste.add(new GUIAufgabe());
                String eAufgabe = aufgabeFeld.getText();
                String eDeadline = deadlineFeld.getText();

                DBEintrag eintrag = new DBEintrag();
                eintrag.setAufgabe(eAufgabe);
                eintrag.setDeadline(eDeadline);
                eintrag.eingabe();

                pack();

            }

        });

    }
}
