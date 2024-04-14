import java.awt.*;
import javax.swing.UIManager.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.MessageFormat;

@SuppressWarnings("serial")
public class Main extends JFrame {
	private JPanel contentPane;
	private JPanel mainPanel;
	private JPanel beveragesPanel;
	private JPanel favoritesPanel;
	private JLayeredPane multiLayeredPane;
	private JButton beveragesBTN;
	private JButton favoritesBTN;
	private JPanel main_1;
	private JLabel lblMain_1;
	private JLabel lblMainPic_1;
	private JPanel main_2;
	private JLabel lblMain_2;
	private JLabel lblMainPic_2;
	private JPanel main_3;
	private JLabel lblMain_3;
	private JLabel lblMainPic_3;
	private JPanel main_4;
	private JLabel lblMain_4;
	private JLabel lblMainPic_4;
	private JPanel main_5;
	private JLabel lblMain_5;
	private JLabel lblMainPic_5;
	private JPanel main_6;
	private JLabel lblMain_6;
	private JLabel lblMainPic_6;
	private JPanel main_7;
	private JLabel lblMain_7;
	private JLabel lblMainPic_7;
	private JPanel main_8;
	private JLabel lblMain_8;
	private JLabel lblMainPic_8;
	private JPanel beverage_1;
	private JLabel lblBeverage_1;
	private JLabel lblBeveragePic_1;
	private JPanel beverage_5;
	private JLabel lblBeverage_5;
	private JLabel lblBeveragePic_5;
	private JPanel beverage_2;
	private JLabel lblBeverage_2;
	private JLabel lblBeveragePic_2;
	private JPanel beverage_3;
	private JLabel lblBeverage_3;
	private JLabel lblBeveragePic_3;
	private JPanel beverage_4;
	private JLabel lblBeverage_4;
	private JLabel lblBeveragePic_4;
	private JPanel beverage_6;
	private JLabel lblBeverage_6;
	private JLabel lblBeveragePic_6;
	private JPanel beverage_7;
	private JLabel lblBeverage_7;
	private JLabel lblBeveragePic_7;
	private JPanel beverage_8;
	private JLabel lblBeverage_8;
	private JLabel lblBeveragePic_8;
	private JPanel favorites_1;
	private JLabel lblFavorites_1;
	private JPanel favorites_2;
	private JLabel lblFavorites_2;
	private JPanel favorites_3;
	private JLabel lblFavorites_3;
	private JPanel favorites_4;
	private JLabel lblFavorites_4;
	private JPanel ticketPanel;
	private JTable table;
	private JButton btn8;
	private JButton btn9;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn0;
	private JButton btnPeriod;
	private JButton btnClear;
	private JPanel transactionPanel;
	private JTextField txtTax;
	private JTextField txtTotal;
	private JTextField txtSubTotal;
	private JLabel lblTax;
	private JLabel lblSubtotal;
	private JLabel lblTotal;
	private JLabel lblPayMethod;
	private JLabel lblDisplayCash;
	private JTextField txtDisplayCash;
	private JLabel lblChange;
	private JTextField txtChange;
	
