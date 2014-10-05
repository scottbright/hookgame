import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class minion2 extends Enemy {

	public minion2(float x, float y) throws SlickException {
		super(x, y);
		image_enemy = new Image("res/minion2.png");
		enemy_width = 40;
		enemy_heigh = 80;
		speed = 7;
		score = 14;
	}

}
