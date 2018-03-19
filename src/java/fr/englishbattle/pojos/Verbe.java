package fr.englishbattle.pojos;

public class Verbe {

	private Long id;
	private String baseVerbale;
	private String preterit;
	private String participePasse;
	private String traduction;
	
	/**
	 * @param baseVerbale
	 * @param preterit
	 * @param participePasse
	 * @param traduction
	 */
	public Verbe(String baseVerbale, String preterit, String participePasse, String traduction) {
		this.baseVerbale = baseVerbale;
		this.preterit = preterit;
		this.participePasse = participePasse;
		this.traduction = traduction;
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
	 * @return le baseVerbale
	 */
	public String getBaseVerbale() {
		return baseVerbale;
	}

	/**
	 * @param baseVerbale le baseVerbale à définir
	 */
	public void setBaseVerbale(String baseVerbale) {
		this.baseVerbale = baseVerbale;
	}

	/**
	 * @return le preterit
	 */
	public String getPreterit() {
		return preterit;
	}

	/**
	 * @param preterit le preterit à définir
	 */
	public void setPreterit(String preterit) {
		this.preterit = preterit;
	}

	/**
	 * @return le participePasse
	 */
	public String getParticipePasse() {
		return participePasse;
	}

	/**
	 * @param participePasse le participePasse à définir
	 */
	public void setParticipePasse(String participePasse) {
		this.participePasse = participePasse;
	}

	/**
	 * @return le traduction
	 */
	public String getTraduction() {
		return traduction;
	}

	/**
	 * @param traduction le traduction à définir
	 */
	public void setTraduction(String traduction) {
		this.traduction = traduction;
	}

	@Override
	public String toString() {
		return "Verbe [baseVerbale=" + baseVerbale + ", preterit=" + preterit + ", participePasse=" + participePasse
				+ ", traduction=" + traduction + "]";
	}
}
