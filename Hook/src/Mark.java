import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Mark extends Enemy {

	public Mark(float x, float y) throws SlickException {
		super(x, y);
		image_enemy = new Image("res/mark.png");
		enemy_width = 40;
		enemy_heigh = 80;
		speed = 8;
		score = 19;
	}

}
