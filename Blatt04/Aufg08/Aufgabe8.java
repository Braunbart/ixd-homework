/*
 * TODO: Comments
 * TODO: Keyboard shortcuts
 * TODO: Look and feel
 * TODO: Address fields
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.math.*;
import java.text.*;

public class Aufgabe8 {
    public static void main(String[] args) {
        JFrame window = new Aufgabe8GUI();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Bibliothekssoftware");
        window.setSize(300, 300);
        window.setVisible(true);
    }
}

class Aufgabe8GUI extends JFrame {    
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

    private JButton benutzenButton = new JButton("Benutzer hinzufügen");
    private JButton buecherButton = new JButton("Bücher aufnehmen");
    private JButton verleihenButton = new JButton("Buch verleihen");
    private JButton zuruecknehmenButton = new JButton("Buch zurücknehmen");
        
    Aufgabe8GUI() {
        JPanel content = new JPanel();
        content.setLayout(new GridLayout(0,1,10,10));
        
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

        benutzenButton.setMnemonic(KeyEvent.VK_H);
        buecherButton.setMnemonic(KeyEvent.VK_A);
        verleihenButton.setMnemonic(KeyEvent.VK_V);
        zuruecknehmenButton.setMnemonic(KeyEvent.VK_Z);

        dateiMenu.setMnemonic(KeyEvent.VK_D);
        datenbankMenu.setMnemonic(KeyEvent.VK_T);
        fensterMenu.setMnemonic(KeyEvent.VK_F);
        hilfeMenu.setMnemonic(KeyEvent.VK_H);

        benutzenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {                
                JPanel myPanel = new AddUserPane();
                                
                int result = JOptionPane.showOptionDialog(
                    null,
                    myPanel, 
                   "Benutzer hinzufügen",
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
                   "Bücher aufnehmen",
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
		JPanel radioPanel = new JPanel();
		ButtonGroup radioGroup = new ButtonGroup();
		JRadioButton male = new JRadioButton("Männlich");
		JRadioButton female = new JRadioButton("Weiblich");
		radioGroup.add(male);
		radioGroup.add(female);	
		radioPanel.add(male);
		radioPanel.add(female);	

		this.setLayout(new GridLayout(0,2,10,10));
		this.add(new JLabel("Name:"));
                this.add(new JTextField());
                this.add(new JLabel("ID:"));
                this.add(new JFormattedTextField(NumberFormat.getNumberInstance()));
                this.add(new JLabel("Adresse:"));
                this.add(new JTextField());
                this.add(new JLabel("Geburtsdatum (TT MM JJJJ):"));
                this.add(new DatePane());
                this.add(new JLabel("Aufnahmedatum (TT MM JJJJ):"));
                this.add(new DatePane());
                this.add(new JLabel("Geschlecht:"));
                this.add(radioPanel);
	}
}

class AddBookPane extends JPanel {
	public AddBookPane() {
		String[] schlagworte = {"Sonne", "Mond", "Stern", "Raumschiff", "Alien"};	
        JComboBox<String> schlagworteList = new JComboBox<>(schlagworte);
        schlagworteList.setEditable(true);
		this.setLayout(new GridLayout(0,2,10,10));

		this.add(new JLabel("Titel:"));
        this.add(new JTextField());
        this.add(new JLabel("ISBN:"));
        this.add(new JTextField());
        this.add(new JLabel("Verleihstatus:"));
        this.add(new JCheckBox("Verliehen"));
        this.add(new JLabel("Entleiher ID:"));
        this.add(new JFormattedTextField(NumberFormat.getNumberInstance()));
        this.add(new JLabel("Schlagworte:"));
        this.add(schlagworteList);
	}
}

class VerleihBuchPane extends JPanel {
	public VerleihBuchPane() {
		this.setLayout(new GridLayout(0,2,10,10));

		this.add(new JLabel("Buch ID:"));
		this.add(new JTextField());	
		this.add(new JLabel("Entleiher ID:"));
		this.add(new JTextField());	
		this.add(new JLabel("Frist (TT MM JJJJ):"));
		this.add(new DatePane());	
	}
}

class ZurueckPane extends JPanel {
	public ZurueckPane() {
		this.setLayout(new GridLayout(0,2,10,10));

		this.add(new JLabel("Buch ID:"));
		this.add(new JTextField());	
	}
}

class DatePane extends JPanel {
	public DatePane() {
		this.setLayout(new GridLayout(0,3,10,0));

		this.add(new JTextField(2));	
		this.add(new JTextField(2));	
		this.add(new JTextField(4));
	}
}
