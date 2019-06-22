
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GUIAufgabe extends JPanel {
    private String aufgabenLabel;
    private String deadlineLabel;
    
    public GUIAufgabe(){
        setVisible(true);
        setLayout(new FlowLayout());
        
        DBAusgabe ausgabe = new DBAusgabe();
        ausgabe.Ausgabe();
        
        JLabel eintragAufgabe = new JLabel(aufgabenLabel);
        JLabel eintragDeadline = new JLabel(deadlineLabel);
        
        
        
        
        
        //Label für Inhalt
        add(eintragAufgabe);
        add(eintragDeadline);
        add(new JButton("abschließen"));
        add(new JButton("verwerfen"));
        
    
}

    public void setAufgabenLabel(String aufgabenLabel) {
        this.aufgabenLabel = aufgabenLabel;
    }

    public void setDeadlineLabel(String deadlineLabel) {
        this.deadlineLabel = deadlineLabel;
    }
}
