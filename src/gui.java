import java.awt.EventQueue;
import java.awt.event.*;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.Border;

public class gui {

	// create our 2 frames for our 2 screens
	private JFrame frame;
	private JFrame frame2;
	
	// create our various text fields
	private JTextField textField;
	private JTextField textField2;
	private JTextField textField_1;
	private JTextField textField_12;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// start frame as the home screen
					gui window = new gui();
					window.frame.setVisible(true);
					window.frame2.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		// define our first frame
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// various images needed for frame 1 and frame 2
		ImageIcon red = new ImageIcon(getClass().getClassLoader().getResource("Red.png"));
		ImageIcon green = new ImageIcon(getClass().getClassLoader().getResource("Green.png"));
		ImageIcon spiderRoll = new ImageIcon(getClass().getClassLoader().getResource("SpiderRoll.jpg"));
		ImageIcon tigerRoll = new ImageIcon(getClass().getClassLoader().getResource("TigerRoll.png"));
		ImageIcon teriyakiRoll = new ImageIcon(getClass().getClassLoader().getResource("TeriyakiRoll.png"));
		ImageIcon defaultImage = new ImageIcon(getClass().getClassLoader().getResource("DefaultImage.png"));
		ImageIcon tonkotsuRamen = new ImageIcon(getClass().getClassLoader().getResource("TonkotsuRamen.png"));
		ImageIcon tantanRamen = new ImageIcon(getClass().getClassLoader().getResource("TantanRamen.png"));
		
		// create a text area behind the label to to show the receipt when checking out
	    JTextArea textArea = new JTextArea();
	    textArea.setBounds(431, 0, 366, 528);
	    textArea.setEditable(false);
	    textArea.setVisible(false);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    frame.getContentPane().add(textArea);
		
		// label that displays food item picture on the right
		JLabel lblNewLabel = new JLabel(defaultImage);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(431, 0, 366, 528);
		frame.getContentPane().add(lblNewLabel);
		
