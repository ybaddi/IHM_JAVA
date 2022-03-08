package main.java.gui;

import javax.swing.*;

import main.java.dao.UserDaoImpl;
import main.java.gui.AdminFrame;
import main.java.gui.InscriptionFrame;
import main.java.gui.UserFrame;
import main.java.models.User;

import main.java.dao.UserDaoImpl;
import main.java.models.User;

import java.awt.event.*;
import java.util.List;

public class ConnexionFrame extends JFrame implements ActionListener{
	
	private JTextField nomText = new JTextField();
	private JTextField passwordText = new JTextField();
//	private JButton btnInscription = new JButton("Inscription");
	public JButton btnConnextion = new JButton("Connection");
	public int nbrConnexion;
	
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
//		btnInscription.setBounds(51, 183, 117, 23);
//		getContentPane().add(btnInscription);
//		btnInscription.addActionListener(this);
				
		// text nom
		btnConnextion.setBounds(214, 183, 111, 23);
		getContentPane().add(btnConnextion);
		btnConnextion.addActionListener(this);
		
		
				
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		nbrConnexion=0;
		if (ae.getSource() == this.btnConnextion) {
			nbrConnexion++;
			String nom = nomText.getText();
			String password = passwordText.getText();
			UserDaoImpl utilisateurDaoImpl = new UserDaoImpl();
			User utilisateur = utilisateurDaoImpl.findByNomAndPassword(nom, password);
			System.out.println(nbrConnexion);
			if (utilisateur == null) {
				if (nbrConnexion == 3) {
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Identifiant(s) incorrect(s)");
				}
			} else {
				if (utilisateur.getType() == 'a' ) {
					System.out.println("vous êtes administrateur");
					new AdminFrame(utilisateur);
				} else {
					System.out.println("vous êtes simple");
					new UserFrame(utilisateur);
				}
				this.dispose();
			}
		} else {
			InscriptionFrame inscriptionFrame = new InscriptionFrame();
			this.dispose();
		}
	}

}
