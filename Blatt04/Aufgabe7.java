import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.math.*;
import java.text.*;

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
    
    private JMenuItem menuItem1 = new JMenuItem("foo");
    private JMenuItem menuItem2 = new JMenuItem("foo");
    private JMenuItem menuItem3 = new JMenuItem("foo");
    private JMenuItem menuItem4 = new JMenuItem("foo");
    
    private JButton benutzenButton = new JButton("Neuen Benutzer hinzufügen");
    private JButton buecherButton = new JButton("Neue Bücher aufnehmen");
    private JButton verleihenButton = new JButton("Buch verleihen");
    private JButton zuruecknehmenButton = new JButton("Buch zurücknehmen");
        
    Aufgabe7GUI() {
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        
        content.add(benutzenButton);
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
        
        benutzenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {                
                JPanel myPanel = new JPanel(new GridLayout(0, 2, 10, 10));
                
                myPanel.add(new JLabel("Name:"));
                myPanel.add(new JTextField());
                myPanel.add(new JLabel("ID:"));
                myPanel.add(new JFormattedTextField(NumberFormat.getNumberInstance()));
                myPanel.add(new JLabel("Adresse:"));
                myPanel.add(new JTextField());
                myPanel.add(new JLabel("Geburtsdatum:"));
                myPanel.add(new JTextField());
                myPanel.add(new JLabel("Aufnahmedatum:"));
                myPanel.add(new JTextField());
                myPanel.add(new JCheckBox("Männlich"));
                myPanel.add(new JCheckBox("Weiblich"));
                
                int result = JOptionPane.showOptionDialog(
                    null,
                    myPanel, 
                   "Neuen Benutzer hinzufügen",
                   JOptionPane.YES_NO_CANCEL_OPTION,
                   JOptionPane.PLAIN_MESSAGE,
                   null,
                   new String[]{"Aufnehmen", "Abbrehen"},
                   "Aufnehmen"
               );
            }
        });
        
        buecherButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] schlagworte = {"Sonne", "Mond", "Stern", "Raumschiff", "Alien"};
                JPanel myPanel = new JPanel(new GridLayout(0, 2, 10, 10));
                
                myPanel.add(new JLabel("Titel:"));
                myPanel.add(new JTextField());
                myPanel.add(new JLabel("ISBN:"));
                myPanel.add(new JTextField());
                myPanel.add(new JCheckBox("Verliehen"));
                myPanel.add(new JCheckBox("Verfügbar"));
                myPanel.add(new JLabel("Entleiher ID:"));
                myPanel.add(new JFormattedTextField(NumberFormat.getNumberInstance()));
                myPanel.add(new JLabel("Schlagworte:"));
                myPanel.add(new JComboBox<>(schlagworte));
                
                int result = JOptionPane.showOptionDialog(
                    null,
                    myPanel, 
                   "Neue Bücher aufnehmen",
                   JOptionPane.YES_NO_CANCEL_OPTION,
                   JOptionPane.PLAIN_MESSAGE,
                   null,
                   new String[]{"Aufnehmen", "Abbrehen"},
                   "Aufnehmen"
               );
            }
        });
        
        verleihenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel myPanel = new JPanel(new GridLayout(0, 2, 10, 10));
                
                int result = JOptionPane.showOptionDialog(
                    null,
                    myPanel, 
                   "Buch verleihen",
                   JOptionPane.YES_NO_CANCEL_OPTION,
                   JOptionPane.PLAIN_MESSAGE,
                   null,
                   new String[]{"Verleihen", "Abbrehen"},
                   "Verleihen"
               );
            }
        });
        
        zuruecknehmenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JPanel myPanel = new JPanel(new GridLayout(0, 2, 10, 10));
                
                int result = JOptionPane.showOptionDialog(
                    null,
                    myPanel, 
                   "Buch zurücknehmen",
                   JOptionPane.YES_NO_CANCEL_OPTION,
                   JOptionPane.PLAIN_MESSAGE,
                   null,
                   new String[]{"Zurücknehmen", "Abbrehen"},
                   "Zurücknehmen"
               );
            }
        });
        
        this.setJMenuBar(menuBar);
        this.setContentPane(content);
        this.pack();
    }
}
