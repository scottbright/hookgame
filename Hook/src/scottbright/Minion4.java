package scottbright;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Minion4 extends Enemy {

	public Minion4(float x, float y) throws SlickException {
		super(x, y);
		image_enemy = new Image("res/leader.png");
		enemy_width = 70;
		enemy_heigh = 80;
		speed = 5;
	}

}
