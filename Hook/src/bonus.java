import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class bonus extends Enemy {

	public bonus(float x, float y) throws SlickException {
		super(x, y);
		image_enemy = new Image("res/bonus.png");
		enemy_width = 60;
		enemy_heigh = 80;
		speed = 13;
	}

}
