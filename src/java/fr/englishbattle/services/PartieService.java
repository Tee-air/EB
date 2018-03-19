package fr.englishbattle.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.englishbattle.pojos.Partie;

public class PartieService {

	private Connection connection;
	
	public PartieService(Connection connection) {

		this.connection = connection;
	}

	public Partie createPartie(Partie partie) throws SQLException {

		String query = "insert into partie (idJoueur) "
			+ " values (?)";

		PreparedStatement psmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		
		psmt.setLong(1, partie.getIdJoueur());
		
		psmt.executeUpdate();
		
		ResultSet rs = psmt.getGeneratedKeys();
		
		if (rs.first()) {
			partie.setId(rs.getLong(1));			
		}
		
		rs.close();
		psmt.close();
		
		return partie;
	}
}
