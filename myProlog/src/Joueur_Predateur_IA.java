import java.awt.Point;
import java.util.ArrayList;

public class Joueur_Predateur_IA implements Player {
    int player=1;
    ArrayList<Point>coup_proie;
	ArrayList<Point> coup;
	ArrayList<Point>coup_predateur;
	int lin;
	int col;

	Interface_graphique interface_graphique;
	
	public Joueur_Predateur_IA(Interface_graphique i_g) {
		this.interface_graphique = i_g;
		int lin=interface_graphique.plateau.length;
		int col=interface_graphique.plateau[0].length;
		
	}
	public void jouer(int[][] plateau, int player) {
		ArrayList<Point> coup=new ArrayList<Point>();
		
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				if (plateau[j][i]==3){
					Point proie = new Point((int) j,(int) i);
					coup_proie.add(proie);
				}
	
			}
		}
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				if (plateau[j][i]==3){
					Point predateur = new Point((int) j,(int) i);
					coup_predateur.add(predateur);
				}
				}
			}
	coup.add(coup_predateur.get(0));
	//for(int x=0;x<coup_proie.size();x++)
	Point next=new Point((int)coup_predateur.get(0).getX(),(int)coup_predateur.get(0).getY()+1);
	coup.add(next);
	
	}

	@Override
	public ArrayList<Point> getCoup() {

		return null;
	}

}
