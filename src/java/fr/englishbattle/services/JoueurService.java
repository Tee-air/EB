package fr.englishbattle.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.englishbattle.pojos.Joueur;

public class JoueurService {

	private Connection connection;
	
	public JoueurService(Connection connection) {

		this.connection = connection;
	}

	public Joueur getJoueurFromId(Long id) throws SQLException {

		Joueur joueur = null;
		
		String query = "select * from joueur where id = ?";
		
		PreparedStatement psmt = connection.prepareStatement(query);
		
		psmt.setLong(1, id);
		
		ResultSet rs = psmt.executeQuery();
		
		if (rs.next()) {
			
			joueur = new Joueur(rs.getString("email"),
					rs.getString("nom"),
					rs.getString("prenom"),
					rs.getString("motDePasse"),
					rs.getLong("idVille"),
					rs.getString("niveau"));
			
			joueur.setId(rs.getLong(1));
		}		

		rs.close();
		psmt.close();
		
		return joueur;

	}

	public Joueur getJoueurFromEmailAndPassword(String email, String password) throws SQLException {

		Joueur joueur = null;	
		
		String query = "select * from joueur where email = ? and motDePasse = ?";
		
		PreparedStatement psmt = connection.prepareStatement(query);
		
		psmt.setString(1, email);
		psmt.setString(2, password);
		
		ResultSet rs = psmt.executeQuery();
		
		if (rs.next()) {
			
			joueur = new Joueur(rs.getString("email"),
					rs.getString("nom"),
					rs.getString("prenom"),
					rs.getString("motDePasse"),
					rs.getLong("idVille"),
					rs.getString("niveau"));
			
			joueur.setId(rs.getLong(1));
		}		

		rs.close();
		psmt.close();
		
		return joueur;

	}
	
	public Joueur createJoueur(Joueur joueur) throws SQLException {

		String query = "insert into joueur (email, nom, prenom, motDePasse, idVille, niveau) "
			+ " values (?, ?, ?, ?, ?, ?)";

		PreparedStatement psmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		
		psmt.setString(1, joueur.getEmail());
		psmt.setString(2, joueur.getNom());
		psmt.setString(3, joueur.getPrenom());
		psmt.setString(4, joueur.getMotDePasse());
		psmt.setLong(5, joueur.getIdVille());
		psmt.setString(6, joueur.getNiveau());
		
		psmt.executeUpdate();
		
		ResultSet rs = psmt.getGeneratedKeys();
		
		if (rs.first()) {
			joueur.setId(rs.getLong(1));			
		}
		
		rs.close();
		psmt.close();
		
		return joueur;
	}

}
