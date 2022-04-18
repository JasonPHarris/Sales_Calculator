package account;

/**
 *
 * @author Jason Harris
 */
// importing scanner to get user input
import java.util.*;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.text.*;


// creating sales class
public class Sales extends JFrame
{   
    // decimal format
    DecimalFormat dot = new DecimalFormat(".0000");
    
    // variables for the math
    double x, y;
    
    // creating labels
    JLabel instructions1 = new JLabel("Enter values or '0' for default "
            + "value:");
    JLabel accountLabel = new JLabel("Account ID:");
    JLabel hrsLabel = new JLabel("Service Hours:");
    JLabel rateLabel = new JLabel("Hourly Rate:");
    JLabel amountLabel = new JLabel("Amount of Items:");
    JLabel priceLabel = new JLabel("Price Per Item:");
        
    // creating text fields
    final JTextField accountField = new JTextField(10);
    final JTextField hrsField = new JTextField(10);
    final JTextField rateField = new JTextField(10);
    final JTextField amountField = new JTextField(10);
    final JTextField priceField = new JTextField(10);
    final JTextField laborField = new JTextField(10);
    final JTextField matField = new JTextField(10);
    final JTextField totalField = new JTextField(10);
                
    // creating buttons
    JButton addBtn = new JButton("Calculate");
    
    // creating layout and button functions
    public Sales()
    {
        // Layouts aka adding the fields labels and buttons
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        add(instructions1);
        add(accountLabel);
        add(accountField);
        add(hrsLabel);
        add(hrsField);
        add(rateLabel);
        add(rateField);
        add(new JLabel("Total Labor:"));
        add(laborField);
        laborField.setEnabled(false); // disable for user input
        add(amountLabel);
        add(amountField);
        add(priceLabel);
        add(priceField);
        add(new JLabel("Total Materials:"));
        add(matField);
        matField.setEnabled(false); // disable for user input
        add(new JLabel("Grand Total:"));
        add(totalField);
        totalField.setEnabled(false); // disabled for user input
        add(addBtn);
        
        // creating the button function for 'Calculate'
        addBtn.addActionListener
            (
                    new ActionListener()
                        {
                            public void actionPerformed(ActionEvent e){
                                // gets the input in the fields
                                String account = accountField.getText();
                                String hrs = hrsField.getText();
                                String rate = rateField.getText();
                                String amount = amountField.getText();
                                String price = priceField.getText();
                                
                                // converts to proper int or double
                                int acc = Integer.parseInt(account);
                                double hours1 = Double.parseDouble(hrs);
                                double rate1 = Double.parseDouble(rate);
                                int amount1 = Integer.parseInt(amount);
                                double price1 = Double.parseDouble(price);
                                
                                // displaying calculations via 
                                // creating account array
                                int[] accountList;
                                accountList = new int[2];
        
                                // assign values based on input perform 
                                // calculations and print to GUI
                                for (int i = 0; i < accountList.length; i++) 
                                {
            
                                accountList[i] = i;
                                        
                                if (acc == 0)
                                    {
                                    // creating class instance via inheritance
                                        Account a1= new Account();
                                        // Display default account information
                                        String value = String.valueOf(a1); 
                                        accountField.setText(value);
                                    }
                                else
                                    {
                                    // creating class instance from user input
                                        Account a2 = new Account(acc);
                                        // Display input account information
                                        String value = String.valueOf(a2); 
                                        accountField.setText(value);
                                    }
                                // Create service objects passing in user input
                                if(hours1==0)
                                   {
                                    // creating class instance via inheritance
                                        Services se1= new Services();
                                        // Display default service information
                                        String value = String.valueOf(se1); 
                                        laborField.setText(value);
                                        double x = Double.parseDouble(value);
                                    }
                                else
                                    {
                                    // creating class instance from user input
                                        Services se2 = new Services(hours1, 
                                                rate1);
                                        // Display input service information
                                        String value = String.valueOf(se2); 
                                        laborField.setText(value);
                                        double x = Double.parseDouble(value);
                                    }
                                if(amount1==0)
                                    {
                                    // creating class instance via inheritance
                                        Supplies su1= new Supplies();
                                        // Display default supply information
                                        String value = String.valueOf(su1); 
                                        matField.setText(value);
                                        double y = Double.parseDouble(value);
                                        double result = x+y;
                                        String value1 = String.valueOf(result); 
                                        totalField.setText(value1);
                                    }
                                else
                                    {
                                    // creating class instance from user input
                                    Supplies su2 = new Supplies(amount1, price1);
                                    // Display input supply information
                                    String value = String.valueOf(su2); 
                                    matField.setText(value);
                                    double y = Double.parseDouble(value);
                                    double result = x+y;
                                    String value1 = String.valueOf(result); 
                                    totalField.setText(value1);
                                    }                                
                                }    
                            }
                        }
            );

    }
                        
            
    // creating main to run program create the frame that will do the work
    public static void main(String[] args) 
    {
        Sales frame = new Sales(); // creating frame
        frame.setTitle("Sales Calculator"); // setting the window title
        frame.setLocationRelativeTo(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1075,150); // setting default size
        frame.setVisible(true); // making frame visible        
    }
    
}
