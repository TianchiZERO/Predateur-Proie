import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JFrame;



public class Interface_graphique extends Thread {
	Dessin dessin;
	int taille_case;
	int[][] plateau;
	Boolean caseValide;
	ArrayList<Point> coup;
	

	public Interface_graphique(int taille_case, int[][] plateau) {
		this.taille_case = taille_case;
		this.plateau = plateau;
		this.dessin = new Dessin(plateau, taille_case);
		
	}

	public void afficherPlateau(JFrame fenetre) {
		dessin = new Dessin(plateau, taille_case);
		fenetre.add(dessin);

	}

	public ArrayList<Point> selectionnerCoup(int[][] plateau, int player) { 
																			
		caseValide = false;
		ArrayList<Point> coup = new ArrayList<Point>();
		if (player == 0) {
			while (caseValide == false) {
				if (plateau[dessin.caseCliquee.x][dessin.caseCliquee.y] == 3) {
					if (dessin.caseCliquee.x + 1 < plateau.length) {
						if (plateau[(int) dessin.caseCliquee.getX() + 1][(int) dessin.caseCliquee
								.getY()] == 0) {
							plateau[(int) dessin.caseCliquee.getX() + 1][(int) dessin.caseCliquee
									.getY()] = 5;
						} else if (plateau[(int) dessin.caseCliquee.getX() + 1][(int) dessin.caseCliquee
								.getY()] == 1) {
							plateau[(int) dessin.caseCliquee.getX() + 1][(int) dessin.caseCliquee
									.getY()] = 6;
						} else if (plateau[(int) dessin.caseCliquee.getX() + 1][(int) dessin.caseCliquee
								.getY()] == 4) {
							plateau[(int) dessin.caseCliquee.getX() + 1][(int) dessin.caseCliquee
									.getY()] = 8;
						}
					}
					if (dessin.caseCliquee.y + 1 < plateau[0].length) {
						if (plateau[(int) dessin.caseCliquee.getX()][(int) dessin.caseCliquee.getY()
								+ 1] == 0) {
							plateau[(int) dessin.caseCliquee.getX()][(int) dessin.caseCliquee.getY()
									+ 1] = 5;
						} else if (plateau[(int) dessin.caseCliquee.getX()][(int) dessin.caseCliquee
								.getY() + 1] == 1) {
							plateau[(int) dessin.caseCliquee.getX()][(int) dessin.caseCliquee
									.getY() + 1] = 6;
						} else if (plateau[(int) dessin.caseCliquee.getX()][(int) dessin.caseCliquee
								.getY() + 1] == 4) {
							plateau[(int) dessin.caseCliquee.getX()][(int) dessin.caseCliquee
									.getY() + 1] = 8;
						}
					}
					if (dessin.caseCliquee.x - 1 >= 0) {
						if (plateau[(int) dessin.caseCliquee.getX() - 1][(int) dessin.caseCliquee
								.getY()] == 0) {
							plateau[(int) dessin.caseCliquee.getX() - 1][(int) dessin.caseCliquee
									.getY()] = 5;
						} else if (plateau[(int) dessin.caseCliquee.getX() - 1][(int) dessin.caseCliquee
								.getY()] == 1) {
							plateau[(int) dessin.caseCliquee.getX() - 1][(int) dessin.caseCliquee
									.getY()] = 6;
						} else if (plateau[(int) dessin.caseCliquee.getX() - 1][(int) dessin.caseCliquee
								.getY()] == 4) {
							plateau[(int) dessin.caseCliquee.getX() - 1][(int) dessin.caseCliquee
									.getY()] = 8;
						}
					}
					if (dessin.caseCliquee.y - 1 >= 0) {
						if (plateau[(int) dessin.caseCliquee.getX()][(int) dessin.caseCliquee.getY()
								- 1] == 0) {
							plateau[(int) dessin.caseCliquee.getX()][(int) dessin.caseCliquee.getY()
									- 1] = 5;
						} else if (plateau[(int) dessin.caseCliquee.getX()][(int) dessin.caseCliquee
								.getY() - 1] == 1) {
							plateau[(int) dessin.caseCliquee.getX()][(int) dessin.caseCliquee
									.getY() - 1] = 6;
						} else if (plateau[(int) dessin.caseCliquee.getX()][(int) dessin.caseCliquee
								.getY() - 1] == 4) {
							plateau[(int) dessin.caseCliquee.getX()][(int) dessin.caseCliquee
									.getY() - 1] = 8;
						}
					}
					this.plateau = plateau;
					dessin.plateau = plateau;
					dessin.repaint();
					caseValide = true;
				}
				try {
					this.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Point caseInitiale = new Point((int) dessin.caseCliquee.getX(),
					(int) dessin.caseCliquee.getY());
			coup.add(caseInitiale);
			while (caseInitiale.getX() == dessin.caseCliquee.getX()
					&& caseInitiale.getY() == dessin.caseCliquee.getY()) {
				try {
					this.sleep(100);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			coup.add(dessin.caseCliquee);
			for (int i = 0; i < plateau.length; i++) {
				for (int j = 0; j < plateau[0].length; j++) {
					if (plateau[i][j] == 5) {
						plateau[i][j] = 0;
					} else if (plateau[i][j] == 6) {
						plateau[i][j] = 1;
					} else if (plateau[i][j] == 7) {
						plateau[i][j] = 3;
					} else if (plateau[i][j] == 8) {
						plateau[i][j] = 4;
					}
				}
			}
			this.plateau = plateau;
			dessin.plateau = plateau;
			dessin.repaint();
			return coup;

		} else {
			while (caseValide == false) {
				if (plateau[dessin.caseCliquee.x][dessin.caseCliquee.y] == 4) {
						if (dessin.caseCliquee.x + 1 < plateau.length) {
							if (plateau[(int) dessin.caseCliquee.getX() + 1][(int) dessin.caseCliquee
									.getY()] == 0) {
								plateau[(int) dessin.caseCliquee.getX() + 1][(int) dessin.caseCliquee
										.getY()] = 5;
							} else if (plateau[(int) dessin.caseCliquee.getX() + 1][(int) dessin.caseCliquee
									.getY()] == 3) {
								plateau[(int) dessin.caseCliquee.getX() + 1][(int) dessin.caseCliquee
										.getY()] = 7;
							}
						}
						if (dessin.caseCliquee.y + 1 < plateau[0].length) {
							if (plateau[(int) dessin.caseCliquee.getX()][(int) dessin.caseCliquee.getY()
									+ 1] == 0) {
								plateau[(int) dessin.caseCliquee.getX()][(int) dessin.caseCliquee.getY()
										+ 1] = 5;
							} else if (plateau[(int) dessin.caseCliquee.getX()][(int) dessin.caseCliquee
									.getY() + 1] == 3) {
								plateau[(int) dessin.caseCliquee.getX()][(int) dessin.caseCliquee
										.getY() + 1] = 7;
							}
						}
						if (dessin.caseCliquee.x - 1 >= 0) {
							if (plateau[(int) dessin.caseCliquee.getX() - 1][(int) dessin.caseCliquee
									.getY()] == 0) {
								plateau[(int) dessin.caseCliquee.getX() - 1][(int) dessin.caseCliquee
										.getY()] = 5;
							} else if (plateau[(int) dessin.caseCliquee.getX() - 1][(int) dessin.caseCliquee
									.getY()] == 3) {
								plateau[(int) dessin.caseCliquee.getX() - 1][(int) dessin.caseCliquee
										.getY()] = 7;
							}
						}
						if (dessin.caseCliquee.y - 1 >= 0) {
							if (plateau[(int) dessin.caseCliquee.getX()][(int) dessin.caseCliquee.getY()
									- 1] == 0) {
								plateau[(int) dessin.caseCliquee.getX()][(int) dessin.caseCliquee.getY()
										- 1] = 5;
							} else if (plateau[(int) dessin.caseCliquee.getX()][(int) dessin.caseCliquee
									.getY() - 1] == 3) {
								plateau[(int) dessin.caseCliquee.getX()][(int) dessin.caseCliquee
										.getY() - 1] = 7;
							}
					}
					dessin.repaint();
					caseValide = true;
				}
				try {
					this.sleep(100);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			Point caseInitiale = new Point(dessin.caseCliquee.x, dessin.caseCliquee.y);
			coup.add(caseInitiale);
			while (caseInitiale.x == dessin.caseCliquee.x && caseInitiale.y == dessin.caseCliquee.y) {
				try {
					this.sleep(100);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			coup.add(dessin.caseCliquee);
			for (int i = 0; i < plateau.length; i++) {
				for (int j = 0; j < plateau[0].length; j++) {
					if (plateau[i][j] == 5) {
						plateau[i][j] = 0;
					} else if (plateau[i][j] == 6) {
						plateau[i][j] = 1;
					} else if (plateau[i][j] == 7) {
						plateau[i][j] = 3;
					} else if (plateau[i][j] == 8) {
						plateau[i][j] = 4;
					}
				}
			}
			this.plateau = plateau;
			dessin.plateau = plateau;
			dessin.repaint();
			return coup;

		}
	}
}
