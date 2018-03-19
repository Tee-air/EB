package fr.englishbattle.pojos;

public class Ville {
	
	private Long id;
	private String cp;
	private String nom;
	
	/**
	 * @param cp
	 * @param nom
	 */
	public Ville(String cp, String nom) {
		this.cp = cp;
		this.nom = nom;
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
	 * @return le cp
	 */
	public String getCp() {
		return cp;
	}
	
	/**
	 * @param cp le cp à définir
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}
	
	/**
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * @param nom le nom à définir
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
