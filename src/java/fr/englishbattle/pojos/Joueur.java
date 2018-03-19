package fr.englishbattle.pojos;

public class Joueur {

    private Long id;
	private String email;
	private String nom;
	private String prenom;
	private String motDePasse;
	private Long idVille;
	private Ville ville;
	private String niveau;
	
	/**
	 * @param email
	 * @param nom
	 * @param prenom
	 * @param motDePasse
	 * @param idVille
	 * @param niveau
	 */
	public Joueur(String email, String nom, String prenom, String motDePasse, Long idVille, String niveau) {
		this.email = email;
		this.nom = nom;
		this.prenom = prenom;
		this.motDePasse = motDePasse;
		this.idVille = idVille;
		this.niveau = niveau;
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
	 * @return le email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email le email à définir
	 */
	public void setEmail(String email) {
		this.email = email;
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

	/**
	 * @return le prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom le prenom à définir
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return le motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * @param motDePasse le motDePasse à définir
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	
	/**
	 * @return le idVille
	 */
	public Long getIdVille() {
		return idVille;
	}

	/**
	 * @param idVille le idVille à définir
	 */
	public void setIdVille(Long idVille) {
		this.idVille = idVille;
	}

	/**
	 * @return le ville
	 */
	public Ville getVille() {
		return ville;
	}

	/**
	 * @param ville le ville à définir
	 */
	public void setVille(Ville ville) {
		this.ville = ville;
	}

	/**
	 * @return le niveau
	 */
	public String getNiveau() {
		return niveau;
	}

	/**
	 * @param niveau le niveau à définir
	 */
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	@Override
	public String toString() {
		return "Joueur [email=" + email + ", nom=" + nom + ", prenom=" + prenom + ", motDePasse=" + motDePasse + "]";
	}
}
