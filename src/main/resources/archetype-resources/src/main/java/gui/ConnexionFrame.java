package main.java.gui;

import javax.swing.*;

import main.java.dao.UserDaoImpl;
import main.java.models.User;

import java.awt.event.*;
import java.util.List;

public class ConnexionFrame extends JFrame implements ActionListener{
	
	private JTextField nomText = new JTextField();
	private JTextField passwordText = new JTextField();
	private JButton btnInscription = new JButton("Inscription");
	private JButton btnConnextion = new JButton("Connection");
	
	public ConnexionFrame() {
		setSize(500,500);
		setTitle("connextion Frame");
		getContentPane().setLayout(null);
		
		// label nom
		JLabel lblNomUser = new JLabel("Your Name");
		lblNomUser.setBounds(51, 74, 117, 14);
		getContentPane().add(lblNomUser);
		
		// label password
		JLabel lblPassword = new JLabel("Your Password");
		lblPassword.setBounds(51, 120, 103, 14);
		getContentPane().add(lblPassword);
		
		
		// text nom
		nomText.setBounds(214, 71, 111, 20);
		getContentPane().add(nomText);
		
		// text nom
		passwordText.setBounds(214, 117, 111, 20);
		getContentPane().add(passwordText);
		
		
		// btnInscription
		btnInscription.setBounds(51, 183, 117, 23);
		getContentPane().add(btnInscription);
		btnInscription.addActionListener(this);
				
		// text nom
		btnConnextion.setBounds(214, 183, 111, 23);
		getContentPane().add(btnConnextion);
		btnConnextion.addActionListener(this);
		
		
				
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnConnextion) {
			System.out.println("conecction");
			String nom = nomText.getText();
			String password = passwordText.getText();
			System.out.println(nom);
			System.out.println(password);
			UserDaoImpl userDaoImpl = new UserDaoImpl();
	        User user = userDaoImpl.findByNomAndPassword(nom,password);
	        System.out.println(user);
	        if(user == null) {
	        	JOptionPane.showMessageDialog(null, "No user with thios cridentiels");
	        }
		}else{
			System.out.println("inscription");
			InscriptionFrame inscriptionFrame = new InscriptionFrame();
			this.dispose();
			
		}
		
	}

}
