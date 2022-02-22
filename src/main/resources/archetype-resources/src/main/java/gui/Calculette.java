package main.java.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Calculette extends JFrame {
	JTextField text = new JTextField();
	JButton but1 = new JButton("1");
	JButton but2 = new JButton("2");
	JButton but3 = new JButton("3");
	JButton but4 = new JButton("4");
	JButton but5 = new JButton("5");
	JButton but6 = new JButton("6");
	JButton but7 = new JButton("7");
	JButton but8 = new JButton("8");
	JButton but9 = new JButton("9");
	JButton but0 = new JButton("0");
	JButton plus = new JButton("+");
	JButton moins = new JButton("-");
	JButton fois = new JButton("*");
	JButton div = new JButton("/");
	JButton point = new JButton(",");
	JButton clean = new JButton("C");
	JButton equal = new JButton("=");
	
	double operand1;
	double operand2;
	char operation;
	boolean deleteAfter=false;
	
	public Calculette(){
		this.afficherCalculette();
		this.associateListners();
	}

	private void associateListners() {
		// TODO Auto-generated method stub
		but1.addActionListener((e) ->{
			if(deleteAfter) {
				text.setText("");
				deleteAfter=false;
			}
			text.setText(text.getText()+"1");
		});
        but2.addActionListener((e) ->{
        	if(deleteAfter) {
				text.setText("");
				deleteAfter=false;
			}
        	text.setText(text.getText()+"2");
		});
		but3.addActionListener((e) ->{
			if(deleteAfter) {
				text.setText("");
				deleteAfter=false;
			}
			text.setText(text.getText()+"3");
		});
		but4.addActionListener((e) ->{
			if(deleteAfter) {
				text.setText("");
				deleteAfter=false;
			}
			text.setText(text.getText()+"4");
		});
		but5.addActionListener((e) ->{
			if(deleteAfter) {
				text.setText("");
				deleteAfter=false;
			}
			text.setText(text.getText()+"5");
		});
		but6.addActionListener((e) ->{
			if(deleteAfter) {
				text.setText("");
				deleteAfter=false;
			}
			text.setText(text.getText()+"6");
		});
		but7.addActionListener((e) ->{
			if(deleteAfter) {
				text.setText("");
				deleteAfter=false;
			}
			text.setText(text.getText()+"7");
		});
		but8.addActionListener((e) ->{
			if(deleteAfter) {
				text.setText("");
				deleteAfter=false;
			}
			text.setText(text.getText()+"8");
		});
		but9.addActionListener((e) ->{
			if(deleteAfter) {
				text.setText("");
				deleteAfter=false;
			}
			text.setText(text.getText()+"9");
		});
		but0.addActionListener((e) ->{
			String currentText = text.getText();
			if(currentText.isEmpty()) text.setText("");
			else text.setText(text.getText()+"0");
		});
		plus.addActionListener((e) ->{
			operation='+';
			operand1=Double.valueOf(text.getText());
			System.out.println(operand1);
			text.setText("");
		});
		moins.addActionListener((e) ->{
			operation='-';
			operand1=Double.valueOf(text.getText());
			System.out.println(operand1);
			text.setText("");
		});
		fois.addActionListener((e) ->{
			operation='*';
			operand1=Double.valueOf(text.getText());
			System.out.println(operand1);
			text.setText("");
		});
		div.addActionListener((e) ->{
			operation='/';
			operand1=Double.valueOf(text.getText());
			System.out.println(operand1);
			text.setText("");
		});
		point.addActionListener((e) ->{
			String currentText = text.getText();
			if(currentText.isEmpty()) text.setText("0.");
			else if(currentText.toCharArray()[currentText.length()-1] == '.' || currentText.contains(".") ) {}
			else text.setText(text.getText()+".");
		});
		clean.addActionListener((e) ->{
			text.setText("");
		});
		equal.addActionListener((e) ->{
			deleteAfter=true;
			operand2=Double.valueOf(text.getText());
			System.out.println(operand2);
			switch(operation) {
				case '+' : {text.setText(String.valueOf(operand1+operand2)); break;}
				case '-' : {text.setText(String.valueOf(operand1-operand2)); break;}
				case '*' : {text.setText(String.valueOf(operand1*operand2)); break;}
				case '/' : {text.setText(String.valueOf(operand1/operand2)); break;}
				
			}
		});
		
	}

	public void afficherCalculette() {
		text.setBounds(20, 20, 230, 50);
		but1.setBounds(20, 80, 50, 50);
		but2.setBounds(80, 80, 50, 50);
		but3.setBounds(140, 80, 50, 50);
		div.setBounds(200, 80, 50, 50);
		but4.setBounds(20, 140, 50, 50);
		but5.setBounds(80, 140, 50, 50);
		but6.setBounds(140, 140, 50, 50);
		plus.setBounds(200, 140, 50, 50);
		but7.setBounds(20, 200, 50, 50);
		but8.setBounds(80, 200, 50, 50);
		but9.setBounds(140, 200, 50, 50);
		moins.setBounds(200, 200, 50, 50);
		clean.setBounds(20, 260, 50, 50);
		but0.setBounds(80, 260, 50, 50);
		point.setBounds(140, 260, 50, 50);
		fois.setBounds(200, 260, 50, 50);
		equal.setBounds(20, 320, 230, 50);
		this.add(but1);
		this.add(but2);
		this.add(but3);
		this.add(but4);
		this.add(but5);
		this.add(but6);
		this.add(but7);
		this.add(but8);
		this.add(but9);
		this.add(but0);
		this.add(clean);
		this.add(plus);
		this.add(moins);
		this.add(fois);
		this.add(div);
		this.add(text);
		this.add(point);
		this.add(equal);

		this.setSize(290, 460);
		this.setTitle("Calculatrice");
		this.setLayout(null);
		this.setVisible(true);
	}
}
