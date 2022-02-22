package main.java.models;

public class User {
	
	private int id;
	private String nom;
	private String prenom;
	private String password;	
	private char sexe;
	private char type;
	public User(String nom, String prenom, String password, char sexe, char type) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.sexe = sexe;
		this.type = type;
	}
	public User() {
		super();
	}
	public User(int id, String nom, String prenom, String password, char sexe, char type) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.sexe = sexe;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public char getSexe() {
		return sexe;
	}
	public void setSexe(char sexe) {
		this.sexe = sexe;
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password + ", sexe=" + sexe
				+ ", type=" + type + "]";
	}
	
	
	
		
		

}
