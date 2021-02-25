import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Dessin extends JPanel implements MouseListener {
	int[][] plateau;
	int taille_case;
	Point caseCliquee = new Point();
    int point_proie=0;
    int point_predateur=0;
    int nb_proie=100;
    int nb_tour=1;
    int nb_tour_max=2;
	public Dessin(int[][] plateau, int taille_case) {
		this.plateau = plateau;
		this.taille_case = taille_case;
		addMouseListener(this);
	}

	public void paint(Graphics g) {
		super.paint(g);
		 g.setColor(Color.black);
		 g.drawString(" VIDE: Blanc",plateau[0].length*taille_case+10,50);
		 g.drawString(" SORTIE£ºVert",plateau[0].length*taille_case+10,70);
		 g.drawString(" OBSTACLE£ºNoir: ",plateau[0].length*taille_case+10,90);
		 g.drawString(" PROIE: Orange",plateau[0].length*taille_case+10,110);
		 g.drawString(" PREATEUR: Bleu",plateau[0].length*taille_case+10,130);
		for (int i = 0; i < plateau.length; i++) {
			for (int j = 0; j < plateau[0].length; j++) {
				if (plateau[i][j] == 0) {                        // vide
					g.setColor(Color.white);
					g.fillRect(i * taille_case, j * taille_case, taille_case, taille_case);
				}
				if (plateau[i][j] == 1) {                        // sortie
					g.setColor(Color.green);
					g.fillRect(i * taille_case, j * taille_case, taille_case, taille_case);
				}
				if (plateau[i][j] == 2) {                        // obstacle
					g.setColor(Color.BLACK);
					g.fillRect(i * taille_case, j * taille_case, taille_case, taille_case);
				}
				if (plateau[i][j] == 3) {                        // proie
					g.setColor(Color.orange);
					g.fillRect(i * taille_case, j * taille_case, taille_case, taille_case);
				}
				if (plateau[i][j] == 4) {                        // preateur
					g.setColor(Color.BLUE);
					g.fillRect(i * taille_case, j * taille_case, taille_case, taille_case);
				}
			
				
				if (plateau[i][j] == 5) {                        // case vide alentour
					g.setColor(Color.red);
					g.fillRect((int) (i* taille_case), (int) (j * taille_case),
							(int) taille_case, (int) taille_case);
				}
				if (plateau[i][j] == 6) {                         // case sortie alentour
					g.setColor(Color.cyan);
					g.fillRect((int) (i * taille_case), (int) (j * taille_case),
							(int) taille_case, (int) taille_case );
				}
				if (plateau[i][j] == 7) {                         // case proie alentour
					g.setColor(Color.yellow);
					g.fillRect((int) (i * taille_case), (int) (j * taille_case),
							(int) taille_case, (int) taille_case );
				}
				if (plateau[i][j] == 8) {                         // case preateur alentour
					g.setColor(Color.pink);
					g.fillRect((int) (i * taille_case), (int) (j * taille_case),
							(int) taille_case, (int) taille_case );
				}
				if (plateau[i][j] == 9) {                       // preateur qui a fini ce tour
					g.setColor(Color.lightGray);
					g.fillRect(i * taille_case, j * taille_case, taille_case, taille_case);
				}
			}
		}
	      g.setColor(Color.black);
	      g.drawString("Score du Proie :  Score du Predateur =  "+ this.point_proie+ "  :  "+this.point_predateur, 10, plateau[0].length*taille_case+30);
          if(nb_proie==0||nb_tour==nb_tour_max){
        	  g.setColor(Color.black);
        	 
        	  g.drawString("GAME OVER",50, plateau[0].length*taille_case+40);
        	  if(this.point_proie>this.point_predateur){
        		  g.setColor(Color.black);
        	  g.drawString("Proie WIN",50, plateau[0].length*taille_case+50);}
        	  
        	  else if(this.point_proie<this.point_predateur){
        		  g.setColor(Color.black);
            	  g.drawString("Predateur WIN ",50, plateau[0].length*taille_case+50);
            	 
        	  }
        	  else{g.setColor(Color.black);
        	  g.drawString("TIE ",50, plateau[0].length*taille_case+50);
         	 }
          }
          else{}
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int X = e.getX();
		int Y = e.getY();
		if (0 < X && X < plateau.length * taille_case && 0 < Y && Y < plateau[0].length * taille_case) {
			caseCliquee.x = (int) Math.floor(X / taille_case);
			caseCliquee.y = (int) Math.floor(Y / taille_case);
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}