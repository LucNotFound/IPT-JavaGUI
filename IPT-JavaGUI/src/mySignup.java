import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class mySignup extends JFrame implements ActionListener{

    Container container = getContentPane();
    private JLabel lblTitle, lblFirstName, lblLastName, labelUsername, lblPass, lblCPass; 
    private JTextField tfFirstName, tfLastName, tfUser;
	private JPasswordField passField, CPassField;
	private JButton btnRegister, btnBack;
	private JToggleButton showPass, showCPass;
    private ImageIcon eyeIcon = new ImageIcon("src/eye_button.png");

    
    public mySignup(){
        setUndecorated(true);
        setLocation(750, 300);
        setSize(400, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        setComponentsCharacteristics();
        addComponentsToContainer();
        setLayoutManager();
        addActionEvent();
        
        setVisible(true);

    }
    public void setComponentsCharacteristics(){

            lblTitle = new JLabel("Sign Up");
            lblTitle.setFont(new Font("ARIAL BLACK", Font.BOLD, 30));
            lblTitle.setBounds(135, 0, 300, 100);

            lblFirstName = new JLabel("First Name");
            lblFirstName.setFont(new Font("ARIAL BLACK", Font.PLAIN, 10));
            lblFirstName.setBounds(80, 100, 100, 30);

            tfFirstName = new JTextField(15);
            tfFirstName.setFont(new Font("ARIAL", Font.PLAIN, 15));
            tfFirstName.setBounds(80, 125, 240, 30);

            lblLastName = new JLabel("Last Name");
            lblLastName.setFont(lblFirstName.getFont());
            lblLastName.setBounds(80, 150, 150, 30);
            
            tfLastName = new JTextField(15);
            tfLastName.setFont(tfFirstName.getFont());
            tfLastName.setBounds(80, 175, 240, 30);

            labelUsername = new JLabel("Username");
            labelUsername.setFont(lblFirstName.getFont());
            labelUsername.setBounds(80, 200, 150, 30);

            tfUser = new JTextField(15);
            tfUser.setFont(tfFirstName.getFont());
            tfUser.setBounds(80, 225, 240, 30);

            lblPass = new JLabel("Password");
            lblPass.setFont(lblFirstName.getFont());
            lblPass.setBounds(80, 250, 150, 30);

            passField = new JPasswordField(15);
            passField.setFont(tfFirstName.getFont());
            passField.setBounds(80, 275, 190, 30);
            
            lblCPass = new JLabel("Confirm Password");
            lblCPass.setFont(lblFirstName.getFont());
            lblCPass.setBounds(80, 300, 150, 30);
            lblCPass.setForeground(Color.WHITE);

            CPassField = new JPasswordField(15);
            CPassField.setFont(tfFirstName.getFont());
            CPassField.setBounds(80, 325, 190, 30);
            CPassField.setBackground(tfFirstName.getBackground());
            CPassField.setForeground(tfFirstName.getForeground());

            showPass = new JToggleButton(eyeIcon);
            showPass.setBounds(270, 275, 50, 30);

            showCPass = new JToggleButton(eyeIcon);
            showCPass.setBounds(270, 325, 50, 30);

            btnBack = new JButton("Back");
            btnBack.setFont(lblFirstName.getFont());
            btnBack.setBounds(80, 380, 120, 30);
            btnBack.setBackground(new Color(0, 0, 0));
            btnBack.setForeground(Color.WHITE);

            btnRegister = new JButton("Register");
            btnRegister.setFont(lblFirstName.getFont());
            btnRegister.setBounds(200, 380, 120, 30);
            btnRegister.setBackground(new Color(204, 51, 0));

            
    
        }

    public void setLayoutManager(){
        container.setLayout(null);
    }
		
    public void addComponentsToContainer(){

		container.add(lblTitle);
        container.add(lblFirstName);
        container.add(lblLastName);
        container.add(labelUsername);
        container.add(tfFirstName);
        container.add(tfLastName);
        container.add(tfUser);
        container.add(lblPass);
        container.add(passField);
        container.add(lblCPass);
        container.add(CPassField);
        container.add(btnBack);
        container.add(btnRegister);
        container.add(showPass);
        container.add(showCPass);

    }
        
    public void addActionEvent(){

        btnRegister.addActionListener(this);
        btnBack.addActionListener(this);
        showPass.addActionListener(this);
        showCPass.addActionListener(this);
    }

    
    public void actionPerformed(ActionEvent e) {
        String firstName = tfFirstName.getText();
        String lastName = tfLastName.getText();
        String Username = tfUser.getText();
        String password = new String(passField.getPassword());
        String confirmPassword = new String(CPassField.getPassword());
        boolean passwordChecker = true;


        if(password.equals(confirmPassword)){
            passwordChecker = true;
        }
        else{
            passwordChecker = false;
        }

        
        if(e.getSource() == btnRegister){
            if(firstName.equals("") || lastName.equals("") || Username.equals("") || password.equals("") || confirmPassword.equals("")){
                JOptionPane.showMessageDialog(container, "Please fill in the empty entries.");
            }
            else if(passwordChecker == false){
                JOptionPane.showMessageDialog(container, "Password does not match.");
            }
            else{
                JOptionPane.showMessageDialog(container, "Registration Complete.");
            }
        }
        else if(e.getSource() == btnBack){
            new myLogin();
            dispose();
        }

    
        if(e.getSource() == showPass){
            
            
            if(showPass.isSelected()){
                passField.setEchoChar('\u0000');
                
            }
            else{
                passField.setEchoChar('\u2022');
                
            }
        }
        
        if(e.getSource() == showCPass){
            if(showCPass.isSelected()){
                CPassField.setEchoChar('\u0000');
            }
            else{
                CPassField.setEchoChar('\u2022');
            }
        }
        
    }

    
}
