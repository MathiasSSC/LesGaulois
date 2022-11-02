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
	
	public void afficherVillageois(Chef chef) {
		System.out.println("Dans le village du chef " + chef 
				+ " vivent les l�gendaires gaulois :\n") ;
		for(int i=0; i<nbVillageois ; i++) {
			System.out.println("-" + villageois[i] +"\n") ;
				}
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irreductibles", 30);
		Gaulois abraracourcix = new Gaulois("Abraracourcix",6);
		village.ajouterHabitant(abraracourcix);
		Chef ChefAbraracourcix = new Chef("Abraracourcix",6,1,village);
		Gaulois asterix = new Gaulois("Asterix",8);
		village.ajouterHabitant(asterix);
		Gaulois obelix = new Gaulois("Oblelix",25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois(ChefAbraracourcix);
		
	}

}
