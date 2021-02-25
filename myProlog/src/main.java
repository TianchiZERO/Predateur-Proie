public class main {
	public static void main(String[] args) {
		int taille_case = 40;
		int lins=9;
		int cols=9;
		int nb_tour_max = 10;
		int nb_tour = 0;
	
		Moteur_de_jeu moteur = new Moteur_de_jeu(lins,cols, taille_case);
		int point_proie = 0;
		int point_predateur = 0;
		
			moteur.init();
	
		while (nb_tour < nb_tour_max) {
			moteur.Jeu();
			nb_tour++;
			moteur.interface_graphique.dessin.nb_tour=nb_tour;
			moteur.interface_graphique.dessin.nb_tour_max=nb_tour_max;
			point_proie=moteur.point_proie;
			point_predateur=moteur.point_predateur;
		
		}
		moteur.interface_graphique.dessin.repaint();
		System.out.println("Fin");
		System.out.println("Score du predateur="+point_predateur);
		System.out.println("Score du proie="+point_proie);
	}

}
