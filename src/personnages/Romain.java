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
		System.out.println(prendreParole() + "� " + texte + " �");
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
	
	private void ajouterEquipement(Equipement protection,Romain romain) {
		equipement[nbEquipement] = protection;
		nbEquipement += 1;
		System.out.println("le soldat " + nom + " s'équipe avec un " + protection);
	}
	
	public void sEquiper(Equipement protection,Romain romain) {
		switch(nbEquipement) {
		
			case 0:
				ajouterEquipement(protection,romain);
				break;
			
			case 1:
				if (equipement[0] == protection) {
					System.out.println("Le soldat " + nom + " possède déjà un " + protection);
				} else {
					ajouterEquipement(protection,romain);
				}
				break;
				
			case 2:
				System.out.println("le soldat " + nom + " est deja bien protege");
				break;
			
			default:
				System.out.println("Il y a un soucis là");
				break;
		}
	}
	
	public static void main(String[] args) {
		Romain malin = new Romain("Malin",6);
		malin.sEquiper(Equipement.CASQUE,malin);
		malin.sEquiper(Equipement.CASQUE,malin);
		malin.sEquiper(Equipement.BOUCLIER,malin);
		malin.sEquiper(Equipement.BOUCLIER,malin);
		}

}
