package main.java.gui;

import main.java.dao.UserDaoImpl;
import main.java.models.User;

import javax.swing.*;
import java.awt.*;

public class AdminFrame extends JFrame{


	public AdminFrame(User simpletilisateur) {

		setVisible(true);
		setSize(500, 500);
		setTitle("Inscription");
		getContentPane().setLayout(new BorderLayout());

		JPanel jpBuns = new JPanel(new GridLayout(3,1));
		JButton btnAddUser = new JButton("Add User");
		JButton btnEditUser = new JButton("Edit User");
		JButton btnDeleteUser = new JButton("delete User");
		jpBuns.add(btnAddUser);
		jpBuns.add(btnEditUser);
		jpBuns.add(btnDeleteUser);
//		btnAddUser.addActionListener((e) -> {
//			String nom = nomText.getText();
//			String prenom = prenomText.getText();
//			char sexe = sexeBox.getSelectedIndex() == 0 ? 'h' : 'f';
//			UtilisateurDaoImpl utilisateurDaoImpl = new UtilisateurDaoImpl();
//			Utilisateur utilisateur = new Utilisateur(nom, prenom,sexe,'s');
//			System.out.println(utilisateur);
//			Utilisateur insertedUtilisateur = utilisateurDaoImpl.save(utilisateur);
//			if(insertedUtilisateur == null) {
//				JOptionPane.showMessageDialog(null, "problème de création de compte");
//			}
//			else {
//				JOptionPane.showMessageDialog(null, "Votre compte a été créé avec succès");
//			}
//		});
//		btnEditUser.addActionListener((e) -> {
//			String nom = nomText.getText();
//			String prenom = prenomText.getText();
//			char sexe = sexeBox.getSelectedIndex() == 0 ? 'h' : 'f';
//			UtilisateurDaoImpl utilisateurDaoImpl = new UtilisateurDaoImpl();
//			Utilisateur utilisateur = new Utilisateur(nom, prenom,sexe,'s');
//			System.out.println(utilisateur);
//			Utilisateur insertedUtilisateur = utilisateurDaoImpl.save(utilisateur);
//			if(insertedUtilisateur == null) {
//				JOptionPane.showMessageDialog(null, "problème de création de compte");
//			}
//			else {
//				JOptionPane.showMessageDialog(null, "Votre compte a été créé avec succès");
//			}
//		});
//		btnDeleteUser.addActionListener((e) -> {
//			String nom = nomText.getText();
//			String prenom = prenomText.getText();
//			char sexe = sexeBox.getSelectedIndex() == 0 ? 'h' : 'f';
//			UtilisateurDaoImpl utilisateurDaoImpl = new UtilisateurDaoImpl();
//			Utilisateur utilisateur = new Utilisateur(nom, prenom,sexe,'s');
//			System.out.println(utilisateur);
//			Utilisateur insertedUtilisateur = utilisateurDaoImpl.save(utilisateur);
//			if(insertedUtilisateur == null) {
//				JOptionPane.showMessageDialog(null, "problème de création de compte");
//			}
//			else {
//				JOptionPane.showMessageDialog(null, "Votre compte a été créé avec succès");
//			}
//		});
//		btnAddUser.setBounds(177, 212, 89, 23);
//		btnEditUser.setBounds(177, 212, 89, 23);
//		btnDeleteUser.setBounds(177, 212, 89, 23);

		getContentPane().add(jpBuns, BorderLayout.WEST);

		JPanel jpTable = new JPanel(new GridLayout());
		String data[][] = {{"ID", "Nom", "Prenom", "Sexe", "Type"}};
		String columns [] = {"ID", "Nom", "Prenom", "Sexe", "Type"};
		JTable jt = new JTable(data,columns);
		jpTable.add(jt);
		getContentPane().add(jpTable, BorderLayout.CENTER);
	}
}