		// create a label for the custom instructions text field
		JLabel lblNewLabel_1 = new JLabel("Custom Instructions:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(30, 47, 132, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		// create our radio buttons: choices of meat for Teriyaki Roll
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Chicken", true);
		rdbtnNewRadioButton.setBounds(50, 157, 76, 21);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Beef");
		rdbtnNewRadioButton_1.setBounds(128, 157, 57, 21);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
	    JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Salmon");
	    rdbtnNewRadioButton_2.setBounds(189, 157, 103, 21);
	    frame.getContentPane().add(rdbtnNewRadioButton_2);
		
	    // add our radio buttons a button group
	    ButtonGroup group = new ButtonGroup();
	    group.add(rdbtnNewRadioButton);
	    group.add(rdbtnNewRadioButton_1);
	    group.add(rdbtnNewRadioButton_2);
	    
	    // create a checkbox for food order
	    JCheckBox chckbxNewCheckBox = new JCheckBox("Spider Roll");
	    chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    // put an event listener on the checkbox
	    chckbxNewCheckBox.addItemListener(new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if(e.getStateChange() == ItemEvent.SELECTED) { //checkbox has been selected
	            	lblNewLabel.setIcon(spiderRoll);
	            } else {
	            	lblNewLabel.setIcon(defaultImage);
	            };
	        }
	    });	    
	    chckbxNewCheckBox.setBounds(20, 24, 165, 21);
	    frame.getContentPane().add(chckbxNewCheckBox);
	    
	    // create a checkbox for food order
	    JCheckBox chckbxNewCheckBox2 = new JCheckBox("Tiger Roll");
	    chckbxNewCheckBox2.setBounds(20, 75, 159, 27);
	    chckbxNewCheckBox2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    // put an event listener on the checkbox
	    chckbxNewCheckBox2.addItemListener(new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if(e.getStateChange() == ItemEvent.SELECTED) { //checkbox has been selected
	            	lblNewLabel.setIcon(tigerRoll);
	            } else {
	            	lblNewLabel.setIcon(defaultImage);
	            };
	        }
	    });
	    frame.getContentPane().add(chckbxNewCheckBox2);
	    
	    // create a label for the checkbox
	    JLabel lblNewLabel_2 = new JLabel("Qty:");
	    lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    lblNewLabel_2.setBounds(185, 26, 57, 17);
	    frame.getContentPane().add(lblNewLabel_2);
	    frame.setVisible(true);
	    
	    // create a combo box to choose number of food wanted
	    String comboBoxOptions[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
	    JComboBox comboBox = new JComboBox(comboBoxOptions);
	    comboBox.setBounds(221, 25, 36, 21);
	    frame.getContentPane().add(comboBox);
	    
	    textField = new JTextField();
	    textField.setBounds(160, 53, 132, 19);
	    frame.getContentPane().add(textField);
	    textField.setColumns(10);
	    
	    // create our titled border
	    Border blackLine = BorderFactory.createTitledBorder("Submit Order?");
	    
	    // create the menu 
	    JMenu mnNewMenu = new JMenu("Sushi Menu");
	    	    
	    // create menu items that go in the menu
	    JMenuItem menuItem1 = new JMenuItem("Sushi Menu");
	    
	    JMenuItem menuItem2 = new JMenuItem("Ramen Menu");
	    // add an event listener to the menu item
	    menuItem2.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // set the bounds of frame2 so it moves where frame1 closes
	            frame2.setBounds(frame.getBounds());
	            
	            // set frame1 as not visible, and make frame 2 visible
	            frame.setVisible(false);
	            frame2.setVisible(true);
	           
	            ;}
	    });	
	    
	    // add menu items to the menu
	    mnNewMenu.add(menuItem1);
	    mnNewMenu.add(menuItem2);
	    
	    // add a tooltip to the menu
	    mnNewMenu.setToolTipText("Drop Down Menu");  
	    
	    // create a menu bar and add the menu to it
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(mnNewMenu);
	    frame.setJMenuBar(menuBar);  
	    frame.setSize(821,607);  
	    frame.getContentPane().setLayout(null);  
	    
	    // create a button to close the app
	    JButton btnNewButton_1 = new JButton("Exit", red);
	    btnNewButton_1.setVerticalTextPosition(SwingConstants.CENTER);
	    btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
	    btnNewButton_1.setBounds(157, 288, 85, 21);
	    btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	    frame.setVisible(false);
	    	    frame2.setVisible(false);
	    	}
	    });
	    
	    JLabel lblNewLabel_2_1 = new JLabel("Qty:");
	    lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    lblNewLabel_2_1.setBounds(185, 80, 57, 17);
	    frame.getContentPane().add(lblNewLabel_2_1);
	    
	    JComboBox comboBox_1 = new JComboBox(new Object[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"});
	    comboBox_1.setBounds(221, 79, 36, 21);
	    frame.getContentPane().add(comboBox_1);
	    
	    textField_1 = new JTextField();
	    textField_1.setColumns(10);
	    textField_1.setBounds(160, 107, 132, 19);
	    frame.getContentPane().add(textField_1);
	    
	    JLabel lblNewLabel_1_1 = new JLabel("Custom Instructions:");
	    lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    lblNewLabel_1_1.setBounds(30, 101, 132, 28);
	    frame.getContentPane().add(lblNewLabel_1_1);
	    	    
	    // create a checkbox for food order
	    JCheckBox chckbxNewCheckBox2_1 = new JCheckBox("Teriyaki Roll");
	    chckbxNewCheckBox2_1.setBounds(20, 128, 142, 27);
	    chckbxNewCheckBox2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    // put an event listener on the checkbox
	    chckbxNewCheckBox2_1.addItemListener(new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if(e.getStateChange() == ItemEvent.SELECTED) { //checkbox has been selected
	            	lblNewLabel.setIcon(teriyakiRoll);
	            } else {
	            	lblNewLabel.setIcon(defaultImage);
	            };
	        }
	    });
	    frame.getContentPane().add(chckbxNewCheckBox2);
	    
	    chckbxNewCheckBox2_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    chckbxNewCheckBox2_1.setBounds(20, 128, 103, 27);
	    frame.getContentPane().add(chckbxNewCheckBox2_1);
	    
	    JLabel lblNewLabel_1_1_1 = new JLabel("Custom Instructions:");
	    lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    lblNewLabel_1_1_1.setBounds(30, 178, 132, 28);
	    frame.getContentPane().add(lblNewLabel_1_1_1);
	    
	    JLabel lblNewLabel_2_1_1 = new JLabel("Qty:");
	    lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    lblNewLabel_2_1_1.setBounds(185, 132, 57, 17);
	    frame.getContentPane().add(lblNewLabel_2_1_1);
	    
	    JComboBox comboBox_1_1 = new JComboBox(new Object[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"});
	    comboBox_1_1.setBounds(221, 131, 36, 21);
	    frame.getContentPane().add(comboBox_1_1);
	    
	    //FRAME 2 PARTS THAT MUST BE DEFINED FIRST TO PRINT THE RECEIPT
	    // SECOND FRAME
		// define our frame
		frame2 = new JFrame();
		frame2.setBounds(100, 100, 450, 300);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
	    // create a combo box to choose number of food wanted (tonkotsu combo box)
	    String comboBoxOptions2[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
	    JComboBox comboBox2 = new JComboBox(comboBoxOptions2);
	    comboBox2.setBounds(221, 25, 36, 21);
	    frame2.getContentPane().add(comboBox2);
	    
	    // combo box for tantan ramen
	    JComboBox comboBox_12 = new JComboBox(new Object[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"});
	    comboBox_12.setBounds(221, 79, 36, 21);
	    frame2.getContentPane().add(comboBox_12);
		
		// label that displays food item picture on the right
		JLabel lblNewLabel2 = new JLabel(defaultImage);
		lblNewLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel2.setBounds(431, 0, 366, 528);
		frame2.getContentPane().add(lblNewLabel2);
		
	    // create a checkbox for food order
	    JCheckBox chckbxNewCheckBox3 = new JCheckBox("Tonkotsu Ramen");
	    chckbxNewCheckBox3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    // put an event listener on the checkbox
	    chckbxNewCheckBox3.addItemListener(new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if(e.getStateChange() == ItemEvent.SELECTED) { //checkbox has been selected
	            	lblNewLabel2.setIcon(tonkotsuRamen);
	            } else {
	            	lblNewLabel2.setIcon(defaultImage);
	            };
	        }
	    });	    
	    chckbxNewCheckBox3.setBounds(20, 24, 165, 21);
	    frame2.getContentPane().add(chckbxNewCheckBox3);
	    
	    // create a checkbox for food order
	    JCheckBox chckbxNewCheckBox22 = new JCheckBox("Tantan Ramen");
	    chckbxNewCheckBox22.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    // put an event listener on the checkbox
	    chckbxNewCheckBox22.addItemListener(new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if(e.getStateChange() == ItemEvent.SELECTED) { //checkbox has been selected
	            	lblNewLabel2.setIcon(tantanRamen);
	            } else {
	            	lblNewLabel2.setIcon(defaultImage);
	            };
	        }
	    });
	    chckbxNewCheckBox22.setBounds(20, 75, 159, 27);
	    frame2.getContentPane().add(chckbxNewCheckBox22);
	    
		// create a text area behind the label to to show the receipt when checking out
	    JTextArea textArea2 = new JTextArea();
	    textArea2.setBounds(431, 0, 366, 528);
	    textArea2.setEditable(false);
	    textArea2.setVisible(false);
		textArea2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    frame2.getContentPane().add(textArea2);
	    
	    // create a button to submit an order
	    JButton btnNewButton = new JButton("Submit", green);
	    btnNewButton.setVerticalTextPosition(SwingConstants.CENTER);
	    btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
	    // create an event listener for the button
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	        	String receipt = ("Thanks for your order with Sushi R Us!\n\nHere's the receipt of what you ordered:\n\n");
	        	if (chckbxNewCheckBox.isSelected()) {
	        		receipt += chckbxNewCheckBox.getText() + " x" + comboBox.getSelectedItem() + "\n";
	        		receipt += "    Custom Instructions: " + textField.getText() + "\n\n";
	        	}
	           	if (chckbxNewCheckBox2.isSelected()) {
	        		receipt += chckbxNewCheckBox2.getText() + " x" + comboBox_1.getSelectedItem() + "\n";
	        		receipt += "    Custom Instructions: " + textField_1.getText() + "\n\n";
	        	}
	           	if (chckbxNewCheckBox2_1.isSelected()) {
	           		if (rdbtnNewRadioButton.isSelected()) {
	        			receipt += rdbtnNewRadioButton.getText() + " ";
	        		} else if (rdbtnNewRadioButton_1.isSelected()) {
	        			receipt += rdbtnNewRadioButton_1.getText() + " ";
	        		} else if (rdbtnNewRadioButton_2.isSelected()) {
	        			receipt += rdbtnNewRadioButton_2.getText() + " ";
	        		}
	        		receipt += chckbxNewCheckBox2_1.getText() + " x" + comboBox_1_1.getSelectedItem() + "\n";
	        		receipt += "    Custom Instructions: " + textField_2.getText() + "\n\n";
	        	}
	           	if (chckbxNewCheckBox3.isSelected()) {
	        		receipt += chckbxNewCheckBox3.getText() + " x" + comboBox2.getSelectedItem() + "\n";
	        		receipt += "    Custom Instructions: " + textField2.getText() + "\n\n";
	        	}
	           	if (chckbxNewCheckBox22.isSelected()) {
	        		receipt += chckbxNewCheckBox22.getText() + " x" + comboBox_12.getSelectedItem() + "\n";
	        		receipt += "    Custom Instructions: " + textField_12.getText() + "\n\n";
	        	}
	           	
	        	textArea2.setText(receipt);
	        	textArea.setText(receipt);
	        	lblNewLabel2.setVisible(false);
	        	lblNewLabel.setVisible(false);
	        	textArea2.setVisible(true);
	        	textArea.setVisible(true);
	    	}
	    });
	    btnNewButton.setBounds(50, 288, 85, 21);
	    
	    // create our panel and add it to the frame
	    JPanel panel3 = new JPanel(new GridLayout(1,2,10,0));
	    panel3.setBounds(30, 245, 227, 52);
	    panel3.add(btnNewButton);
	    panel3.add(btnNewButton_1);
	    panel3.setBorder(blackLine);
	    frame.getContentPane().add(panel3);
	    
	    textField_2 = new JTextField();
	    textField_2.setColumns(10);
	    textField_2.setBounds(160, 184, 132, 19);
	    frame.getContentPane().add(textField_2);
		
		// create a label for the custom instructions text field
		JLabel lblNewLabel_12 = new JLabel("Custom Instructions:");
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_12.setBounds(30, 47, 132, 28);
		frame2.getContentPane().add(lblNewLabel_12);
	    
	    // create a label for the checkbox
	    JLabel lblNewLabel_22 = new JLabel("Qty:");
	    lblNewLabel_22.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    lblNewLabel_22.setBounds(185, 26, 57, 17);
	    frame2.getContentPane().add(lblNewLabel_22);
	    frame2.setVisible(true);
	    
	    textField2 = new JTextField();
	    textField2.setBounds(160, 53, 132, 19);
	    frame2.getContentPane().add(textField2);
	    textField2.setColumns(10);
	    
	    // create our titled border
	    Border blackLine2 = BorderFactory.createTitledBorder("Submit Order?");
	    
	    // create the menu 
	    JMenu mnNewMenu2 = new JMenu("Ramen Menu");
	    	    
	    // create menu items that go in the menu
	    JMenuItem menuItem12 = new JMenuItem("Ramen Menu");
	    
	    JMenuItem menuItem22 = new JMenuItem("Sushi Menu");
	    // add an event listener to the menu item
	    menuItem22.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            // set the bounds of frame2 so it moves where frame1 closes
	            frame.setBounds(frame2.getBounds());
	            
	            // set frame1 as not visible, and make frame 2 visible
	            frame2.setVisible(false);
	            frame.setVisible(true);
	            ;}
	    });	
	    
	    // add menu items to the menu
	    mnNewMenu2.add(menuItem12);
	    mnNewMenu2.add(menuItem22);
	    
	    // add a tooltip to the menu
	    mnNewMenu2.setToolTipText("Drop Down Menu");  
	    
	    // create a menu bar and add the menu to it
        JMenuBar menuBar2 = new JMenuBar();
        menuBar2.add(mnNewMenu2);
	    frame2.setJMenuBar(menuBar2);  
	    frame2.setSize(821,607);  
	    frame2.getContentPane().setLayout(null);  
	    
	    // create a button to close the app
	    JButton btnNewButton_12 = new JButton("Exit", red);
	    btnNewButton_12.setVerticalTextPosition(SwingConstants.CENTER);
	    btnNewButton_12.setHorizontalTextPosition(SwingConstants.CENTER);
	    btnNewButton_12.setBounds(157, 288, 85, 21);
	    btnNewButton_12.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	    frame.setVisible(false);
	    	    frame2.setVisible(false);
	    	}
	    });
	    
	    JLabel lblNewLabel_2_12 = new JLabel("Qty:");
	    lblNewLabel_2_12.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    lblNewLabel_2_12.setBounds(185, 80, 57, 17);
	    frame2.getContentPane().add(lblNewLabel_2_12);
	    
	    textField_12 = new JTextField();
	    textField_12.setColumns(10);
	    textField_12.setBounds(160, 107, 132, 19);
	    frame2.getContentPane().add(textField_12);
	    
	    JLabel lblNewLabel_1_12 = new JLabel("Custom Instructions:");
	    lblNewLabel_1_12.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    lblNewLabel_1_12.setBounds(30, 101, 132, 28);
	    frame2.getContentPane().add(lblNewLabel_1_12);
	    
	    // create a button to submit an order
	    JButton btnNewButton2 = new JButton("Submit", green);
	    btnNewButton2.setVerticalTextPosition(SwingConstants.CENTER);
	    btnNewButton2.setHorizontalTextPosition(SwingConstants.CENTER);
	    // create an event listener for the button
	    btnNewButton2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	        	String receipt = ("Thanks for your order with Sushi R Us!\n\nHere's the receipt of what you ordered:\n\n");
	        	if (chckbxNewCheckBox.isSelected()) {
	        		receipt += chckbxNewCheckBox.getText() + " x" + comboBox.getSelectedItem() + "\n";
	        		receipt += "    Custom Instructions: " + textField.getText() + "\n\n";
	        	}
	           	if (chckbxNewCheckBox2.isSelected()) {
	        		receipt += chckbxNewCheckBox2.getText() + " x" + comboBox_1.getSelectedItem() + "\n";
	        		receipt += "    Custom Instructions: " + textField_1.getText() + "\n\n";
	        	}
	           	if (chckbxNewCheckBox2_1.isSelected()) {
	           		if (rdbtnNewRadioButton.isSelected()) {
	        			receipt += rdbtnNewRadioButton.getText() + " ";
	        		} else if (rdbtnNewRadioButton_1.isSelected()) {
	        			receipt += rdbtnNewRadioButton_1.getText() + " ";
	        		} else if (rdbtnNewRadioButton_2.isSelected()) {
	        			receipt += rdbtnNewRadioButton_2.getText() + " ";
	        		}
	        		receipt += chckbxNewCheckBox2_1.getText() + " x" + comboBox_1_1.getSelectedItem() + "\n";
	        		receipt += "    Custom Instructions: " + textField_2.getText() + "\n\n";
	        	}
	           	if (chckbxNewCheckBox3.isSelected()) {
	        		receipt += chckbxNewCheckBox3.getText() + " x" + comboBox2.getSelectedItem() + "\n";
	        		receipt += "    Custom Instructions: " + textField2.getText() + "\n\n";
	        	}
	           	if (chckbxNewCheckBox22.isSelected()) {
	        		receipt += chckbxNewCheckBox22.getText() + " x" + comboBox_12.getSelectedItem() + "\n";
	        		receipt += "    Custom Instructions: " + textField_12.getText() + "\n\n";
	        	}
	           		
	        	textArea2.setText(receipt);
	        	textArea.setText(receipt);
	        	lblNewLabel2.setVisible(false);
	        	lblNewLabel.setVisible(false);
	        	textArea2.setVisible(true);
	        	textArea.setVisible(true);
	    	}
	    });
	    btnNewButton2.setBounds(50, 288, 85, 21);
	    
	    // create our panel and add it to the frame
	    JPanel panel32 = new JPanel(new GridLayout(1,2,10,0));
	    panel32.setBounds(30, 245, 227, 52);
	    panel32.add(btnNewButton2);
	    panel32.add(btnNewButton_12);
	    panel32.setBorder(blackLine2);
	    frame2.getContentPane().add(panel32);
	}
}
