import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.text.*;


/*
 * Entry point for our application.
 */
public class Aufgabe9 {
    public static void main(String[] args) {
        Model model = new Model(-40, -40);
        View view = new View(model);
        model.addObserver(view);
    }
}


/*
 * Our model where the data and logic resides.
 */
class Model extends Observable {
    private int celsius = 0;
    private int fahrenheit = 0;
       
    Model(int celsius, int fahrenheit) {
        super();
        this.celsius = celsius;
        this.fahrenheit = fahrenheit;
    }
    
    public int getCelsius() {
        return celsius;
    }
    
    public int getFahrenheit() {
        return fahrenheit;
    }
    
    public void setCelsius(int celsius) {
        this.celsius = celsius;
        convert2fahrenheit();
    }
    
    public void setFahrenheit(int fahrenheit) {
        this.fahrenheit = fahrenheit;
        convert2celsius();
    }
    
    public void convert2celsius() {
        double cel = ((double)this.fahrenheit - 32) * 5/9;
        this.celsius = (int)cel;
        setChanged();
        notifyObservers();
    }
    
    public void convert2fahrenheit() {
        double fah = (double)this.celsius * 1.8 + 32;
        this.fahrenheit = (int)fah;
        setChanged();
        notifyObservers();
    }
}


/*
 * Our view taking care of all ui-components
 */
class View implements Observer {    
    private Model model = null;
    private JFrame frame = new JFrame("Temperature Converter - MVC-Model");
    private JPanel content = new JPanel();
    private JLabel cLabel = new JLabel("Celsius");
    private JLabel fLabel = new JLabel("Fahrenheit");
    private JButton cButton = new JButton("Convert2Celsius ->");
    private JButton fButton = new JButton("<- Convert2Fahrenheit");
    private JSlider fSlider = new JSlider(JSlider.VERTICAL, -40, 140, -40);
    private JSlider cSlider = new JSlider(JSlider.VERTICAL, -40, 70, -40);
    private JTextField cField = new JTextField(4);
    private JTextField fField = new JTextField(4);

    View(Model model) {
        this.model = model;
        
        fSlider.setMajorTickSpacing(40);
        fSlider.setMinorTickSpacing(5);
        fSlider.setPaintTicks(true);
        fSlider.setPaintLabels(true);
        
        cSlider.setMajorTickSpacing(25);
        cSlider.setMinorTickSpacing(5);
        cSlider.setPaintTicks(true);
        cSlider.setPaintLabels(true);
        
        cField.setText("-40");
        fField.setText("-40");
        
        content.setLayout(new FlowLayout());
        content.add(fSlider);
        content.add(fLabel);
        content.add(fField);
        content.add(cButton);
        content.add(fButton);
        content.add(cField);
        content.add(cLabel);
        content.add(cSlider);
        
        frame.setContentPane(content);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(740, 260);
        frame.setVisible(true);
        
        addControllers();
    }
    
    public void update(Observable obs, Object obj) {
        Model model = (Model)obs;
        
        cField.setText(""+model.getCelsius());
        fField.setText(""+model.getFahrenheit());
        cSlider.setValue((int)model.getCelsius());
        fSlider.setValue((int)model.getFahrenheit());
    }
    
    public void addControllers(){
		cButton.addActionListener(new ButtonController() {
            public void actionPerformed(ActionEvent e) {
                try {
                    model.setFahrenheit(Integer.parseInt(fField.getText()));
                } catch (NumberFormatException ex) {
                    model.setFahrenheit(0);
                }
                
            }
        });
        
		fButton.addActionListener(new ButtonController() {
            public void actionPerformed(ActionEvent e) {
                try {
                    model.setCelsius(Integer.parseInt(cField.getText()));
                } catch (NumberFormatException ex) {
                    model.setCelsius(0);
                }
                
            }
        });
        
		cSlider.addChangeListener(new SliderController() {
            public void stateChanged(ChangeEvent e) {
                model.setCelsius((int)cSlider.getValue());
            }
        });
        
		fSlider.addChangeListener(new SliderController() {
            public void stateChanged(ChangeEvent e) {
                model.setFahrenheit((int)fSlider.getValue());
            }
        });
	}
}


/*
 * These abstract classes don't serve any other purpose but
 * to show what the controllers are. The actual controller
 * logic is in anonymous classes in the view because it
 * differs for each ui-component.
 */
abstract class ButtonController implements ActionListener {
	ButtonController() {
	}
	
	public abstract void actionPerformed(ActionEvent e);
}
abstract class SliderController implements ChangeListener {
	SliderController() {
	}
	
	public abstract void stateChanged(ChangeEvent e);
}
