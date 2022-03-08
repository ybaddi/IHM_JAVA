package main.java.gui;

import main.java.dao.UserDaoImpl;
import main.java.models.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;

import java.util.List;

public class AdminFrame extends JFrame {
	public int selectedID;
	public JTable jt;

	public AdminFrame() {
		initFrame();
	}
	
	public AdminFrame(User simpletilisateur) {

		initFrame();
		
		}

	private void initFrame() {
		// TODO Auto-generated method stub
		setVisible(true);
		setSize(500, 500);
		setTitle("Inscription");
		getContentPane().setLayout(new BorderLayout());

		JPanel jpBuns = new JPanel(new GridLayout(3, 1));
		JButton btnAddUser = new JButton("Add User");
		JButton btnEditUser = new JButton("Edit User");
		JButton btnDeleteUser = new JButton("delete User");
		btnEditUser.setEnabled(false);
		btnDeleteUser.setEnabled(false);
		jpBuns.add(btnAddUser);
		jpBuns.add(btnEditUser);
		jpBuns.add(btnDeleteUser);
		btnAddUser.addActionListener((e) -> {
			InscriptionFrame inscriptionFrame = new InscriptionFrame();
		this.dispose()	;
		
		});
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
		
//		btnAddUser.setBounds(177, 212, 89, 23);
//		btnEditUser.setBounds(177, 212, 89, 23);
//		btnDeleteUser.setBounds(177, 212, 89, 23);

		getContentPane().add(jpBuns, BorderLayout.WEST);

		JPanel jpTable = new JPanel(new GridLayout());
		String data[][] = initDataTable();
		String columns[] = { "ID", "Nom", "Prenom", "Sexe", "Type" };
		jt = new JTable(data, columns);
		jt.setRowSelectionAllowed(true);
		
		ListSelectionModel selection = jt.getSelectionModel();
		selection.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		selection.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(jt.getValueAt(jt.getSelectedRows()[0],0));
				selectedID = Integer.valueOf((String)jt.getValueAt(jt.getSelectedRows()[0],0));
				btnEditUser.setEnabled(true);
				btnDeleteUser.setEnabled(true);
			}
			
		});
		
		jpTable.add(jt);
		getContentPane().add(jpTable, BorderLayout.CENTER);
		
		
        btnDeleteUser.addActionListener((e) -> {
        	System.out.println(selectedID);
			if(selectedID>0) {
				UserDaoImpl utilisateurDaoImpl = new UserDaoImpl();
				utilisateurDaoImpl.remove(selectedID);
				updateTable();
			}
		});
	
	}
	public void updateTable() {
		String data[][] = initDataTable();
		String columns[] = { "ID", "Nom", "Prenom", "Sexe", "Type" };
		jt = new JTable(data, columns);
		
	}
	private String[][] initDataTable() {
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		List<User> users = userDaoImpl.getAll();
		String data[][] = new String[users.size()][5];
		int i = 0;
		for (User user : users) {
			String sexe = user.getSexe() == 'h' ? "Homme" : "Femme";
			String type = user.getType() == 'a' ? "Admin" : "User";
			String items[] = new String[5];
			items[0] = String.valueOf(user.getId());

			items[1] = user.getNom();
			items[2] = user.getPrenom();
			items[3] = sexe;
			items[4] = type;
			data[i] = items;
			i++;
		}
		return data;
	}
}
