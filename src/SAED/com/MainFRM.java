package SAED.com;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainFRM extends JFrame {

	private JPanel contentPane;
	private JTextField txtAGE;
	private JTextField txtName;
	private JTextField txtSurname;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtIDNUM;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFRM frame = new MainFRM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFRM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtAGE = new JTextField();
		txtAGE.setBounds(94, 148, 96, 31);
		contentPane.add(txtAGE);
		txtAGE.setColumns(10);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(10, 156, 48, 14);
		contentPane.add(lblAge);
		
		///////////////
		
		
		
		
		UtilDateModel model = new UtilDateModel();
		//model.setDate(20,04,2014);
		// Need this...
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		// Don't know about the formatter, but there it is...
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
		datePicker.setBounds(94, 301, 169, 31);
		contentPane.add(datePicker);
		
		/////////////
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 69, 48, 14);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(94, 66, 96, 31);
		contentPane.add(txtName);
		
		JLabel lblNewLabel = new JLabel("Medical Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(10, 11, 153, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(10, 108, 74, 14);
		contentPane.add(lblSurname);
		
		txtSurname = new JTextField();
		txtSurname.setColumns(10);
		txtSurname.setBounds(94, 105, 96, 31);
		contentPane.add(txtSurname);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setBounds(91, 210, 76, 23);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setBounds(185, 210, 78, 23);
		contentPane.add(rdbtnFemale);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(10, 214, 48, 14);
		contentPane.add(lblGender);
		
		JLabel lblID = new JLabel("ID Number");
		lblID.setBounds(10, 261, 74, 14);
		contentPane.add(lblID);
		
		txtIDNUM = new JTextField();
		txtIDNUM.setColumns(10);
		txtIDNUM.setBounds(94, 253, 96, 31);
		contentPane.add(txtIDNUM);
		
		JLabel lblDOB = new JLabel("DOB");
		lblDOB.setBounds(10, 304, 48, 14);
		contentPane.add(lblDOB);
		
		
		
		JLabel lblNameError = new JLabel("");
		lblNameError.setForeground(Color.RED);
		lblNameError.setBounds(246, 69, 216, 14);
		contentPane.add(lblNameError);
		
		JLabel lblSurnameError = new JLabel("");
		lblSurnameError.setForeground(Color.RED);
		lblSurnameError.setBounds(246, 108, 216, 14);
		contentPane.add(lblSurnameError);
		
		JLabel lblAgeError = new JLabel("");
		lblAgeError.setForeground(Color.RED);
		lblAgeError.setBounds(246, 156, 342, 14);
		contentPane.add(lblAgeError);
		
		JLabel lblIDError = new JLabel("");
		lblIDError.setForeground(Color.RED);
		lblIDError.setBounds(200, 240, 388, 50);
		contentPane.add(lblIDError);
		
		JLabel lblDOBError = new JLabel("");
		lblDOBError.setForeground(Color.RED);
		lblDOBError.setBounds(278, 290, 354, 50);
		contentPane.add(lblDOBError);
		
		JLabel lblGenderError = new JLabel("");
		lblGenderError.setForeground(Color.RED);
		lblGenderError.setBounds(278, 210, 216, 31);
		contentPane.add(lblGenderError);
		
		JLabel lblValid = new JLabel("");
		lblValid.setForeground(Color.RED);
		lblValid.setBounds(234, 377, 354, 50);
		contentPane.add(lblValid);
		
		JButton btnValidate = new JButton("Validate");
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean er1 = true;
				boolean er2 = true;
				boolean er3 = true;
				boolean er4 = true;
				boolean er5 = true;
				boolean er6 = true;
				
				if (rdbtnMale.isSelected() == false && rdbtnFemale.isSelected() == false) {
					lblGenderError.setText("Please select a gender");
					er2 = true;
				}else {
					lblGenderError.setText("");
					er2 = false;
				}
				
				try {  
				    Integer.parseInt(txtAGE.getText());  
				    lblAgeError.setText("");
				    er1 = false;
				    if (Integer.parseInt(txtAGE.getText()) < 0) {
				    	er1 = true;
				    }
				    
				  } catch(NumberFormatException t){  
				    lblAgeError.setText("Please enter a valid age"); 
				    er1 = true;
				  }  
				//if (txtIDNUM.getText().contains("a" + "b" + +++++++++++++++++++++++))
				if (txtName.getText().isBlank()) {
					lblNameError.setText("Please enter a name");
					er3 = true;
					
				}else {
					lblNameError.setText("");
					er3 = false;
				}
				
				if (txtSurname.getText().isBlank()) {
					lblSurnameError.setText("Please enter a surname");
					er4 = true;
					
					
				}else {
					lblSurnameError.setText("");
					er4 = false;
				}
				
				try {  
				    Integer.parseInt(txtIDNUM.getText());  
				    lblIDError.setText("");
				    er5 = false;
				    
				    
				  } catch(NumberFormatException t){  
				    lblIDError.setText("Please enter a valid ID");;  
				    er5 = true;
				  }  
				
				
				//if (Character.isDigit(txtAGE.getText().charAt(0))){
					
				//}
				
				if ((txtIDNUM.getText()+"1").equalsIgnoreCase("1")) {
					lblIDError.setText("An ID number is required");
					er5 = true;
				}
				
				if (!(datePicker.getJFormattedTextField().getText()+"1").equalsIgnoreCase("1")) {
				//System.out.println(datePicker.getJFormattedTextField().getText());
				Scanner DSC = new Scanner(datePicker.getJFormattedTextField().getText()).useDelimiter(" ");
				int day = DSC.nextInt();
				Month m = Month.JANUARY;
				String mint = "00";
				switch (DSC.next())
			    {
			    case "Jan":
			        m = Month.JANUARY;
			        mint = "01";
			        break;
			    case "Feb":
			    	m = Month.FEBRUARY;
			    	mint = "02";
			        break;
			    case "Mar":
			    	m = Month.MARCH;
			    	mint = "03";
			        break;
			    case "Apr":
			    	m = Month.APRIL;
			    	mint = "04";
			        break;
			    case "May":
			    	m = Month.MAY;
			    	mint = "05";
			        break;
			    case "Jun":
			    	m = Month.JUNE;
			    	mint = "06";
			        break;
			    case "Jul":
			    	m = Month.JULY;
			    	mint = "07";
			        break;
			    case "Aug":
			    	m = Month.AUGUST;
			    	mint = "08";
			        break;
			    case "Sep":
			    	m = Month.SEPTEMBER;
			    	mint = "09";
			        break;
			    case "Oct":
			    	m = Month.OCTOBER;
			    	mint = "10";
			        break;
			    case "Nov":
			    	m = Month.NOVEMBER;
			    	mint = "11";
			        break;
			    case "Dec":
			    	m = Month.DECEMBER;
			    	mint = "12";
			        break;
			        }
				int year = DSC.nextInt();
				
				LocalDate today = LocalDate.now();                //Today's date
				LocalDate birthday = LocalDate.of(year, m, day);  //Birth date
				 
				Period p = Period.between(birthday, today);
				
				String yt = year + "";
				String dt = "00";
				if (dt.length() == 1) {
					dt = "0" + day;
				}else {
					dt = day + "";
				}
				
				
				
				String idTemp = yt.substring(yt.length()-2) + mint + dt;
				if ((txtIDNUM.getText() + "1").equalsIgnoreCase("1")) {
					lblIDError.setText("An ID number is required");
					er5 = true;
				}else {
					
				
					String t = txtIDNUM.getText() + "000000";
					idTemp = yt.substring(yt.length()-2) + mint + dt;
					
				if (!(idTemp.equalsIgnoreCase(t.substring(0, 6)))){
					lblIDError.setText("The ID or the DOB you have entered is incorrect");
					er5 = true;
				}else{
					er5 = false;
					lblIDError.setText("");
					}
				}
				
				try {  
					if (p.isNegative()) {
						lblDOBError.setText("Birthdate cannot be in the future");
						er6 = true;
					}else {
					if (p.getYears() != (Integer.parseInt(txtAGE.getText()))){
						lblAgeError.setText("Your age is incorrect or you have entered an incorrect DOB");
						er1 = true;
					}
					er6 = false;
					}
				  } catch(NumberFormatException t){  
				    lblAgeError.setText("Age invalid");;  
				    er1 = true;
				  } 
				
				er6 = false;
				lblDOBError.setText("");
				if (p.isNegative()) {
					lblDOBError.setText("Birthdate cannot be in the future");
					er6 = true;
				}
				}else {
					er6 = true;
					lblDOBError.setText("A DOB is required");
				}
				
				if (er1 == false && er2 == false && er3 == false && er4 == false && er5 == false && er6 == false) {
					lblValid.setText("Valid");				}else {
						lblValid.setText("Invalid");
					}
				
			}
		});
		btnValidate.setBounds(128, 393, 89, 23);
		contentPane.add(btnValidate);
		
		
		
		
		
		
	}
}
