package personnages;

public class Romain {
	
	private String nom; 
	private int force;
	private Equipement[] equipement;
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		equipement = new Equipement[2];
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + " »");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert force > 0;
		int nouvelleForce = force-forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		assert nouvelleForce < force; 
	}
	
	public String sEquiper(Equipement protection,Romain romain) {
		if (nbEquipement >= equipement.length) {
			return "le soldat " + romain + " est deja bien protege";
		}
		if (nbEquipement == 0) {
			equipement[nbEquipement] = protection;
			nbEquipement += 1;
			return "le soldat " + romain + " s'equipe avec " + protection;
		}
		else {
			if (protection == equipement[nbEquipement-1]) {
				return "le soldat " + romain + " possede deja un " + protection;
			}
			else {
				return "le soldat " + romain + " s'equipe avec un " + protection;
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		Romain malin = new Romain("Malin",6);
		malin.recevoirCoup(2);
		malin.sEquiper
		}

}
