package fr.englishbattle.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.englishbattle.pojos.Ville;

public class VilleService {

	private Connection connection;
	
	public VilleService(Connection connection) {

		this.connection = connection;
	}
	
	public Ville getVilleFromId(Long id) throws SQLException {
		
		Ville ville = null;	
		
		String query = "select * from ville where id = ?";
		
		PreparedStatement psmt = connection.prepareStatement(query);
		
		psmt.setLong(1, id);
		
		ResultSet rs = psmt.executeQuery();
		
		if (rs.next()) {
			
			ville = new Ville(rs.getString("cp"),
					rs.getString("nom"));
			
			ville.setId(rs.getLong(1));
		}		

		rs.close();
		psmt.close();
		
		return ville;
		
	}
	
	public List<Ville> getAll() throws SQLException {
		
		List<Ville> villes = new ArrayList<Ville>();
		
		Statement statement = connection.createStatement();
		
		String query = "select * from ville LIMIT 10";
		
		ResultSet rs = statement.executeQuery(query);
		
		while(rs.next()) {
			
			Ville ville = new Ville(rs.getString("cp"),
					rs.getString("nom"));
							
			ville.setId(rs.getLong(1));						
			
			villes.add(ville);
		}
		
		return villes;
	}
}
