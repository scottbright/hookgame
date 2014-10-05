import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class leader extends Enemy {

	public leader(float x, float y) throws SlickException {
		super(x, y);
		image_enemy = new Image("res/leader.png");
		enemy_width = 70;
		enemy_heigh = 80;
		speed = 5;
		score = 15;
	}

}
