

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class myLogin extends JFrame implements ActionListener{
	
	Container container = getContentPane();
	
	private JLabel lblUser, pass, lblTitle, noAcc;
	private JTextField tfUsername;
	private JPasswordField passField;
	private JButton btnLogin, btnSignup, btnExit, btnFb, btnGoogle;
	private JToggleButton showPass;
	private ImageIcon fbIcon = new ImageIcon("src/fb_button.jpg");
	private ImageIcon ggIcon = new ImageIcon("src/gg_button.png");
	private ImageIcon eyeIcon = new ImageIcon("src/eye_button.png");

	public myLogin() {
		setUndecorated(true);
		setLocation(750, 300);
		setSize(400, 450);
		setResizable(false);

		setLayoutManager();
		setComponentsCharacteristics();
		addComponentsToContainer();
		addActionEvent();
		
		setVisible(true);
	}
	public void setComponentsCharacteristics(){
		
		lblTitle = new JLabel("Sign In With");
		lblTitle.setFont(new Font("ARIAL BLACK", Font.BOLD,30));
		lblTitle.setBounds(95, 0, 300, 100);

		btnFb = new JButton(fbIcon);
		btnFb.setBounds(110, 80, 70, 70);

		btnGoogle = new JButton(ggIcon);
		btnGoogle.setBounds(210, 80, 70, 70);

		lblUser = new JLabel("USERNAME");
		lblUser.setFont(new Font("ARIAL BLACK", Font.BOLD, 10));
		lblUser.setBounds(55, 180, 1000, 20);

		pass = new JLabel("PASSWORD");
		pass.setFont(new Font("ARIAL BLACK", Font.BOLD, 10));
		pass.setBounds(55, 230, 1000, 20);

		tfUsername = new JTextField(15);
		tfUsername.setFont(new Font("ARIAL", Font.BOLD, 15));
		tfUsername.setBounds(55, 200, 280, 35);

		passField = new JPasswordField(15); 
		passField.setFont(new Font("ARIAL", Font.BOLD, 15));
		passField.setBounds(55, 250, 230, 35);

		showPass = new JToggleButton(eyeIcon);
		showPass.setBounds(284, 250, 50, 34);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(120, 310, 150, 30);
		btnLogin.setBackground(new Color(43, 43, 43));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBorderPainted(false);

		noAcc = new JLabel("Dont have an account?");
		noAcc.setFont(new Font("ARIAL", Font.BOLD, 10));
		noAcc.setBounds(110, 400, 150, 30);

		btnSignup = new JButton();
		btnSignup.setText("Sign up now!");
		btnSignup.setFont(new Font("ARIAL", Font.BOLD, 10));
		btnSignup.setBounds(210, 410, 98, 10);
		btnSignup.setForeground(new Color(220, 20, 60));
		btnSignup.setBorderPainted(false);
		btnSignup.setContentAreaFilled(false);

		btnExit = new JButton("Exit");
		btnExit.setFont(btnSignup.getFont());
		btnExit.setBounds(165, 430, 60, 10);
		btnExit.setBackground(new Color(0, 0, 0));
		btnExit.setForeground(Color.WHITE);

	}

	public void addComponentsToContainer(){
		container.add(lblTitle);
		container.add(btnFb);
		container.add(btnGoogle);
		container.add(lblUser); 
		container.add(tfUsername); 
		container.add(pass); 
		container.add(passField); 
		container.add(showPass);
		container.add(btnLogin);
		container.add(noAcc);
		container.add(btnSignup);
		container.add(btnExit);
	}

	public void setLayoutManager(){
		container.setLayout(null);
		}

	public void addActionEvent(){
		btnLogin.addActionListener(this); 
		btnSignup.addActionListener(this);
		showPass.addActionListener(this);
		btnExit.addActionListener(this);
		btnFb.addActionListener(this);
		btnGoogle.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String username = tfUsername.getText();
		String password = new String(passField.getPassword());
		
		if(e.getSource() == btnLogin){
		
			if (username.equals("admin") && password.equals("password")) {
				JOptionPane.showMessageDialog(container, "Login successful");
			}
			else if(password.equals("") || username.equals("")){
				JOptionPane.showMessageDialog(container, "Please enter username or password.");
			}
			else {
				JOptionPane.showMessageDialog(container, "Invalid username or password");
			}
		}
		else if(e.getSource() == btnSignup){
			new mySignup();
			dispose();
		}
		else if(e.getSource() == btnExit){
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

		if(e.getSource() == btnFb){
			JOptionPane.showMessageDialog(container, "Wala pang API, please try again later.");
		}
		else if(e.getSource() == btnGoogle){
			JOptionPane.showMessageDialog(container, "Wala pang API, please try again later.");
		}
	}	
}