package main.java.gui;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import main.java.dao.UserDaoImpl;
import main.java.models.User;

import javax.swing.JComboBox;

public class InscriptionFrame extends JFrame {

	private JTextField nomText = new JTextField();
	private JTextField prenomText = new JTextField();
	private JTextField passwordText = new JTextField();
	private JComboBox sexeBox = new JComboBox();
	private JComboBox typeBox = new JComboBox();
	private JButton btnInscription = new JButton("Inscription");

	public InscriptionFrame() {
		// TODO Auto-generated constructor stub
		setVisible(true);
		setSize(500, 500);
		setTitle("Inscription");
		getContentPane().setLayout(null);

		// label nom
		JLabel lblNomUser = new JLabel("Your Name");
		lblNomUser.setBounds(25, 50, 100, 14);
		getContentPane().add(lblNomUser);

		// label nom
		JLabel lblPrenomUser = new JLabel("Your Prenom");
		lblPrenomUser.setBounds(25, 100, 100, 14);
		getContentPane().add(lblPrenomUser);

		// label password
		JLabel lblPassword = new JLabel("Your Password");
		lblPassword.setBounds(25, 150, 100, 14);
		getContentPane().add(lblPassword);

		// label sexe
		JLabel lblSexe = new JLabel("Your Sexe");
		lblSexe.setBounds(25, 200, 100, 14);
		getContentPane().add(lblSexe);
		
		// label type
				JLabel lblType = new JLabel("Your Type");
				lblType.setBounds(25, 250, 100, 14);
				getContentPane().add(lblType);


		// text nom
		nomText.setBounds(214, 50, 111, 20);
		getContentPane().add(nomText);

		// text prenom
		prenomText.setBounds(214, 100, 111, 20);
		getContentPane().add(prenomText);

		// text password
		passwordText.setBounds(214, 150, 111, 20);
		getContentPane().add(passwordText);
		
		// choice sexeBox
		sexeBox.setModel(new DefaultComboBoxModel(new String[] {"Homme", "Femme"}));
		sexeBox.setBounds(214, 200, 111, 20);
		getContentPane().add(sexeBox);
		
		// choice tyopeBoxe
		typeBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "User"}));
		typeBox.setBounds(214, 250, 111, 20);
		getContentPane().add(typeBox);

		// btnInscription
		btnInscription.setBounds(51, 300, 117, 23);
		getContentPane().add(btnInscription);
		btnInscription.addActionListener((e) -> {
			String nom = nomText.getText();
			String prenom = prenomText.getText();
			String password = passwordText.getText();
			char sexe = sexeBox.getSelectedIndex()==0?'h':'f';
			char type = typeBox.getSelectedIndex()==0?'a':'u';
			User user = new User(nom, prenom,password,sexe,type);
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			User addedUser = userDaoImpl.save(user);
			if(addedUser ==null) {
				JOptionPane.showMessageDialog(null, "isertion error");
			}else {
				JOptionPane.showMessageDialog(null, "isertion success");
				System.out.println(addedUser);
			}
		});

	}

}
