import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;



public class Moteur_de_jeu {

	public int[][] plateau;
	int point_predateur;
	int point_proie;
	int taille_case;
    int cols;
	int lins;
	int obstacles=5;
	int proies=7;
	int predateurs=5;
	int sorties=5;
	int nb_tour=0;
	int position_proie;
	int position_predateur;
	//ArrayList<Point> coup = new ArrayList<Point>();
	Joueur_Proie joueurProie;
	Joueur_Predateur joueurPredateur;
	//Joueur_Proie_IA joueurProieIA;
	//Joueur_Predateur_IA joueurPredateurIA;
	boolean validiteCoup = false;
	Interface_graphique interface_graphique;

	public Moteur_de_jeu(int lins,int cols, int taille_case) {
		
		this.cols=cols;
		this.lins=lins;
		this.taille_case = taille_case;
		interface_graphique = new Interface_graphique(taille_case, plateau);
		joueurPredateur = new Joueur_Predateur(interface_graphique);
		joueurProie = new Joueur_Proie(interface_graphique);
		//joueurPredateurIA = new Joueur_Predateur_IA(interface_graphique);
		//joueurProieIA = new Joueur_Proie_IA(interface_graphique);
	
	}


	public void init() {
		plateau = new int[lins][cols];

		for (int i = 0; i < lins; i++) {
			for (int j = 0; j < cols; j++) {
				plateau[i][j] = 0;
			}
		}
		for (int i = 0; i < sorties; i++) { 
			int x = (int) (Math.random() * cols);
			int y = (int) (Math.random() * lins);
			plateau[x][y] = 1;
			
		}
		for (int i = 0; i < obstacles; i++) {
            int x = (int) (Math.random() * (cols ));
			int y = (int) (Math.random() * (lins ));
			if (plateau[x][y] == 0)
				plateau[x][y] = 2;
			else
				i--;
		}
		for (int i = 0; i < proies; i++) {
			int x = (int) (Math.random() * (cols ));
			int y = (int) (Math.random() * (lins ));
			if (plateau[x][y] == 0)
				plateau[x][y] = 3;
			else
				i--;
		}
		for (int i = 0; i < predateurs; i++) {
			int x = (int) (Math.random() * (cols - 1 + 1));
			int y = (int) (Math.random() * (lins - 1 + 1));
			if (plateau[x][y] == 0)
				plateau[x][y] = 4;
			else
				i--;
		}

		JFrame jf = new JFrame();
		JTextArea textArea = new JTextArea();
		//textArea.setText("test"); 
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d = new Dimension((this.cols + 4) * taille_case, (this.lins + 4) * taille_case);
		jf.setPreferredSize(d);
		interface_graphique.plateau = this.plateau;
		interface_graphique.afficherPlateau(jf);
		jf.pack();
		jf.setVisible(true);
	}

	public void verifierValidite(ArrayList<Point> coup, int player, int[][] plateau) { 
		if(player==0){if (Math.abs(coup.get(1).getX() - coup.get(0).getX()) + Math.abs(coup.get(1).getY() - coup.get(0).getY()) > 1
				|| plateau[(int) coup.get(1).getX()][(int) coup.get(1).getY()] == 2
				|| (player == 0 && plateau[(int) coup.get(1).getX()][(int) coup.get(1).getY()] == 3))
				 {
		} else {
			validiteCoup = true;
		}
		}
		else{if (Math.abs(coup.get(1).getX() - coup.get(0).getX()) + Math.abs(coup.get(1).getY() - coup.get(0).getY()) > 1
				|| plateau[(int) coup.get(1).getX()][(int) coup.get(1).getY()] == 2
				||  plateau[(int) coup.get(1).getX()][(int) coup.get(1).getY()] == 4
						|| plateau[(int) coup.get(1).getX()][(int) coup.get(1).getY()] == 1
						  || plateau[(int) coup.get(1).getX()][(int) coup.get(1).getY()] == 9 ) {
		} else {
			validiteCoup = true;
		}
		}
		
	
	
	
	
	}
	
		
	

	public void modifierplateau(ArrayList<Point> coup,  int player, int[][] plateau) { 
		
		if(player==0){
		int XAvant = (int) coup.get(0).getX();
		int YAvant = (int) coup.get(0).getY();
		int XApres = (int) coup.get(1).getX();
		int YApres = (int) coup.get(1).getY();
		plateau[XAvant][YAvant] = 0;
		
			if (plateau[XApres][YApres] == 1) {
				proies--;
				System.out.println("Le proie sorti");
				point_proie++;
			} else if (plateau[XApres][YApres] == 4) {
				proies--;
				System.out.println("Le proie a ete mange par un predateur");
				point_predateur++;
			} else {
				plateau[XApres][YApres] = 3;
			
			}
		}
		else{
			int XAvant = (int) coup.get(0).getX();
			int YAvant = (int) coup.get(0).getY();
			int XApres = (int) coup.get(1).getX();
			int YApres = (int) coup.get(1).getY();
			plateau[XAvant][YAvant] = 0;
			
				if (plateau[XApres][YApres] == 3) {
					proies--;
					System.out.println("Le predateur a mange un proie");
					point_predateur++;
				}
				plateau[XApres][YApres] = 9;
			}
			
		
		this.plateau = plateau;
		this.interface_graphique.plateau = plateau;
		this.interface_graphique.dessin.plateau = plateau;
		this.interface_graphique.dessin.point_proie=point_proie;
		this.interface_graphique.dessin.point_predateur=point_predateur;
		this.interface_graphique.dessin.nb_proie=proies;
		this.interface_graphique.dessin.repaint();
	}

	public void Jeu() {
		int x = 0;
		if(proies==0){}
		else{do {
			do {//int position_proie=(nb_tour*(3+predateurs)+x)*2;
				joueurProie.jouer(plateau, 0);
				this.plateau = interface_graphique.plateau;
				this.verifierValidite(joueurProie.getCoup(), 0, plateau);
			} while (!validiteCoup);
			this.modifierplateau(joueurProie.getCoup(), 0, plateau);
		
			x++;
			validiteCoup = false;
			
		} while (x < 3&& proies!=0);
		if(proies!=0){
	       for (int i = 0; i < predateurs; i++) {
			do { //int position_predateur=(nb_tour*(3+predateurs)+x)*2+3+i;
				joueurPredateur.jouer(plateau, 1);
				this.plateau = interface_graphique.plateau;
				this.verifierValidite(joueurPredateur.getCoup(), 1, plateau);
			} while (!validiteCoup);
			modifierplateau(joueurPredateur.getCoup(), 1 , plateau);
			validiteCoup = false;
		
		}
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[0].length; j++) {
				if (plateau[i][j] ==9) {
					plateau[i][j] = 4;
				}
			}
		}
		nb_tour++;
		
		
		
		this.interface_graphique.dessin.plateau = plateau;
		this.interface_graphique.dessin.repaint();}
		else{}

	}}
}
