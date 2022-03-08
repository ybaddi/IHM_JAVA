package main.java.dao;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;


import main.java.config.MyConnection;
import main.java.models.User;

public class UserDaoImpl implements Dao<User> {

	public User save(User user) {
		// TODO Auto-generated method stub
		Connection c = MyConnection.getConnexion();
		if(c!=null) {
			try {
			PreparedStatement st = 
					c.prepareStatement("Insert into users "
							+ "(nom,prenom,password,sexe,type) "
							+ "values(?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS);
			st.setString(1, user.getNom());
			st.setString(2, user.getPrenom());
			st.setString(3, user.getPassword());
			st.setString(4, String.valueOf(user.getSexe()));
			st.setString(5, String.valueOf(user.getType()));
			st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
			if(rs.next()) {
				user.setId(rs.getInt(1)); 
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	public void remove(User user) {
		// TODO Auto-generated method stub
		
	}
	
	public void remove(int userID) {
		// TODO Auto-generated method stub
		Connection c = MyConnection.getConnexion();
		if(c!=null) {
			try {
			PreparedStatement st = 
					c.prepareStatement("delete from users "
							+ "where id=?",
							PreparedStatement.RETURN_GENERATED_KEYS);
			st.setInt(1, userID);
			st.executeUpdate();
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return;
		
	}

	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public User findByNomAndPassword(String nom, String password) {
		// TODO Auto-generated method stub
		Connection c = MyConnection.getConnexion();
		User user = null;
		if(c!=null) {
			try {
			PreparedStatement st = c.prepareStatement("Select * from users where nom = ? And password =?");
			st.setString(1, nom);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				user = new User(rs.getInt("id"),rs.getString("nom"), 
						rs.getString("prenom"), rs.getString("password"),rs.getString("sexe").charAt(0),
						rs.getString("type").charAt(0));
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	public List<User> getAll() {
		// TODO Auto-generated method stub
		Connection c = MyConnection.getConnexion();
		List<User> users = null;
		if(c!=null) {
			try {
			users = new ArrayList<User>();
			PreparedStatement st = c.prepareStatement("Select * from users");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				users.add(new User(rs.getInt("id"),rs.getString("nom"), 
						rs.getString("prenom"), rs.getString("password"),rs.getString("sexe").charAt(0),
						rs.getString("type").charAt(0)));
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}

}
