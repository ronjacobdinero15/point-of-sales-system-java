import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class Login {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Bell MT", Font.PLAIN, 11));
		frame.getContentPane().setBackground(new Color(255, 255, 0));
		frame.getContentPane().setForeground(new Color(255, 255, 0));
		frame.setBounds(200, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogin = new JLabel("POS Login System");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Bell MT", Font.BOLD, 30));
		lblLogin.setBounds(10, 10, 464, 35);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Bell MT", Font.PLAIN, 30));
		lblUsername.setBounds(10, 72, 138, 35);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Bell MT", Font.PLAIN, 30));
		lblPassword.setBounds(10, 118, 138, 36);
		frame.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtUsername.setBounds(158, 72, 292, 35);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtPassword.setBounds(158, 119, 292, 35);
		frame.getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Bell MT", Font.BOLD, 30));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				@SuppressWarnings("deprecation")
				String password = txtPassword.getText();
				String username = txtUsername.getText();
				if (username.contains("ADMIN") && password.contains("123")) {
					Main mainMenu = new Main();
					mainMenu.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid Username/Password.", "Please try again", JOptionPane.ERROR_MESSAGE);
					txtUsername.setText(null);
					txtPassword.setText(null);
				}
			}
		});
		btnLogin.setBounds(10, 200, 150, 50);
		frame.getContentPane().add(btnLogin);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBackground(new Color(255, 255, 255));
		btnClear.setFont(new Font("Bell MT", Font.BOLD, 30));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText(null);
				txtPassword.setText(null);
			}
		});
		btnClear.setBounds(164, 200, 155, 50);
		frame.getContentPane().add(btnClear);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBackground(new Color(255, 255, 255));
		btnExit.setFont(new Font("Bell MT", Font.BOLD, 30));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit.", "POS Login System", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(324, 200, 150, 50);
		frame.getContentPane().add(btnExit);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 56, 464, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 170, 464, 2);
		frame.getContentPane().add(separator_1_1);
	}

}
