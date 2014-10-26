package scottbright;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Minion3 extends Enemy {

	public Minion3(float x, float y) throws SlickException {
		super(x, y);
		image_enemy = new Image("res/minion3.png");
		enemy_width = 50;
		enemy_heigh = 80;
		speed = 9;
	}

}
