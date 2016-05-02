import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.math.*;

public class Aufgabe7 {
    public static void main(String[] args) {
        JFrame window = new Aufgabe7GUI();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Bibliothekssoftware");
        window.setSize(800, 600);
        window.setVisible(true);
    }
}

class Aufgabe7GUI extends JFrame {    
    private JMenuBar menuBar = new JMenuBar();
    
    private JMenu dateiMenu = new JMenu("Datei");
    private JMenu datenbankMenu = new JMenu("Datenbank");
    private JMenu fensterMenu = new JMenu("Fenster");
    private JMenu hilfeMenu = new JMenu("Hilfe");
    
    private JMenuItem menuItem1 = new JMenuItem("foo1");
    private JMenuItem menuItem2 = new JMenuItem("foo2");
    private JMenuItem menuItem3 = new JMenuItem("foo3");
    private JMenuItem menuItem4 = new JMenuItem("foo4");
    
    private JButton benutzerButton = new JButton("Neuen Benutzer hinzufügen");
    private JButton buecherButton = new JButton("Neue Bücher aufnehmen");
    private JButton verleihenButton = new JButton("Buch verleihen");
    private JButton zuruecknehmenButton = new JButton("Buch zurücknehmen");
    
    Aufgabe7GUI() {
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        
        content.add(benutzerButton);
        content.add(buecherButton);
        content.add(verleihenButton);
        content.add(zuruecknehmenButton);
        
        menuBar.add(dateiMenu);
        menuBar.add(datenbankMenu);
        menuBar.add(fensterMenu);
        menuBar.add(hilfeMenu);
        
        dateiMenu.add(menuItem1);
        datenbankMenu.add(menuItem2);
        fensterMenu.add(menuItem3);
        hilfeMenu.add(menuItem4);
        
        /*
        m_Btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { }
        });
        */
        
        this.setJMenuBar(menuBar);
        this.setContentPane(content);
        this.pack();
    }
}
