package fr.englishbattle.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import fr.englishbattle.pojos.Question;

public class QuestionService {

	private Connection connection;
	
	public QuestionService(Connection connection) {

		this.connection = connection;
	}

	public Question createQuestion(Question question) throws SQLException {

		String query = "insert into question (idPartie, idVerbe, reponsePreterit,"
				+ " reponseParticipePasse, dateEnvoi, dateReponse) "
				+ " values (?, ?, ?, ?, ?, ?)";

		PreparedStatement psmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		
		psmt.setLong(1, question.getIdPartie());
		psmt.setLong(2, question.getIdVerbe());
		psmt.setString(3, question.getReponsePreterit());
		psmt.setString(4, question.getReponseParticipePasse());
		psmt.setTimestamp(5, new Timestamp(question.getDateEnvoi().getTime()));
		psmt.setTimestamp(6, new Timestamp(question.getDateReponse().getTime()));
		
		psmt.executeUpdate();
		
		ResultSet rs = psmt.getGeneratedKeys();
		
		if (rs.first()) {
			question.setId(rs.getLong(1));			
		}
		
		rs.close();
		psmt.close();
		
		return question;
	}
}
