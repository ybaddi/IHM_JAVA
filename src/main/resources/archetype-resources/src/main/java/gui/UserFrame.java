package main.java.gui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import main.java.dao.UserDaoImpl;
import main.java.models.User;

public class UserFrame extends JFrame{
	private JLabel lblNom = new JLabel("Nom");
	private JLabel lblPrnom = new JLabel("Prénom");
	private JTextField nomText = new JTextField();
	private JTextField prenomText = new JTextField();
	JComboBox sexeBox = new JComboBox();
	
	public UserFrame(User user) {
		nomText.setText(user.getNom());
		prenomText.setText(user.getPrenom());
		sexeBox.setModel(new DefaultComboBoxModel(new String[] {"Homme", "Femme"}));

		sexeBox.setSelectedItem(user.getSexe() == 'h' ? "Homme" : "Femme");
		setVisible(true);
		setSize(500, 500);
		setTitle("Inscription");
		getContentPane().setLayout(null);
		
		lblNom.setBounds(25, 50, 100, 14);
		getContentPane().add(lblNom);
		
		lblPrnom.setBounds(25, 103, 100, 14);
		getContentPane().add(lblPrnom);
		
		JLabel lblSexe = new JLabel("Sexe");
		lblSexe.setBounds(25, 160, 100, 14);
		getContentPane().add(lblSexe);
		
		nomText.setBounds(177, 47, 86, 20);
		getContentPane().add(nomText);
		
		prenomText.setBounds(177, 100, 86, 20);
		getContentPane().add(prenomText);
		
		sexeBox.setBounds(177, 157, 86, 20);
		getContentPane().add(sexeBox);
		
		JButton btnInscription = new JButton("Inscription");
		btnInscription.addActionListener((e) -> {
			String nom = nomText.getText();
			String prenom = prenomText.getText();
			char sexe = sexeBox.getSelectedIndex() == 0 ? 'h' : 'f';
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			User user_1 = new User(nom, prenom,"password",sexe,'u');
			System.out.println(user_1);
			User insertedUser = userDaoImpl.save(user_1);
			if(insertedUser == null) {
				JOptionPane.showMessageDialog(null, "problème de création de compte");
			}
			else {
				JOptionPane.showMessageDialog(null, "Votre compte a été créé avec succès");
			}
		});
		btnInscription.setBounds(177, 212, 89, 23);
		getContentPane().add(btnInscription);
	}
}
