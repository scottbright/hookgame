import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class minion3 extends Enemy {

	public minion3(float x, float y) throws SlickException {
		super(x, y);
		image_enemy = new Image("res/minion3.png");
		enemy_width = 50;
		enemy_heigh = 80;
		speed = 6;
		score = 4;
	}

}