	private JLabel lblMainPrice_1;
	private JLabel lblMainPrice_2;
	private JLabel lblMainPrice_3;
	private JLabel lblMainPrice_4;
	private JLabel lblMainPrice_5;
	private JLabel lblMainPrice_6;
	private JLabel lblMainPrice_7;
	private JLabel lblMainPrice_8;
	private JLabel lblBeveragePrice_1;
	private JLabel lblBeveragePrice_2;
	private JLabel lblBeveragePrice_3;
	private JLabel lblBeveragePrice_4;
	private JLabel lblBeveragePrice_5;
	private JLabel lblBeveragePrice_6;
	private JLabel lblBeveragePrice_7;
	private JLabel lblBeveragePrice_8;
	private JLabel lblFavoritesPrice_1;
	private JLabel lblFavoritesPrice_2;
	private JLabel lblFavoritesPrice_3;
	private JLabel lblFavoritesPrice_4;
	private JLabel lblFavoritesPrice_5;
	private JLabel lblFavoritesPrice_6;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
				    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				        if ("Nimbus".equals(info.getName())) {
				            UIManager.setLookAndFeel(info.getClassName());
				            break;
				        }
				    }
				} catch (Exception e) {
				    // If Nimbus is not available, you can set the GUI to another look and feel.
				}

				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 *	
	 *
	 *
	 *	Create the frame.
	 *  SUBTOTAL, TOTAL DISPLAY
	 *
	 *
	 */
	public void ItemCost() {
		double sum = 0;
		double tax = 3.9;
		
		for(int i=0; i<table.getRowCount(); i++) {
			sum = sum + Double.parseDouble(table.getValueAt(i, 2).toString());
		}	
			txtSubTotal.setText(Double.toString(sum));
			double cTotal = Double.parseDouble(txtSubTotal.getText());
			
			double cTax = (cTotal * tax)/100;
			String iTaxTotal = String.format("₱ %.2f", cTax);
			txtTax.setText(iTaxTotal);
			
			String iSubTotal = String.format("₱ %.2f", cTotal);
			txtSubTotal.setText(iSubTotal);
		
			String iTotal = String.format("₱ %.2f", cTotal + cTax);
			txtTotal.setText(iTotal);
	}
	/*
	 * 
	 * 
	 *  CHANGE DISPLAY
	 *  
	 *  
	 */
	public void Change() {
		double sum = 0;
		double tax = 3.9;
		double cash = Double.parseDouble(txtDisplayCash.getText());
		
		for(int i=0; i<table.getRowCount(); i++) {
			sum = sum + Double.parseDouble(table.getValueAt(i, 2).toString());
		}	
			
			double cTax = (tax * sum)/100;
			double cChange = (cash - (sum + cTax));
			String ChangeGiven = String.format("₱ %.2f", cChange);
			txtChange.setText(ChangeGiven);
	}
	public Boolean matchMaking() {
		String EnterNumber = txtDisplayCash.getText();

		String regex = "(\\d+)(.*)";

		Pattern pattern = Pattern.compile(regex); // compiles the regex
		// find match between given string and pattern
		Matcher matcherText = pattern.matcher(EnterNumber);
		// return true if the string matched the regex
		Boolean textMatches = matcherText.matches();
		
		return textMatches;

	}

	/*
	 * 
	 * 
	 *  LAYERED PANE / MULTIPLE PANELS LAYOUT
	 *  
	 *  
	 */
	public void switchPanels(JPanel panel) {
		multiLayeredPane.removeAll();
		multiLayeredPane.add(panel);
		multiLayeredPane.repaint();
		multiLayeredPane.revalidate();
	}
	/*
	 * 
	 * 
	 *  DESIGN
	 *  
	 *  
	 */
	public Main() {
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 765);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel dishPanel = new JPanel();
		dishPanel.setBounds(10, 450, 620, 77);
		contentPane.add(dishPanel);
		dishPanel.setLayout(new GridLayout(0, 3, 0, 0));
		/*
		 *
		 *
		 *  LAYERED PANE / MULTIPLE PANELS LAYOUT & DESIGN
		 *
		 *
		 */
		JButton mainBTN = new JButton("MAIN");
		mainBTN.setForeground(new Color(255, 255, 255));
		mainBTN.setFont(new Font("Dialog", Font.BOLD, 17));
		mainBTN.setBackground(new Color(255, 0, 0));
		mainBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(mainPanel);
			}
		});
		dishPanel.add(mainBTN);
		
		beveragesBTN = new JButton("BEVERAGES");
		beveragesBTN.setForeground(new Color(255, 255, 255));
		beveragesBTN.setFont(new Font("Dialog", Font.BOLD, 17));
		beveragesBTN.setBackground(new Color(0, 0, 255));
		beveragesBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(beveragesPanel);
			}
		});
		dishPanel.add(beveragesBTN);
		
		favoritesBTN = new JButton("FAVORITES");
		favoritesBTN.setFont(new Font("Dialog", Font.BOLD, 17));
		favoritesBTN.setForeground(new Color(255, 255, 255));
		favoritesBTN.setBackground(new Color(255, 165, 0));
		favoritesBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(favoritesPanel);
			}
		});
		dishPanel.add(favoritesBTN);

		multiLayeredPane = new JLayeredPane();
		multiLayeredPane.setBounds(0, 0, 654, 442);
		contentPane.add(multiLayeredPane);
		multiLayeredPane.setLayout(new CardLayout(0, 0));
		
		/*
		 * 
		 * 
		 * 
		 * MAIN SECTION
		 * 
		 * 
		 * 
		 */
		
		mainPanel = new JPanel();
		mainPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mainPanel.setBackground(new Color(255, 255, 0));
		multiLayeredPane.add(mainPanel, "name_330784105864300");
		mainPanel.setLayout(null);
		
		main_1 = new JPanel();
		main_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		main_1.setBackground(new Color(255, 255, 255));
		main_1.setBounds(10, 11, 297, 97);
		mainPanel.add(main_1);
		main_1.setLayout(null);
		
		lblMain_1 = new JLabel("Chicago Hotdog");
		lblMain_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblMain_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain_1.setFont(new Font("Dialog", Font.BOLD, 17));
		lblMain_1.setBounds(110, 11, 177, 49);
		main_1.add(lblMain_1);
		
		lblMainPic_1 = new JLabel("");
		Image img_1 = new ImageIcon(this.getClass().getResource("/Chicago-Hotdog.jpeg")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);;
		lblMainPic_1.setIcon(new ImageIcon(img_1));
		lblMainPic_1.setBounds(10, 11, 90, 75);
		main_1.add(lblMainPic_1);
		
		lblMainPrice_1 = new JLabel("₱80.00");
		lblMainPrice_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainPrice_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMainPrice_1.setBounds(110, 63, 177, 23);
		main_1.add(lblMainPrice_1);
		
		main_2 = new JPanel();
		main_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		main_2.setBackground(new Color(255, 255, 255));
		main_2.setLayout(null);
		main_2.setBounds(10, 119, 297, 97);
		mainPanel.add(main_2);
		
		lblMain_2 = new JLabel("Corn Dogs");
		lblMain_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblMain_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain_2.setFont(new Font("Dialog", Font.BOLD, 17));
		lblMain_2.setBounds(110, 11, 177, 49);
		main_2.add(lblMain_2);
		
		lblMainPic_2 = new JLabel("");
		Image img_2 = new ImageIcon(this.getClass().getResource("/Corn-Dogs.jpg")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);;
		lblMainPic_2.setIcon(new ImageIcon(img_2));
		lblMainPic_2.setBounds(10, 11, 90, 75);
		main_2.add(lblMainPic_2);
		
		lblMainPrice_2 = new JLabel("₱80.00");
		lblMainPrice_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainPrice_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMainPrice_2.setBounds(110, 63, 177, 23);
		main_2.add(lblMainPrice_2);
		
		main_3 = new JPanel();
		main_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		main_3.setBackground(new Color(255, 255, 255));
		main_3.setLayout(null);
		main_3.setBounds(10, 227, 297, 97);
		mainPanel.add(main_3);
		
		lblMain_3 = new JLabel("Hamburger");
		lblMain_3.setBackground(Color.LIGHT_GRAY);
		lblMain_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblMain_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain_3.setFont(new Font("Dialog", Font.BOLD, 17));
		lblMain_3.setBounds(110, 11, 177, 49);
		main_3.add(lblMain_3);
		
		lblMainPic_3 = new JLabel("");
		Image img_3 = new ImageIcon(this.getClass().getResource("/Hamburger.jpg")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);;
		lblMainPic_3.setIcon(new ImageIcon(img_3));
		lblMainPic_3.setBounds(10, 11, 90, 75);
		main_3.add(lblMainPic_3);
		
		lblMainPrice_3 = new JLabel("₱95.00");
		lblMainPrice_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainPrice_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMainPrice_3.setBounds(110, 63, 177, 23);
		main_3.add(lblMainPrice_3);
		
		main_4 = new JPanel();
		main_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		main_4.setBackground(new Color(255, 255, 255));
		main_4.setLayout(null);
		main_4.setBounds(10, 335, 297, 97);
		mainPanel.add(main_4);
		
		lblMain_4 = new JLabel("Mac & Cheese");
		lblMain_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblMain_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain_4.setFont(new Font("Dialog", Font.BOLD, 17));
		lblMain_4.setBounds(110, 11, 177, 49);
		main_4.add(lblMain_4);
		
		lblMainPic_4 = new JLabel("");
		Image img_4 = new ImageIcon(this.getClass().getResource("/Mac-_-Cheese.jpg")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);;
		lblMainPic_4.setIcon(new ImageIcon(img_4));
		lblMainPic_4.setBounds(10, 11, 90, 75);
		main_4.add(lblMainPic_4);
		
		lblMainPrice_4 = new JLabel("₱150.00");
		lblMainPrice_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainPrice_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMainPrice_4.setBounds(110, 63, 177, 23);
		main_4.add(lblMainPrice_4);
		
		main_5 = new JPanel();
		main_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		main_5.setBackground(new Color(255, 255, 255));
		main_5.setLayout(null);
		main_5.setBounds(337, 11, 297, 97);
		mainPanel.add(main_5);
		
		lblMain_5 = new JLabel("New York Pizza");
		lblMain_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblMain_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain_5.setFont(new Font("Dialog", Font.BOLD, 17));
		lblMain_5.setBounds(110, 11, 177, 49);
		main_5.add(lblMain_5);
		
		lblMainPic_5 = new JLabel("");
		Image img_5 = new ImageIcon(this.getClass().getResource("/New-York-Pizza.jpg")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);;
		lblMainPic_5.setIcon(new ImageIcon(img_5));
		lblMainPic_5.setBounds(10, 11, 90, 75);
		main_5.add(lblMainPic_5);
		
		lblMainPrice_5 = new JLabel("₱300.00");
		lblMainPrice_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainPrice_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMainPrice_5.setBounds(110, 63, 177, 23);
		main_5.add(lblMainPrice_5);
		
		main_6 = new JPanel();
		main_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		main_6.setBackground(new Color(255, 255, 255));
		main_6.setLayout(null);
		main_6.setBounds(337, 119, 297, 97);
		mainPanel.add(main_6);
		
		lblMain_6 = new JLabel("Philly Cheesesteak");
		lblMain_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblMain_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain_6.setFont(new Font("Dialog", Font.BOLD, 17));
		lblMain_6.setBounds(110, 11, 177, 49);
		main_6.add(lblMain_6);
		
		lblMainPic_6 = new JLabel("");
		Image img_6 = new ImageIcon(this.getClass().getResource("/Philly-Cheesestea.jpg")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);;
		lblMainPic_6.setIcon(new ImageIcon(img_6));
		lblMainPic_6.setBounds(10, 11, 90, 75);
		main_6.add(lblMainPic_6);
		
		lblMainPrice_6 = new JLabel("₱120.00");
		lblMainPrice_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainPrice_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMainPrice_6.setBounds(110, 63, 177, 23);
		main_6.add(lblMainPrice_6);
		
		main_7 = new JPanel();
		main_7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		main_7.setBackground(new Color(255, 255, 255));
		main_7.setLayout(null);
		main_7.setBounds(337, 227, 297, 97);
		mainPanel.add(main_7);
		
		lblMain_7 = new JLabel("Reuben");
		lblMain_7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblMain_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain_7.setFont(new Font("Dialog", Font.BOLD, 17));
		lblMain_7.setBounds(110, 11, 177, 49);
		main_7.add(lblMain_7);
		
		lblMainPic_7 = new JLabel("");
		Image img_7 = new ImageIcon(this.getClass().getResource("/Reuben.jpg")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);;
		lblMainPic_7.setIcon(new ImageIcon(img_7));
		lblMainPic_7.setBounds(10, 11, 90, 75);
		main_7.add(lblMainPic_7);
		
		lblMainPrice_7 = new JLabel("₱120.00");
		lblMainPrice_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainPrice_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMainPrice_7.setBounds(110, 63, 177, 23);
		main_7.add(lblMainPrice_7);
		
		main_8 = new JPanel();
		main_8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		main_8.setBackground(new Color(255, 255, 255));
		main_8.setLayout(null);
		main_8.setBounds(337, 335, 297, 97);
		mainPanel.add(main_8);
		
		lblMain_8 = new JLabel("Cherry Pie");
		lblMain_8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblMain_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain_8.setFont(new Font("Dialog", Font.BOLD, 17));
		lblMain_8.setBounds(110, 11, 177, 49);
		main_8.add(lblMain_8);
		
		lblMainPic_8 = new JLabel("");
		Image img_8 = new ImageIcon(this.getClass().getResource("/Cherry-Pie.jpeg")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);;
		lblMainPic_8.setIcon(new ImageIcon(img_8));
		lblMainPic_8.setBounds(10, 11, 90, 75);
		main_8.add(lblMainPic_8);
		
		lblMainPrice_8 = new JLabel("₱130.00");
		lblMainPrice_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainPrice_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMainPrice_8.setBounds(110, 63, 177, 23);
		main_8.add(lblMainPrice_8);
		
		beveragesPanel = new JPanel();
		beveragesPanel.setBackground(new Color(255, 255, 0));
		multiLayeredPane.add(beveragesPanel, "name_330888471422400");
		beveragesPanel.setLayout(null);
		
		/*
		 * 
		 * 
		 * 
		 * BEVERAGES SECTION
		 * 
		 * 
		 * 
		 */
		
		beverage_1 = new JPanel();
		beverage_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		beverage_1.setLayout(null);
		beverage_1.setBackground(Color.WHITE);
		beverage_1.setBounds(10, 11, 297, 97);
		beveragesPanel.add(beverage_1);
		
		lblBeverage_1 = new JLabel("Classic Manhattan");
		lblBeverage_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblBeverage_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeverage_1.setFont(new Font("Dialog", Font.BOLD, 17));
		lblBeverage_1.setBounds(110, 11, 177, 49);
		beverage_1.add(lblBeverage_1);
		
		lblBeveragePic_1 = new JLabel("");
		Image bev_img_1 = new ImageIcon(this.getClass().getResource("/Classic-Manhattan-Cocktail.jpg")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);;
		lblBeveragePic_1.setIcon(new ImageIcon(bev_img_1));
		lblBeveragePic_1.setBounds(10, 11, 90, 75);

		beverage_1.add(lblBeveragePic_1);
		
		lblBeveragePrice_1 = new JLabel("₱70.00");
		lblBeveragePrice_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeveragePrice_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBeveragePrice_1.setBounds(110, 63, 177, 23);
		beverage_1.add(lblBeveragePrice_1);
		
		beverage_2 = new JPanel();
		beverage_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		beverage_2.setLayout(null);
		beverage_2.setBackground(Color.WHITE);
		beverage_2.setBounds(10, 121, 297, 97);
		beveragesPanel.add(beverage_2);
		
		lblBeverage_2 = new JLabel("Dirty Martini");
		lblBeverage_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblBeverage_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeverage_2.setFont(new Font("Dialog", Font.BOLD, 17));
		lblBeverage_2.setBounds(110, 11, 177, 49);
		beverage_2.add(lblBeverage_2);
		
		lblBeveragePic_2 = new JLabel("");
		Image bev_img_2 = new ImageIcon(this.getClass().getResource("/Dirty-Martini.jpg")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);;
		lblBeveragePic_2.setIcon(new ImageIcon(bev_img_2));
		lblBeveragePic_2.setBounds(10, 11, 90, 75);
		beverage_2.add(lblBeveragePic_2);
		
		lblBeveragePrice_2 = new JLabel("₱70.00");
		lblBeveragePrice_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeveragePrice_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBeveragePrice_2.setBounds(110, 63, 177, 23);
		beverage_2.add(lblBeveragePrice_2);
		
		beverage_3 = new JPanel();
		beverage_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		beverage_3.setLayout(null);
		beverage_3.setBackground(Color.WHITE);
		beverage_3.setBounds(10, 229, 297, 97);
		beveragesPanel.add(beverage_3);
		
		lblBeverage_3 = new JLabel("Gin Rickey");
		lblBeverage_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblBeverage_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeverage_3.setFont(new Font("Dialog", Font.BOLD, 17));
		lblBeverage_3.setBounds(110, 11, 177, 49);
		beverage_3.add(lblBeverage_3);
		
		lblBeveragePic_3 = new JLabel("");
		Image bev_img_3 = new ImageIcon(this.getClass().getResource("/Gin-Rickey.jpg")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);;
		lblBeveragePic_3.setIcon(new ImageIcon(bev_img_3));
		lblBeveragePic_3.setBounds(10, 11, 90, 75);
		beverage_3.add(lblBeveragePic_3);
		
		lblBeveragePrice_3 = new JLabel("₱70.00");
		lblBeveragePrice_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeveragePrice_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBeveragePrice_3.setBounds(110, 63, 177, 23);
		beverage_3.add(lblBeveragePrice_3);
		
		beverage_4 = new JPanel();
		beverage_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		beverage_4.setLayout(null);
		beverage_4.setBackground(Color.WHITE);
		beverage_4.setBounds(10, 337, 297, 97);
		beveragesPanel.add(beverage_4);
		
		lblBeverage_4 = new JLabel("Hurricane Cocktail");
		lblBeverage_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblBeverage_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeverage_4.setFont(new Font("Dialog", Font.BOLD, 17));
		lblBeverage_4.setBounds(110, 11, 177, 49);
		beverage_4.add(lblBeverage_4);
		
		lblBeveragePic_4 = new JLabel("");
		Image bev_img_4 = new ImageIcon(this.getClass().getResource("/Hurricane-Cocktail-Recipe.jpg")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);;
		lblBeveragePic_4.setIcon(new ImageIcon(bev_img_4));
		lblBeveragePic_4.setBounds(10, 11, 90, 75);
		beverage_4.add(lblBeveragePic_4);
		
		lblBeveragePrice_4 = new JLabel("₱70.00");
		lblBeveragePrice_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeveragePrice_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBeveragePrice_4.setBounds(110, 63, 177, 23);
		beverage_4.add(lblBeveragePrice_4);
		
		beverage_5 = new JPanel();
		beverage_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		beverage_5.setLayout(null);
		beverage_5.setBackground(Color.WHITE);
		beverage_5.setBounds(337, 11, 297, 97);
		beveragesPanel.add(beverage_5);
		
		lblBeverage_5 = new JLabel("Lynchburg Lemonade");
		lblBeverage_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblBeverage_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeverage_5.setFont(new Font("Dialog", Font.BOLD, 17));
		lblBeverage_5.setBounds(110, 11, 177, 49);
		beverage_5.add(lblBeverage_5);
		
		lblBeveragePic_5 = new JLabel("");
		Image bev_img_5 = new ImageIcon(this.getClass().getResource("/Lynchburg-Lemonade.jpg")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);;
		lblBeveragePic_5.setIcon(new ImageIcon(bev_img_5));
		lblBeveragePic_5.setBounds(10, 11, 90, 75);
		beverage_5.add(lblBeveragePic_5);
		
		lblBeveragePrice_5 = new JLabel("₱70.00");
		lblBeveragePrice_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeveragePrice_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBeveragePrice_5.setBounds(110, 63, 177, 23);
		beverage_5.add(lblBeveragePrice_5);
		
		beverage_6 = new JPanel();
		beverage_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		beverage_6.setLayout(null);
		beverage_6.setBackground(Color.WHITE);
		beverage_6.setBounds(337, 119, 297, 97);
		beveragesPanel.add(beverage_6);
		
		lblBeverage_6 = new JLabel("Sazerac");
		lblBeverage_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblBeverage_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeverage_6.setFont(new Font("Dialog", Font.BOLD, 17));
		lblBeverage_6.setBounds(110, 11, 177, 49);
		beverage_6.add(lblBeverage_6);
		
		lblBeveragePic_6 = new JLabel("");
		Image bev_img_6 = new ImageIcon(this.getClass().getResource("/Sazerac.jpg")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);;
		lblBeveragePic_6.setIcon(new ImageIcon(bev_img_6));
		lblBeveragePic_6.setBounds(10, 11, 90, 75);
		beverage_6.add(lblBeveragePic_6);
		
		lblBeveragePrice_6 = new JLabel("₱70.00");
		lblBeveragePrice_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeveragePrice_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBeveragePrice_6.setBounds(110, 63, 177, 23);
		beverage_6.add(lblBeveragePrice_6);
		
		beverage_7 = new JPanel();
		beverage_7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		beverage_7.setLayout(null);
		beverage_7.setBackground(Color.WHITE);
		beverage_7.setBounds(337, 229, 297, 97);
		beveragesPanel.add(beverage_7);
		
		lblBeverage_7 = new JLabel("Wisconsin Brandy");
		lblBeverage_7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblBeverage_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeverage_7.setFont(new Font("Dialog", Font.BOLD, 17));
		lblBeverage_7.setBounds(110, 11, 177, 49);
		beverage_7.add(lblBeverage_7);
		
		lblBeveragePic_7 = new JLabel("");
		Image bev_img_7 = new ImageIcon(this.getClass().getResource("/Wisconsin-Brandy-Old-Fashioned.jpg")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);;
		lblBeveragePic_7.setIcon(new ImageIcon(bev_img_7));
		lblBeveragePic_7.setBounds(10, 11, 90, 75);
		beverage_7.add(lblBeveragePic_7);
		
		lblBeveragePrice_7 = new JLabel("₱70.00");
		lblBeveragePrice_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeveragePrice_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBeveragePrice_7.setBounds(110, 63, 177, 23);
		beverage_7.add(lblBeveragePrice_7);
		
		beverage_8 = new JPanel();
		beverage_8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		beverage_8.setLayout(null);
		beverage_8.setBackground(Color.WHITE);
		beverage_8.setBounds(337, 337, 297, 97);
		beveragesPanel.add(beverage_8);
		
		lblBeverage_8 = new JLabel("Orange Creamsicle");
		lblBeverage_8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblBeverage_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeverage_8.setFont(new Font("Dialog", Font.BOLD, 17));
		lblBeverage_8.setBounds(110, 11, 177, 49);
		beverage_8.add(lblBeverage_8);
		
		lblBeveragePic_8 = new JLabel("");
		Image bev_img_8 = new ImageIcon(this.getClass().getResource("/Orange-Creamsicle.jpg")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);;
		lblBeveragePic_8.setIcon(new ImageIcon(bev_img_8));
		lblBeveragePic_8.setBounds(10, 11, 90, 75);
		beverage_8.add(lblBeveragePic_8);
		
		lblBeveragePrice_8 = new JLabel("₱70.00");
		lblBeveragePrice_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeveragePrice_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBeveragePrice_8.setBounds(110, 63, 177, 23);
		beverage_8.add(lblBeveragePrice_8);
		
		/*
		 * 
		 * 
		 * 
		 * FAVORITES SECTION
		 * 
		 * 
		 * 
		 */

		favoritesPanel = new JPanel();
		favoritesPanel.setBackground(new Color(255, 255, 0));
		multiLayeredPane.add(favoritesPanel, "name_330890375595400");
		favoritesPanel.setLayout(null);
		
		JLabel lblMainFavorites = new JLabel("MAIN FAVORITES");
		lblMainFavorites.setForeground(new Color(255, 0, 0));
		lblMainFavorites.setBackground(new Color(255, 0, 0));
		lblMainFavorites.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 0)));
		lblMainFavorites.setHorizontalAlignment(SwingConstants.CENTER);
		lblMainFavorites.setFont(new Font("Dubai", Font.BOLD, 24));
		lblMainFavorites.setBounds(10, 14, 624, 40);
		favoritesPanel.add(lblMainFavorites);
				
		JLabel lblBeveragesFavorites = new JLabel("BEVERAGES FAVORITES");
		lblBeveragesFavorites.setForeground(new Color(255, 0, 0));
		lblBeveragesFavorites.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeveragesFavorites.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 0, 0)));
		lblBeveragesFavorites.setFont(new Font("Dubai", Font.BOLD, 24));
		lblBeveragesFavorites.setBounds(10, 283, 624, 40);
		favoritesPanel.add(lblBeveragesFavorites);
		
		JPanel favorites_5 = new JPanel();
		favorites_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		favorites_5.setLayout(null);
		favorites_5.setBackground(Color.WHITE);
		favorites_5.setBounds(10, 334, 297, 97);
		favoritesPanel.add(favorites_5);
		
		JLabel lblFavorites_5 = new JLabel("Classic Manhattan");
		lblFavorites_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblFavorites_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblFavorites_5.setFont(new Font("Dialog", Font.BOLD, 17));
		lblFavorites_5.setBounds(110, 11, 177, 49);
		favorites_5.add(lblFavorites_5);
		
		JLabel lblFavoritesPic_5 = new JLabel("");
		Image fav_img_5 = new ImageIcon(this.getClass().getResource("/Classic-Manhattan-Cocktail.jpg")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);;
		lblFavoritesPic_5.setIcon(new ImageIcon(fav_img_5));
		lblFavoritesPic_5.setBounds(10, 11, 90, 75);
		favorites_5.add(lblFavoritesPic_5);
		
		lblFavoritesPrice_5 = new JLabel("₱70.00");
		lblFavoritesPrice_5.setBounds(110, 63, 177, 23);
		favorites_5.add(lblFavoritesPrice_5);
		lblFavoritesPrice_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblFavoritesPrice_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JPanel favorites_6 = new JPanel();
		favorites_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		favorites_6.setLayout(null);
		favorites_6.setBackground(Color.WHITE);
		favorites_6.setBounds(337, 334, 297, 97);
		favoritesPanel.add(favorites_6);
		
		JLabel lblFavorites_6 = new JLabel("Hurricane Cocktail");
		lblFavorites_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblFavorites_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblFavorites_6.setFont(new Font("Dialog", Font.BOLD, 17));
		lblFavorites_6.setBounds(110, 11, 177, 49);
		favorites_6.add(lblFavorites_6);
		
		JLabel lblFavoritesPic_6 = new JLabel("");
		Image fav_img_6 = new ImageIcon(this.getClass().getResource("/Hurricane-Cocktail-Recipe.jpg")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);;
		lblFavoritesPic_6.setIcon(new ImageIcon(fav_img_6));
		lblFavoritesPic_6.setBounds(10, 11, 90, 75);
		favorites_6.add(lblFavoritesPic_6);
		
		lblFavoritesPrice_6 = new JLabel("₱70.00");
		lblFavoritesPrice_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblFavoritesPrice_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFavoritesPrice_6.setBounds(110, 63, 177, 23);
		favorites_6.add(lblFavoritesPrice_6);
		
		favorites_1 = new JPanel();
		favorites_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		favorites_1.setLayout(null);
		favorites_1.setBackground(Color.WHITE);
		favorites_1.setBounds(10, 65, 297, 97);
		favoritesPanel.add(favorites_1);
		
		lblFavorites_1 = new JLabel("New York Pizza");
		lblFavorites_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblFavorites_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFavorites_1.setFont(new Font("Dialog", Font.BOLD, 17));
		lblFavorites_1.setBounds(110, 11, 177, 49);
		favorites_1.add(lblFavorites_1);
		
		JLabel lblFavoritesPic_1 = new JLabel("");
		Image fav_img_1 = new ImageIcon(this.getClass().getResource("/New-York-Pizza.jpg")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);;
		lblFavoritesPic_1.setIcon(new ImageIcon(fav_img_1));
		lblFavoritesPic_1.setBounds(10, 11, 90, 75);
		favorites_1.add(lblFavoritesPic_1);
		
		lblFavoritesPrice_1 = new JLabel("₱300.00");
		lblFavoritesPrice_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFavoritesPrice_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFavoritesPrice_1.setBounds(110, 63, 177, 23);
		favorites_1.add(lblFavoritesPrice_1);
		
		favorites_2 = new JPanel();
		favorites_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		favorites_2.setLayout(null);
		favorites_2.setBackground(Color.WHITE);
		favorites_2.setBounds(10, 175, 297, 97);
		favoritesPanel.add(favorites_2);
		
		lblFavorites_2 = new JLabel("Hamburger");
		lblFavorites_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblFavorites_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFavorites_2.setFont(new Font("Dialog", Font.BOLD, 17));
		lblFavorites_2.setBounds(110, 11, 177, 49);
		favorites_2.add(lblFavorites_2);
		
		JLabel lblFavoritesPic_2 = new JLabel("");
		Image fav_img_2 = new ImageIcon(this.getClass().getResource("/Hamburger.jpg")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);;
		lblFavoritesPic_2.setIcon(new ImageIcon(fav_img_2));
		lblFavoritesPic_2.setBounds(10, 11, 90, 75);
		favorites_2.add(lblFavoritesPic_2);
		
		lblFavoritesPrice_2 = new JLabel("₱95.00");
		lblFavoritesPrice_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFavoritesPrice_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFavoritesPrice_2.setBounds(110, 63, 177, 23);
		favorites_2.add(lblFavoritesPrice_2);
		
		favorites_3 = new JPanel();
		favorites_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		favorites_3.setLayout(null);
		favorites_3.setBackground(Color.WHITE);
		favorites_3.setBounds(337, 65, 297, 97);
		favoritesPanel.add(favorites_3);
		
		lblFavorites_3 = new JLabel("Chicago Hotdog");
		lblFavorites_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblFavorites_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblFavorites_3.setFont(new Font("Dialog", Font.BOLD, 17));
		lblFavorites_3.setBounds(110, 11, 177, 49);
		favorites_3.add(lblFavorites_3);
		
		JLabel lblFavoritesPic_3 = new JLabel("");
		Image fav_img_3 = new ImageIcon(this.getClass().getResource("/Chicago-Hotdog.jpeg")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);;
		lblFavoritesPic_3.setIcon(new ImageIcon(fav_img_3));
		lblFavoritesPic_3.setBounds(10, 11, 90, 75);
		favorites_3.add(lblFavoritesPic_3);
		
		lblFavoritesPrice_3 = new JLabel("₱80.00");
		lblFavoritesPrice_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblFavoritesPrice_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFavoritesPrice_3.setBounds(110, 63, 177, 23);
		favorites_3.add(lblFavoritesPrice_3);
		
		favorites_4 = new JPanel();
		favorites_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		favorites_4.setLayout(null);
		favorites_4.setBackground(Color.WHITE);
		favorites_4.setBounds(337, 175, 297, 97);
		favoritesPanel.add(favorites_4);
		
		lblFavorites_4 = new JLabel("Philly Cheesesteak");
		lblFavorites_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblFavorites_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblFavorites_4.setFont(new Font("Dialog", Font.BOLD, 17));
		lblFavorites_4.setBounds(110, 11, 177, 49);
		favorites_4.add(lblFavorites_4);
		
		JLabel lblFavoritesPic_4 = new JLabel("");
		Image fav_img_4 = new ImageIcon(this.getClass().getResource("/Philly-Cheesestea.jpg")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);;
		lblFavoritesPic_4.setIcon(new ImageIcon(fav_img_4));
		lblFavoritesPic_4.setBounds(10, 11, 90, 75);
		favorites_4.add(lblFavoritesPic_4);
		
		lblFavoritesPrice_4 = new JLabel("₱120.00");
		lblFavoritesPrice_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblFavoritesPrice_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFavoritesPrice_4.setBounds(110, 63, 177, 23);
		favorites_4.add(lblFavoritesPrice_4);
		
		/*
		 * 
		 * 
		 * 
		 * NUMERIC KEYPAD PANEL 
		 * 
		 * 
		 * 
		 */
		
		JPanel numPadPanel = new JPanel();
		numPadPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		numPadPanel.setLayout(null);
		numPadPanel.setBackground(Color.WHITE);
		numPadPanel.setBounds(974, 11, 303, 372);
		contentPane.add(numPadPanel);
		
		/*
		 * 
		 * NUMPAD BUTTONS 9-0
		 * 
		 */
		
		btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplayCash.getText();
				
				if(EnterNumber == "") {
					txtDisplayCash.setText(btn9.getText());
				}
				else {
					EnterNumber = txtDisplayCash.getText() + btn9.getText();
					txtDisplayCash.setText(EnterNumber);
				}
			}
		});
		btn9.setBackground(new Color(255, 255, 255));
		btn9.setFont(new Font("Tahoma", Font.BOLD, 36));
		btn9.setBounds(207, 11, 89, 78);
		numPadPanel.add(btn9);
		
		btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplayCash.getText();
				
				if(EnterNumber == "") {
					txtDisplayCash.setText(btn8.getText());
				}
				else {
					EnterNumber = txtDisplayCash.getText() + btn8.getText();
					txtDisplayCash.setText(EnterNumber);
				}
			}
		});
		btn8.setBackground(new Color(255, 255, 255));
		btn8.setFont(new Font("Tahoma", Font.BOLD, 36));
		btn8.setBounds(108, 11, 89, 78);
		numPadPanel.add(btn8);

		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplayCash.getText();
				
				if(EnterNumber == "") {
					txtDisplayCash.setText(btn7.getText());
				}
				else {
					EnterNumber = txtDisplayCash.getText() + btn7.getText();
					txtDisplayCash.setText(EnterNumber);
				}
			}
		});
		btn7.setBackground(new Color(255, 255, 255));
		btn7.setFont(new Font("Tahoma", Font.BOLD, 36));
		btn7.setBounds(9, 11, 89, 78);
		numPadPanel.add(btn7);

		btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplayCash.getText();
				
				if(EnterNumber == "") {
					txtDisplayCash.setText(btn6.getText());
				}
				else {
					EnterNumber = txtDisplayCash.getText() + btn6.getText();
					txtDisplayCash.setText(EnterNumber);
				}
			}
		});
		btn6.setBackground(new Color(255, 255, 255));
		btn6.setFont(new Font("Tahoma", Font.BOLD, 36));
		btn6.setBounds(207, 100, 89, 78);
		numPadPanel.add(btn6);

		btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplayCash.getText();
				
				if(EnterNumber == "") {
					txtDisplayCash.setText(btn5.getText());
				}
				else {
					EnterNumber = txtDisplayCash.getText() + btn5.getText();
					txtDisplayCash.setText(EnterNumber);
				}
			}
		});
		btn5.setBackground(new Color(255, 255, 255));
		btn5.setFont(new Font("Tahoma", Font.BOLD, 36));
		btn5.setBounds(108, 100, 89, 78);
		numPadPanel.add(btn5);

		btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplayCash.getText();
				
				if(EnterNumber == "") {
					txtDisplayCash.setText(btn4.getText());
				}
				else {
					EnterNumber = txtDisplayCash.getText() + btn4.getText();
					txtDisplayCash.setText(EnterNumber);
				}
			}
		});
		btn4.setBackground(new Color(255, 255, 255));
		btn4.setFont(new Font("Tahoma", Font.BOLD, 36));
		btn4.setBounds(9, 100, 89, 78);
		numPadPanel.add(btn4);
		
		btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplayCash.getText();
				
				if(EnterNumber == "") {
					txtDisplayCash.setText(btn3.getText());
				}
				else {
					EnterNumber = txtDisplayCash.getText() + btn3.getText();
					txtDisplayCash.setText(EnterNumber);
				}
			}
		});
		btn3.setBackground(new Color(255, 255, 255));
		btn3.setFont(new Font("Tahoma", Font.BOLD, 36));
		btn3.setBounds(207, 189, 89, 78);
		numPadPanel.add(btn3);
		
		btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplayCash.getText();
				
				if(EnterNumber == "") {
					txtDisplayCash.setText(btn2.getText());
				}
				else {
					EnterNumber = txtDisplayCash.getText() + btn2.getText();
					txtDisplayCash.setText(EnterNumber);
				}
			}
		});
		btn2.setBackground(new Color(255, 255, 255));
		btn2.setFont(new Font("Tahoma", Font.BOLD, 36));
		btn2.setBounds(108, 189, 89, 78);
		numPadPanel.add(btn2);
				
		btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplayCash.getText();
				
				if(EnterNumber == "") {
					txtDisplayCash.setText(btn1.getText());
				}
				else {
					EnterNumber = txtDisplayCash.getText() + btn1.getText();
					txtDisplayCash.setText(EnterNumber);
				}
			}
		});
		btn1.setBackground(new Color(255, 255, 255));
		btn1.setFont(new Font("Tahoma", Font.BOLD, 36));
		btn1.setBounds(9, 189, 89, 78);
		numPadPanel.add(btn1);
				
		btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String EnterNumber = txtDisplayCash.getText();
				
				if(EnterNumber == "") {
					txtDisplayCash.setText(btn0.getText());
				}
				else {
					EnterNumber = txtDisplayCash.getText() + btn0.getText();
					txtDisplayCash.setText(EnterNumber);
				}
			}
		});
		btn0.setBackground(new Color(255, 255, 255));
		btn0.setFont(new Font("Tahoma", Font.BOLD, 36));
		btn0.setBounds(9, 278, 89, 78);
		numPadPanel.add(btn0);
		
		/*
		 * 
		 * DECIMAL BUTTON - NUMPAD
		 * 
		 */
		
		btnPeriod = new JButton(".");
		btnPeriod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(! txtDisplayCash.getText().contains(".")) {
					txtDisplayCash.setText(txtDisplayCash.getText() + btnPeriod.getText());
				}
			}
		});
		btnPeriod.setBackground(new Color(255, 255, 255));
		btnPeriod.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnPeriod.setBounds(108, 278, 89, 78);
		numPadPanel.add(btnPeriod);
		
		/*
		 * 
		 * CLEAR BUTTON - NUMPAD
		 * 
		 */
		
		btnClear = new JButton("C");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplayCash.setText(null);
				txtChange.setText(null);
			}
		});
		btnClear.setBackground(new Color(255, 255, 255));
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 36));
		btnClear.setBounds(207, 278, 89, 78);
		numPadPanel.add(btnClear);
		
		/*
		 * 
		 * 
		 * 
		 * TICKET PANEL 
		 * 
		 * 
		 * 
		 */
		
		ticketPanel = new JPanel();
		ticketPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		ticketPanel.setBackground(new Color(255, 255, 255));
		ticketPanel.setBounds(654, 11, 303, 372);
		contentPane.add(ticketPanel);
		ticketPanel.setLayout(null);
		
		JLabel lblOrderSummary = new JLabel("ORDER SUMMARY");
		lblOrderSummary.setBackground(Color.WHITE);
		lblOrderSummary.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOrderSummary.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderSummary.setBounds(0, 0, 300, 56);
		ticketPanel.add(lblOrderSummary);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 48, 283, 313);
		ticketPanel.add(scrollPane);
		
		/*
		 * 
		 * 
		 * 
		 * TICKET TABLE AND COLUMN NAMES 
		 * 
		 * 
		 * 
		 */
		
		table = new JTable();
		table.setSelectionForeground(Color.WHITE);
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setGridColor(Color.RED);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Items", "Qty", "Amount"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setPreferredWidth(55);
		
		/*
		 * 
		 * TRANSACTION PANEL DESIGN
		 * 
		 */
		
		transactionPanel = new JPanel();
		transactionPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		transactionPanel.setBackground(new Color(255, 255, 255));
		transactionPanel.setBounds(654, 394, 623, 296);
		contentPane.add(transactionPanel);
		transactionPanel.setLayout(null);
		
		txtTax = new JTextField();
		txtTax.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtTax.setBounds(26, 46, 164, 42);
		transactionPanel.add(txtTax);
		txtTax.setColumns(10);
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtTotal.setColumns(10);
		txtTotal.setBounds(421, 46, 164, 42);
		transactionPanel.add(txtTotal);
		
		txtSubTotal = new JTextField();
		txtSubTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtSubTotal.setColumns(10);
		txtSubTotal.setBounds(227, 46, 164, 43);
		transactionPanel.add(txtSubTotal);
		
		lblTax = new JLabel("TAX");
		lblTax.setHorizontalAlignment(SwingConstants.CENTER);
		lblTax.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTax.setBounds(26, 11, 164, 35);
		transactionPanel.add(lblTax);
		
		lblSubtotal = new JLabel("SUBTOTAL");
		lblSubtotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSubtotal.setBounds(227, 11, 164, 35);
		transactionPanel.add(lblSubtotal);
		
		lblTotal = new JLabel("TOTAL");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotal.setBounds(421, 11, 164, 35);
		transactionPanel.add(lblTotal);
		
		lblPayMethod = new JLabel("PAY METHOD");
		lblPayMethod.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayMethod.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPayMethod.setBounds(26, 125, 164, 35);
		transactionPanel.add(lblPayMethod);
		
		lblDisplayCash = new JLabel("DISPLAY CASH");
		lblDisplayCash.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisplayCash.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDisplayCash.setBounds(227, 125, 164, 35);
		transactionPanel.add(lblDisplayCash);
		
		txtDisplayCash = new JTextField();
		txtDisplayCash.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtDisplayCash.setColumns(10);
		txtDisplayCash.setBounds(227, 160, 164, 43);
		transactionPanel.add(txtDisplayCash);
		
		lblChange = new JLabel("CHANGE");
		lblChange.setHorizontalAlignment(SwingConstants.CENTER);
		lblChange.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChange.setBounds(421, 125, 164, 35);
		transactionPanel.add(lblChange);
		
		txtChange = new JTextField();
		txtChange.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtChange.setColumns(10);
		txtChange.setBounds(421, 160, 164, 42);
		transactionPanel.add(txtChange);
		
		/*
		 * 
		 * JCOMBO ITEMS & DESIGN
		 * 
		 */
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(new Color(255, 255, 255));
		
		comboBox.addItem("Cash");
		comboBox.addItem("Visa");
		comboBox.addItem("Mastercard");
		
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox.setBounds(26, 160, 164, 42);
		transactionPanel.add(comboBox);
		
		JLabel lblCardPayMethod = new JLabel("");
		lblCardPayMethod.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		lblCardPayMethod.setHorizontalAlignment(SwingConstants.CENTER);
		lblCardPayMethod.setForeground(new Color(255, 0, 0));
		lblCardPayMethod.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblCardPayMethod.setBounds(112, 224, 473, 35);
		transactionPanel.add(lblCardPayMethod);
		
		JLabel lblStatus = new JLabel("STATUS:");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStatus.setBounds(26, 224, 76, 35);
		transactionPanel.add(lblStatus);

		/*
		 * 
		 * 
		 * 
		 * MOUSE CLICKS MENU
		 * 
		 * 
		 * 
		 */
		
		main_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				double PriceOfItem = 80;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Chicago Hotdog", "1", PriceOfItem});
				ItemCost();
			}
			
			public void mouseEntered(java.awt.event.MouseEvent evt) {
			       lblMain_1.setForeground(Color.GREEN);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
		        lblMain_1.setForeground(Color.BLACK);
		    }
		});
		main_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				double PriceOfItem = 80;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Corn Dogs", "1", PriceOfItem});
				ItemCost();
			}
			public void mouseEntered(java.awt.event.MouseEvent evt) {
			       lblMain_2.setForeground(Color.GREEN);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
		        lblMain_2.setForeground(Color.BLACK);
		    }
		});
		main_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				double PriceOfItem = 95;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Hamburger", "1", PriceOfItem});
				ItemCost();
			}
			public void mouseEntered(java.awt.event.MouseEvent evt) {
			       lblMain_3.setForeground(Color.GREEN);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
		        lblMain_3.setForeground(Color.BLACK);
		    }
		});
		main_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				double PriceOfItem = 150;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Mac & Cheese", "1", PriceOfItem});
				ItemCost();
			}
			public void mouseEntered(java.awt.event.MouseEvent evt) {
			       lblMain_4.setForeground(Color.GREEN);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
		        lblMain_4.setForeground(Color.BLACK);
			}
		});
		main_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double PriceOfItem = 300;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"New York Pizza", "1", PriceOfItem});
				ItemCost();
			}
			public void mouseEntered(java.awt.event.MouseEvent evt) {
			       lblMain_5.setForeground(Color.GREEN);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
		        lblMain_5.setForeground(Color.BLACK);
			}
		});
		main_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double PriceOfItem = 120;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Philly Cheesesteak", "1", PriceOfItem});
				ItemCost();
			}
			public void mouseEntered(java.awt.event.MouseEvent evt) {
			       lblMain_6.setForeground(Color.GREEN);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
		        lblMain_6.setForeground(Color.BLACK);
			}
		});
		main_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double PriceOfItem = 120;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Reuben", "1", PriceOfItem});
				ItemCost();
			}
			public void mouseEntered(java.awt.event.MouseEvent evt) {
			       lblMain_7.setForeground(Color.GREEN);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
		        lblMain_7.setForeground(Color.BLACK);
			}
		});
		main_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double PriceOfItem = 130;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Cherry Pie", "1", PriceOfItem});
				ItemCost();
			}
			public void mouseEntered(java.awt.event.MouseEvent evt) {
			       lblMain_8.setForeground(Color.GREEN);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
		        lblMain_8.setForeground(Color.BLACK);
			}
		});

		beverage_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double PriceOfItem = 70;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Classic Manhattan", "1", PriceOfItem});
				ItemCost();
			}
			public void mouseEntered(java.awt.event.MouseEvent evt) {
			       lblBeverage_1.setForeground(Color.BLUE);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
		        lblBeverage_1.setForeground(Color.BLACK);
			}
		});
		beverage_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double PriceOfItem = 70;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Dirty Martini", "1", PriceOfItem});
				ItemCost();
			}
			public void mouseEntered(java.awt.event.MouseEvent evt) {
			       lblBeverage_2.setForeground(Color.BLUE);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
		        lblBeverage_2.setForeground(Color.BLACK);
			}
		});
		beverage_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double PriceOfItem = 70;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Gin Rickey", "1", PriceOfItem});
				ItemCost();
			}
			public void mouseEntered(java.awt.event.MouseEvent evt) {
			       lblBeverage_3.setForeground(Color.BLUE);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
		        lblBeverage_3.setForeground(Color.BLACK);
			}
		});
		beverage_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double PriceOfItem = 70;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Hurricane Cocktail", "1", PriceOfItem});
				ItemCost();
			}
			public void mouseEntered(java.awt.event.MouseEvent evt) {
			       lblBeverage_4.setForeground(Color.BLUE);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
		        lblBeverage_4.setForeground(Color.BLACK);
			}
		});
		beverage_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double PriceOfItem = 70;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Lynchburg Lemonade", "1", PriceOfItem});
				ItemCost();
			}
			public void mouseEntered(java.awt.event.MouseEvent evt) {
			       lblBeverage_5.setForeground(Color.BLUE);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
		        lblBeverage_5.setForeground(Color.BLACK);
			}
		});
		beverage_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double PriceOfItem = 70;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Sazerac", "1", PriceOfItem});
				ItemCost();
			}
			public void mouseEntered(java.awt.event.MouseEvent evt) {
			       lblBeverage_6.setForeground(Color.BLUE);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
		        lblBeverage_6.setForeground(Color.BLACK);
			}
		});
		beverage_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double PriceOfItem = 70;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Wisconsin Brandy", "1", PriceOfItem});
				ItemCost();
			}
			public void mouseEntered(java.awt.event.MouseEvent evt) {
			       lblBeverage_7.setForeground(Color.BLUE);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
		        lblBeverage_7.setForeground(Color.BLACK);
			}
		});
		beverage_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double PriceOfItem = 70;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Orange Creamsicle", "1", PriceOfItem});
				ItemCost();
			}
			public void mouseEntered(java.awt.event.MouseEvent evt) {
			       lblBeverage_8.setForeground(Color.BLUE);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
		        lblBeverage_8.setForeground(Color.BLACK);
			}
		});

		favorites_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double PriceOfItem = 300;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"New York Pizza", "1", PriceOfItem});
				ItemCost();
			}
			public void mouseEntered(java.awt.event.MouseEvent evt) {
			       lblFavorites_1.setForeground(Color.GREEN);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
		        lblFavorites_1.setForeground(Color.BLACK);
			}
		});
		favorites_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double PriceOfItem = 95;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Hamburger", "1", PriceOfItem});
				ItemCost();
			}
			public void mouseEntered(java.awt.event.MouseEvent evt) {
			       lblFavorites_2.setForeground(Color.GREEN);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
		        lblFavorites_2.setForeground(Color.BLACK);
			}
		});
		favorites_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double PriceOfItem = 80;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Chicago Hotdog", "1", PriceOfItem});
				ItemCost();
			}
			public void mouseEntered(java.awt.event.MouseEvent evt) {
			       lblFavorites_3.setForeground(Color.GREEN);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
		        lblFavorites_3.setForeground(Color.BLACK);
			}
		});
		favorites_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double PriceOfItem = 120;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Philly Cheesesteak", "1", PriceOfItem});
				ItemCost();
			}
			public void mouseEntered(java.awt.event.MouseEvent evt) {
			       lblFavorites_4.setForeground(Color.GREEN);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
		        lblFavorites_4.setForeground(Color.BLACK);
			}
		});
		favorites_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double PriceOfItem = 70;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Classic Manhattan", "1", PriceOfItem});
				ItemCost();
			}
			public void mouseEntered(java.awt.event.MouseEvent evt) {
			       lblFavorites_5.setForeground(Color.BLUE);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
				lblFavorites_5.setForeground(Color.BLACK);
			}
		});
		favorites_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double PriceOfItem = 70;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"Hurricane Cocktail", "1", PriceOfItem});
				ItemCost();
			}
			public void mouseEntered(java.awt.event.MouseEvent evt) {
			       lblFavorites_6.setForeground(Color.BLUE);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
				lblFavorites_6.setForeground(Color.BLACK);
			}
		});
		
		/*
		 * 
		 * 
		 * 
		 * TRANSACTION PANEL AND FUNCTIONS
		 * 
		 * 
		 * 
		 */
		
		JPanel transactionButtonsPanel = new JPanel();
		transactionButtonsPanel.setBackground(new Color(255, 255, 255));
		transactionButtonsPanel.setBounds(10, 538, 620, 152);
		contentPane.add(transactionButtonsPanel);
		transactionButtonsPanel.setLayout(null);
		
		/*
		 * 
		 * PAY BUTTON 
		 * 
		 */

		JButton btnPay = new JButton("PAY");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double visa = 50000;
				double mastercard = 100;
				double output;
				
				String t1_Total = txtTotal.getText();
				String t2_Total = t1_Total.substring(2);
				double finalTotal = Double.parseDouble(t2_Total);
				
				if (comboBox.getSelectedItem().equals("Cash") && matchMaking()) {
					Change();
					lblCardPayMethod.setText("Transaction SUCCESSFUL!");
					lblCardPayMethod.setForeground(Color.GREEN);
				} else if (comboBox.getSelectedItem().equals("Cash") && matchMaking() == false) {
					JOptionPane.showMessageDialog(null, "Please TYPE IN cash amount first!");
				// SUCCESS VISA
				} else if (comboBox.getSelectedItem().equals("Visa") && visa >= finalTotal) {
					output = visa - finalTotal;
					JOptionPane.showMessageDialog(null, "Visa is successfully deducted and customer's"
							+ " current balance is\n₱ " + output);
					lblCardPayMethod.setText("Transaction SUCCESSFUL!");
					lblCardPayMethod.setForeground(Color.GREEN);
				// FAILED VISA
				} else if (comboBox.getSelectedItem().equals("Visa") && visa < finalTotal) {
					JOptionPane.showMessageDialog(null, "Customer's account don't have enough balance to make this transaction."
							+ " Please TOP UP.");
					lblCardPayMethod.setText("Transaction FAILED!");
					lblCardPayMethod.setForeground(Color.RED);
				// SUCCESS MASTERCARD
				} else if (comboBox.getSelectedItem().equals("Mastercard") && mastercard >= finalTotal) {
					output = mastercard - finalTotal;
					JOptionPane.showMessageDialog(null, "Mastercard is successfully deducted and customer's"
							+ " current balance is\n₱ " + output);
					lblCardPayMethod.setText("Transaction SUCCESSFUL!");
					lblCardPayMethod.setForeground(Color.GREEN);
				// FAILED MASTERCARD
				} else if (comboBox.getSelectedItem().equals("Mastercard") && mastercard < finalTotal) {
					JOptionPane.showMessageDialog(null, "Customer's account don't have enough balance to make this transaction."
							+ " Please TOP UP.");
					lblCardPayMethod.setText("Transaction FAILED!");
					lblCardPayMethod.setForeground(Color.RED);
				} else {
					txtChange.setText("");
					txtDisplayCash.setText("");
				}
			}
		});
		btnPay.setForeground(Color.WHITE);
		btnPay.setFont(new Font("Dialog", Font.BOLD, 17));
		btnPay.setBackground(new Color(0, 255, 0));
		btnPay.setBounds(0, 0, 206, 77);
		transactionButtonsPanel.add(btnPay);
		
		/*
		 * 
		 * RESET BUTTON 
		 * 
		 */
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDisplayCash.setText(null);
				txtChange.setText(null);
				txtTax.setText(null);
				txtSubTotal.setText(null);
				txtTotal.setText(null);
				lblCardPayMethod.setText(null);
				
				DefaultTableModel RecordTable = (DefaultTableModel) table.getModel();
				RecordTable.setRowCount(0);
			}
		});
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Dialog", Font.BOLD, 17));
		btnReset.setBackground(new Color(0, 255, 0));
		btnReset.setBounds(414, 0, 206, 77);
		transactionButtonsPanel.add(btnReset);
		
		/*
		 * 
		 * REMOVE ITEM BUTTON 
		 * 
		 */
		
		JButton btnRemoveItem = new JButton("REMOVE ITEM");
		btnRemoveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				int RemoveItem = table.getSelectedRow();
				if(RemoveItem >= 0) {
					model.removeRow(RemoveItem);
				} else {
					JOptionPane.showMessageDialog(null, "Please SELECT from the ORDER SUMMARY!");
				}
				ItemCost();
				
				if(comboBox.getSelectedItem().equals("Cash")) {
					Change();
				} else {
					txtChange.setText("");
					txtDisplayCash.setText("");
				}
			}
		});
		btnRemoveItem.setForeground(Color.WHITE);
		btnRemoveItem.setFont(new Font("Dialog", Font.BOLD, 17));
		btnRemoveItem.setBackground(new Color(255, 0, 0));
		btnRemoveItem.setBounds(0, 75, 314, 77);
		transactionButtonsPanel.add(btnRemoveItem);
		
		/*
		 * 
		 * PRINT BUTTON 
		 * 
		 */

		JButton btnPrint = new JButton("PRINT");
		btnPrint.setForeground(Color.WHITE);
		btnPrint.setFont(new Font("Dialog", Font.BOLD, 17));
		btnPrint.setBackground(new Color(0, 255, 0));
		btnPrint.setBounds(205, 0, 211, 77);
		transactionButtonsPanel.add(btnPrint);
		
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat header = new MessageFormat("Printing in Progress");
				MessageFormat footer = new MessageFormat("Page {0, number, integer}");
						
				try {
					table.print(JTable.PrintMode.NORMAL,header,footer);
				}
				catch(java.awt.print.PrinterException ex) {
					System.err.format("No Printer Found", ex.getMessage());
				}
			
			}
		});
		
		/*
		 * 
		 * EXIT BUTTON 
		 * 
		 */
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("Exit");
				
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Point of Sale",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				};
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Dialog", Font.BOLD, 17));
		btnExit.setBackground(new Color(0, 0, 255));
		btnExit.setBounds(311, 75, 309, 77);
		transactionButtonsPanel.add(btnExit);
	}
}