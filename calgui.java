import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.sql.*;
import java.util.ArrayList;
//https://www.javatpoint.com/notepad
//http://zetcode.com/tutorials/javaswingtutorial/firstprograms/
//https://stackoverflow.com/questions/20204437/im-trying-to-create-a-numeric-keypad-that-has-a-clear-button-and-a-piece-on-top
public class calgui extends JFrame{
    
    Random rand4 = new Random();
int  Roll_D4 = rand4.nextInt(4) + 1;
//4 is the maximum and the 1 is our minimum 
    
    
    // class attributes
    String numberString = "";
    int but_x_base = 40;
    int but_y_pos = 40;
    int but_width = 60;
    int but_height = 40;
    JTextField txtf = new JTextField();
    JTextField txth1 = new JTextField();
    JTextField txth2 = new JTextField();
    JTextField txth3 = new JTextField();
	JTextField txth4 = new JTextField();
    JTextField txth5 = new JTextField();
    JTextField txth6 = new JTextField();
	JTextField txth7 = new JTextField();
    JPanel pd4 = new JPanel();
    JButton d4 = new JButton("d4");
    JPanel pd6 = new JPanel();
    JButton d6 = new JButton("d6");
    JPanel pd8 = new JPanel();
    JButton d8 = new JButton("d8");
    JPanel pd10 = new JPanel();
    JButton d10 = new JButton("d10");
    JPanel pd12 = new JPanel();
    JButton d12 = new JButton("d12");
    JPanel pd20 = new JPanel();
    JButton d20 = new JButton("d20");
    JPanel pd100 = new JPanel();
    JButton d100 = new JButton("d100");
    JButton bC = new JButton("Clear");
	JButton bCH = new JButton("Clear All");
    ImageIcon icon; 
    
    
    // override constructor
    public calgui(){
        
        // This defines the JFrame
        JFrame f = new JFrame("Button Example");
        f.setTitle("Dice Roller");
		f.setIconImage(new ImageIcon("Icon1.png").getImage());
        f.setSize(800,800);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //trying to change the Icon vvv
        //f.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource()));
        
        //Setting images to buttons
        d4.setIcon(new ImageIcon("D4.png"));
        pd4.add(d4);
        add(pd4);
        d6.setIcon(new ImageIcon("D6.png"));
        pd6.add(d6);
        add(pd6);
        d8.setIcon(new ImageIcon("D8.png"));
        pd8.add(d8);
        add(pd8);       
        d10.setIcon(new ImageIcon("D10.png"));
        pd10.add(d10);
        add(pd10);
        d12.setIcon(new ImageIcon("D12.png"));
        pd12.add(d12);
        add(pd12);
        d20.setIcon(new ImageIcon("D20.png"));
        pd20.add(d20);
        add(pd20);
        d100.setIcon(new ImageIcon("D100.png"));
        pd100.add(d100);
        add(pd100);
        
        validate();
        // defines objects on the JFrame
        txtf.setBounds(but_x_base + 10,but_y_pos + 10,but_width + 100,but_height - 10);
        txth1.setBounds(but_x_base + 320,but_y_pos + 50,but_width + 80,but_height - 10);
        txth2.setBounds(but_x_base + 320,but_y_pos + 80,but_width + 80,but_height - 10);
        txth3.setBounds(but_x_base + 320,but_y_pos + 110,but_width + 80,but_height - 10);
        txth4.setBounds(but_x_base + 320,but_y_pos + 140,but_width + 80,but_height - 10);
        txth5.setBounds(but_x_base + 320,but_y_pos + 170,but_width + 80,but_height - 10);
        txth6.setBounds(but_x_base + 320,but_y_pos + 200,but_width + 80,but_height - 10);
		txth7.setBounds(but_x_base + 320,but_y_pos + 230,but_width + 80,but_height - 10);
        d4.setBounds(but_x_base + 10,but_y_pos + 100,but_width + 30,but_height + 45);
        d4.setBorder(null);
        d6.setBounds(but_x_base + 120,but_y_pos + 100,but_width + 30,but_height + 45);
        d6.setBorder(null);
        d8.setBounds(but_x_base + 10,but_y_pos + 200,but_width + 30,but_height + 45);
        d8.setBorder(null);
        d10.setBounds(but_x_base + 120,but_y_pos + 200,but_width + 28,but_height + 45);
        d10.setBorder(null);
        d12.setBounds(but_x_base + 10,but_y_pos + 300,but_width + 20,but_height + 45);
        d12.setBorder(null);
        d20.setBounds(but_x_base + 120,but_y_pos + 300,but_width + 30,but_height + 45);
        d20.setBorder(null);
        d100.setBounds(but_x_base + 60,but_y_pos + 400,but_width + 30,but_height + 45); 
        d100.setBorder(null);
        bC.setBounds(but_x_base + 180,but_y_pos + 10,but_width + 60,but_height - 10);  
		bCH.setBounds(but_x_base + 320,but_y_pos + 10,but_width + 80,but_height - 10);		
		
        ButtonListener listener = new ButtonListener();
        // adds listeners to the buttons
        d4.addActionListener(listener);
        d6.addActionListener(listener);
        d8.addActionListener(listener);
        d10.addActionListener(listener);
        d12.addActionListener(listener);
        d20.addActionListener(listener);        
        d100.addActionListener(listener);       
        bC.addActionListener(listener);
		bCH.addActionListener(listener);
		
        
        // adds the objects to the JFrame
        f.add(txtf);
		f.add(txth1);
		f.add(txth2);
		f.add(txth3);
		f.add(txth4);
		f.add(txth5);
		f.add(txth6);
		f.add(txth7);
        f.add(d4);
        f.add(d6);
        f.add(d8);
        f.add(d10);
        f.add(d12);
        f.add(d20);
        f.add(d100);
        f.add(bC);
		f.add(bCH);
        
        // makes it visible
        f.setVisible(true);  
    }
    public static void main(String args[]) {
        // Creates the JFrame by calling the override constructor
        new calgui();
    }
    
    
    // this is a class method that is called each time a button
    // with a listener is pressed
    class ButtonListener implements ActionListener {
        
        
        
