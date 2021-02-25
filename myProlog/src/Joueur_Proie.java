import java.awt.Point;
import java.util.ArrayList;


public class Joueur_Proie implements Player {
	
	ArrayList<Point> coup;

	Interface_graphique interface_graphique;
	ArrayList<Point> coup_total;

	public Joueur_Proie(Interface_graphique i_g) {
		this.interface_graphique = i_g;
	}


	public void jouer(int[][] plateau, int player) {
		
		coup = interface_graphique.selectionnerCoup(plateau, player);
		
	}

	public ArrayList<Point> getCoup() {
		return coup;
	}

}