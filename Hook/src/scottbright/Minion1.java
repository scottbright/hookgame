package scottbright;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Minion1 extends Enemy {

	public Minion1(float x, float y) throws SlickException {
		super(x, y);
		image_enemy = new Image("res/minion1.png");
		enemy_width = 70;
		enemy_heigh = 80;
		speed = 6;
	}

}
