package personnages;

public class Village {
	
	private String nom; 
	private Chef chef; 
	private Gaulois[] villageois; 
	private int nbVillageois = 0;
	
	public Village (String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois += 1; 
		}
	}

	public Gaulois trouverHabitant(int numeroVillageois) {
		if (numeroVillageois <= nbVillageois) {
			return villageois[numeroVillageois];
		}
		return null;
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
		Gaulois abraracourcix = new Gaulois("Abraracourcix",6);
		village.ajouterHabitant(abraracourcix);
		Chef chefAbraracourcix = new Chef("Abraracourcix",6,1,village);
		Gaulois asterix = new Gaulois("Astérix",8);
		village.ajouterHabitant(asterix);
		Gaulois gauloisRecherche = village.trouverHabitant(1);
		System.out.println(gauloisRecherche);
	}

}
