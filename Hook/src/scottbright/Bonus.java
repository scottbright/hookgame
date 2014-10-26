package scottbright;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bonus extends Enemy {

	public Bonus(float x, float y) throws SlickException {
		super(x, y);
		image_enemy = new Image("res/bonus.png");
		enemy_width = 60;
		enemy_heigh = 80;
		speed = 13;
	}

}
