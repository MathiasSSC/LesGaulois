package personnages;

public class Romain {
	
	private String nom; 
	private int force;
	private Equipement[] equipement;
	private int nbEquipement = 0;
	private String texte;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		equipement = new Equipement[2];
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "ï¿½ " + texte + " ï¿½");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		assert force > 0;
//		int nouvelleForce = force-forceCoup;
//		if (force > 0) {
//			parler("Aie");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert nouvelleForce < force; 
//	}
	
	private void ajouterEquipement(Equipement protection,Romain romain) {
		equipement[nbEquipement] = protection;
		nbEquipement += 1;
		System.out.println("le soldat " + nom + " s'Ã©quipe avec un " + protection);
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			equipementEjecte = ejecterEquipement();
//			parler("J'abandonne...");
		// }
		switch (force) {
		case 0:
			parler("Aïe");
			
		default:
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			break;
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;
	}

	
	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) == true) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
				i++;
			}
			texte =+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
	
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + " s'envole sous la force du coup.");
		//TODO
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				continue;
			} else {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
		}
		

	
	public void sEquiper(Equipement protection,Romain romain) {
		switch(nbEquipement) {
		
			case 0:
				ajouterEquipement(protection,romain);
				break;
			
			case 1:
				if (equipement[0] == protection) {
					System.out.println("Le soldat " + nom + " possÃ¨de dÃ©jÃ  un " + protection);
				} else {
					ajouterEquipement(protection,romain);
				}
				break;
				
			case 2:
				System.out.println("le soldat " + nom + " est deja bien protege");
				break;
			
			default:
				System.out.println("Il y a un soucis lÃ ");
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