        @Override
        
            
        
        public void actionPerformed(ActionEvent e) {
        Random rand4 = new Random();
        
        //clears the current input
        numberString = "";
        txtf.setText("");
        
        int  Roll_D4 = rand4.nextInt(4) + 1;
        //4 is the maximum and the 1 is our minimum 
            if (e.getSource() == d4) {
                numberString += Roll_D4;
                txtf.setText("The roll for the d4 is: " + numberString);
				txth1.setText("The last d4 rolled: " + numberString);
                
            } 
            
            Random rand6 = new Random();
            int Roll_D6 = rand6.nextInt(6) + 1;
            //6 is the maximum and 1 is the minimum
            if (e.getSource() == d6) {
                numberString += Roll_D6;
                txtf.setText("The roll for the d6 is: " + numberString);
				txth2.setText("The last d6 rolled: " + numberString);
            }
            
                Random rand8 = new Random();
            int Roll_D8 = rand8.nextInt(8) + 1;
            //8 is the maximum and 1 is the minimum
            if (e.getSource() == d8) {
                numberString += Roll_D8;
                txtf.setText("The roll for the d8 is: " + numberString);
               txth3.setText("The last d8 rolled: " + numberString);
            }
            
                Random rand10 = new Random();
            int Roll_D10 = rand10.nextInt(10) + 1;
            //10 is the maximum and 1 is the minimum
            if (e.getSource() == d10) {
                numberString += Roll_D10;
                txtf.setText("The roll for the d10 is: " + numberString);
				txth4.setText("The last d10 rolled: " + numberString);
                
            }
            
                    Random rand12 = new Random();
            int Roll_D12 = rand12.nextInt(12) + 1;
            //12 is the maximum and 1 is the minimum
            if (e.getSource() == d12) {
                numberString += Roll_D12;
                txtf.setText("The roll for the d12 is: " + numberString);
				txth5.setText("The last d12 rolled: " + numberString);
                
            }
            
                    Random rand20 = new Random();
            int Roll_D20 = rand20.nextInt(20) + 1;
            //20 is the maximum and 1 is the minimum
            if (e.getSource() == d20) {
                numberString += Roll_D20;
                txtf.setText("The roll for the d20 is: " + numberString);
				txth6.setText("The last d20 rolled: " + numberString);
                
            }
                    Random rand100 = new Random();
            int Roll_D100 = rand100.nextInt(100) + 1;
            //100 is the maximum and 1 is the minimum
            if (e.getSource() == d100) {
                numberString += Roll_D100;
                txtf.setText("The roll for the d100 is: " + numberString);
				txth7.setText("The last d100 rolled: " + numberString);

            }   if (e.getSource() == bCH) {
                numberString = "";
                txth1.setText("");
                txth2.setText("");
                txth3.setText("");
                txth4.setText("");
                txth5.setText("");
                txth6.setText("");				
            
            } else if (e.getSource() == bC) {
                numberString = "";
                txtf.setText("");
            }
        }
    }
}

	