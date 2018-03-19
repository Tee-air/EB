package fr.englishbattle.pojos;

import java.util.ArrayList;
import java.util.List;

public class Partie {

    private Long id;
    private Long idJoueur;
	private Joueur joueur;
	private List<Question> questions = new ArrayList<>();
	
	/**
	 * @param joueur
	 */
	public Partie(Joueur joueur) {
		this.idJoueur = joueur.getId();
		this.joueur = joueur;
	}
	
	/**
	 * @return le id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id le id à définir
	 */
	public void setId(Long id) {
		this.id = id;
	}

	
	/**
	 * @return le idJoueur
	 */
	public Long getIdJoueur() {
		return idJoueur;
	}

	/**
	 * @param idJoueur le idJoueur à définir
	 */
	public void setIdJoueur(Long idJoueur) {
		this.idJoueur = idJoueur;
	}

	/**
	 * @return le joueur
	 */
	public Joueur getJoueur() {
		return joueur;
	}

	/**
	 * @param joueur le joueur à définir
	 */
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	/**
	 * @return le questions
	 */
	public List<Question> getQuestions() {
		return questions;
	}

	/**
	 * @param questions le questions à définir
	 */
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Partie [joueur=" + joueur + ", questions=" + questions + "]";
	}

}
