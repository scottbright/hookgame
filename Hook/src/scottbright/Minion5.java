package scottbright;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Minion5 extends Enemy {

	public Minion5(float x, float y) throws SlickException {
		super(x, y);
		image_enemy = new Image("res/mark.png");
		enemy_width = 40;
		enemy_heigh = 80;
		speed = 8;
	}

}
