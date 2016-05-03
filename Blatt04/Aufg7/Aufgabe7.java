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
    
    private JMenuItem menuItem1 = new JMenuItem("Beenden");
    
    private JMenuItem menuItem2 = new JMenuItem("Verbindung herstellen");
    private JMenuItem menuItem3 = new JMenuItem("Verbindung trennen");
    private JMenuItem menuItem4 = new JMenuItem("Benutzer Verwalten");
    private JMenuItem menuItem5 = new JMenuItem("Bücher Verwalten");
    
    private JMenuItem menuItem6 = new JMenuItem("Übersicht anzeigen");

    private JMenuItem menuItem7 = new JMenuItem("Info");

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
        datenbankMenu.add(menuItem3);
        datenbankMenu.add(menuItem4);
        datenbankMenu.add(menuItem5);        

        fensterMenu.add(menuItem6);
        hilfeMenu.add(menuItem7);

        benutzenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {                
                JPanel myPanel = new AddUserPane();
                                
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
                
                JPanel myPanel = new AddBookPane();
                
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
                JPanel myPanel = new VerleihBuchPane();
                
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
                JPanel myPanel = new ZurueckPane();
                
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

class AddUserPane extends JPanel {
	public AddUserPane() {
		
		this.setLayout(new GridLayout(0,2));
		this.add(new JLabel("Name:"));
                this.add(new JTextField());
                this.add(new JLabel("ID:"));
                this.add(new JFormattedTextField(NumberFormat.getNumberInstance()));
                this.add(new JLabel("Adresse:"));
                this.add(new JTextField());
                this.add(new JLabel("Geburtsdatum:"));
                this.add(new JTextField());
                this.add(new JLabel("Aufnahmedatum:"));
                this.add(new JTextField());
                this.add(new JCheckBox("Männlich"));
                this.add(new JCheckBox("Weiblich"));	
	}
}

class AddBookPane extends JPanel {
	public AddBookPane() {
		String[] schlagworte = {"Sonne", "Mond", "Stern", "Raumschiff", "Alien"};		

		this.setLayout(new GridLayout(0,2));

		this.add(new JLabel("Titel:"));
                this.add(new JTextField());
                this.add(new JLabel("ISBN:"));
                this.add(new JTextField());
                this.add(new JCheckBox("Verliehen"));
                this.add(new JCheckBox("Verfügbar"));
                this.add(new JLabel("Entleiher ID:"));
                this.add(new JFormattedTextField(NumberFormat.getNumberInstance()));
                this.add(new JLabel("Schlagworte:"));
                this.add(new JComboBox<>(schlagworte));
	}
}

class VerleihBuchPane extends JPanel {
	public VerleihBuchPane() {
		this.setLayout(new GridLayout(0,2));

		this.add(new JLabel("Buch ID:"));
		this.add(new JTextField());	

		this.add(new JLabel("Entleiher ID:"));
		this.add(new JTextField());	

		this.add(new JLabel("Frist:"));
		this.add(new JTextField());	
	}
}

class ZurueckPane extends JPanel {
	public ZurueckPane() {
		this.setLayout(new GridLayout(0,2));

		this.add(new JLabel("Buch ID:"));
		this.add(new JTextField());	

		
	}
}
