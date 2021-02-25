import java.awt.Point;
import java.util.ArrayList;


public interface Player {


	public void jouer(int[][] plateau, int player);

	public ArrayList<Point> getCoup();

}