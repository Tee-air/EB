package fr.englishbattle.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.englishbattle.pojos.Verbe;

public class VerbeService {

	private Connection connection;
	
	public VerbeService(Connection connection) {

		this.connection = connection;
	}

	public Verbe getVerbeFromId(Long id) throws SQLException {
		
		Verbe verbe = null;	
		
		String query = "select * from verbe where id = ?";
		
		PreparedStatement psmt = connection.prepareStatement(query);
		
		psmt.setLong(1, id);
		
		ResultSet rs = psmt.executeQuery();
		
		if (rs.next()) {
			
			verbe = new Verbe(rs.getString("baseVerbale"),
					rs.getString("preterit"),
					rs.getString("participePasse"),
					rs.getString("traduction"));
			
			verbe.setId(rs.getLong(1));
		}		

		rs.close();
		psmt.close();
		
		return verbe;
		
	}
	
	public List<Verbe> getAll() throws SQLException {
		
		List<Verbe> verbes = new ArrayList<Verbe>();
		
		Statement statement = connection.createStatement();
		
		String query = "select * from verbe";
		
		ResultSet rs = statement.executeQuery(query);
		
		while(rs.next()) {
			
			Verbe verbe = new Verbe(rs.getString("baseVerbale"),
					rs.getString("preterit"),
					rs.getString("participePasse"),
					rs.getString("traduction"));
			
			verbe.setId(rs.getLong(1));					
			
			verbes.add(verbe);
		}
		
		return verbes;
	}

}
