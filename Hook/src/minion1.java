import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class minion1 extends Enemy {

	public minion1(float x, float y) throws SlickException {
		super(x, y);
		image_enemy = new Image("res/minion1.png");
		enemy_width = 70;
		enemy_heigh = 80;
		speed = 6;
		score = 4;
	}

}
