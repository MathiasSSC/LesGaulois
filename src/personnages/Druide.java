package personnages;
import java.util.*;


public class Druide {
	
	private String nom; 
	private int effetPotionMin; 
	private int effetPotionMax;
	private int forcePotion = 1;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
		}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public void preparerPotion(int effetPotionMax, int effetPotionMin) {
		Random ran = new Random();
		forcePotion = ran.nextInt(effetPotionMax);
		if(forcePotion > 7) {
			parler("J'ai préparé une super potion de force" 
					+ forcePotion);
		}
		else if(forcePotion >= effetPotionMin){
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " 
					+ forcePotion);
		}
		else {
			preparerPotion(effetPotionMax,effetPotionMin);
		}
	}
	
	public static void main(String[] args) {
		Druide panoramix = new Druide ("Panoramix",5,10);
		panoramix.preparerPotion(10,5);
	}

}
