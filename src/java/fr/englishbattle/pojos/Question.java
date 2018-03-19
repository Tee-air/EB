package fr.englishbattle.pojos;

import java.util.Date;

public class Question {

    private Long id;
    private Long idPartie;
	private Partie partie;
	private Long idVerbe;
	private Verbe verbe;
	private String reponsePreterit;
	private String reponseParticipePasse;
	private Date dateEnvoi;
	private Date dateReponse;
	
	/**
	 * @param partie
	 * @param verbe
	 */
	public Question(Partie partie, Verbe verbe) {
		this.idPartie = partie.getId();
		this.partie = partie;
		this.idVerbe = verbe.getId();
		this.verbe = verbe;
		this.dateEnvoi = new Date();
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
	 * @return le idPartie
	 */
	public Long getIdPartie() {
		return idPartie;
	}

	/**
	 * @param idPartie le idPartie à définir
	 */
	public void setIdPartie(Long idPartie) {
		this.idPartie = idPartie;
	}

	/**
	 * @return le partie
	 */
	public Partie getPartie() {
		return partie;
	}

	/**
	 * @param partie le partie à définir
	 */
	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	
	/**
	 * @return le idVerbe
	 */
	public Long getIdVerbe() {
		return idVerbe;
	}

	/**
	 * @param idVerbe le idVerbe à définir
	 */
	public void setIdVerbe(Long idVerbe) {
		this.idVerbe = idVerbe;
	}

	/**
	 * @return le verbe
	 */
	public Verbe getVerbe() {
		return verbe;
	}

	/**
	 * @param verbe le verbe à définir
	 */
	public void setVerbe(Verbe verbe) {
		this.verbe = verbe;
	}

	/**
	 * @return le reponsePreterit
	 */
	public String getReponsePreterit() {
		return reponsePreterit;
	}

	/**
	 * @param reponsePreterit le reponsePreterit à définir
	 */
	public void setReponsePreterit(String reponsePreterit) {
		this.reponsePreterit = reponsePreterit;
	}

	/**
	 * @return le reponseParticipePasse
	 */
	public String getReponseParticipePasse() {
		return reponseParticipePasse;
	}

	/**
	 * @param reponseParticipePasse le reponseParticipePasse à définir
	 */
	public void setReponseParticipePasse(String reponseParticipePasse) {
		this.reponseParticipePasse = reponseParticipePasse;
	}

	/**
	 * @return le dateEnvoi
	 */
	public Date getDateEnvoi() {
		return dateEnvoi;
	}

	/**
	 * @param dateEnvoi le dateEnvoi à définir
	 */
	public void setDateEnvoi(Date dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}

	/**
	 * @return le dateReponse
	 */
	public Date getDateReponse() {
		return dateReponse;
	}

	/**
	 * @param dateReponse le dateReponse à définir
	 */
	public void setDateReponse(Date dateReponse) {
		this.dateReponse = dateReponse;
	}

	@Override
	public String toString() {
		return "Question [verbe=" + verbe + ", reponsePreterit=" + reponsePreterit
				+ ", reponseParticipePasse=" + reponseParticipePasse + ", dateEnvoi=" + dateEnvoi + ", dateReponse="
				+ dateReponse + "]";
	}

}
