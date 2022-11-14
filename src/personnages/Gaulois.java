package personnages;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees;
	private Equipement [] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;	
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "Â« " + texte + "Â»");
	}

	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
		}

	public void boirePotion(int forcePotion) {
		force += forcePotion;
		System.out.println("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée");
		
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement [] equipements = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; equipements != null && i < equipements.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = equipements[i];
		}
	}


	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("AstÃ©rix", 8);
		asterix.parler("bonjour");
		Romain malin = new Romain("Malin",2);
		asterix.frapper(malin);
	}
}
