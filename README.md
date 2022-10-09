# LesGaulois
TP
package personnage;

import java.util.Set;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois;
	
	public Village (int nbVillageoisMaximum) {
		villageois = new Gaulois[nbVillageoisMaximum];
		this.nbVillageois = 0;
	}
	
	public String getNom() {
		return nom;
	}
	
	public Village(String nom) {
		this.nom = nom;
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(String gauloisAAjouter, Gaulois[] villageois) {
		if (nbVillageois < Gaulois.lenght()) {
			villageois[nbVillageois] = gauloisAAjouter;
			nbVillageois += 1; 
		}
	}
	
	
}


package personnage;

import java.util.Set;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;


	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;	
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de "+ romain.getNom());romain.recevoirCoup(force / 3);
	}
	
	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force
				+ ", effetPotion=" + effetPotion + "]";
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		asterix.parler("bonjour");
		Romain malin = new Romain("Malin",2);
		asterix.frapper(malin);
	}
}


package personnage;
package personnage;

import java.util.Set;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	
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
}

import java.util.Set;

public class Chef {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village;
	
	public Chef(String nom, int force, int effetPotion, Village village) {
		this.nom = nom;
		this.force = force;
		this.effetPotion = effetPotion;
		this.village = village;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le chef " + nom + " du village " + village.getNom() + " : ";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup(force / 3);
	}
}

package histoire;

import personnage.Gaulois;
import personnage.Romain;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain minus = new Romain("Minus",6);
		asterix.parler("Bonjour à tous");
		minus.parler("UN GAU... UN GAUGAU..");
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);

	}

}

package personnage;

import java.util.Set;

public class Romain {
	private String nom;
	private int force;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
	}
}
