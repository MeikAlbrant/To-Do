
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GUIAufgabe extends JPanel {
    public GUIAufgabe(){
        setVisible(true);
        setLayout(new FlowLayout());
        
        
        
        //Label für Inhalt
        add(new JLabel("Hier wird die Aufgabe stehen"));
        add(new JLabel("DD.MM.YYYY"));
        add(new JButton("abschließen"));
        add(new JButton("verwerfen"));
        
    
}
}
