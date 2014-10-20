package scottbright;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Player {

	protected float x;
	protected float y;
	protected float speed = 8;
	static public float h_speed = 10;
	protected Image image_nak;
	protected Image image_hand;
	protected float hand_position_x;
	protected float hand_position_y;
	boolean isHandMoving = false;
	boolean willHandBack = true;

	public Player(float x, float y) throws SlickException {
		image_nak = new Image("res/nak.png");
		image_hand = new Image("res/hand.png");
		this.setXY(x, y);
	}

	public void setXY(float x, float y) {
		this.x = x;
		this.y = y;
		this.hand_position_x = x;
		this.hand_position_y = y + 30;
	}

	public void render(Graphics g) {
		image_nak.draw(x, y);
		image_hand.draw(hand_position_x, hand_position_y);
	}

	public void update(Input input) {
		if (input.isKeyDown(Input.KEY_LEFT)) {
			x -= speed;
		}
		if (input.isKeyDown(Input.KEY_RIGHT)) {
			x += speed;
		}
		if (input.isKeyDown(Input.KEY_SPACE)) {
			if (willHandBack)
				isHandMoving = true;
		}
		hand_position_x = x;
		if (this.x < 10)
			x = 10;
		else if (this.x > HookGame.screen_x - 50)
			x = HookGame.screen_x - 50;
	}

	public void handupdate() {
		handUp();
		handDown();
	}

	public void handDown() {
		if (!isHandMoving) {
			if (hand_position_y < this.y + 30) {
				hand_position_y += h_speed;
			}
		}
	}

	public void handUp() {
		if (hand_position_y > y) {
			willHandBack = true;
		}
		if (isHandMoving) {
			if (hand_position_y > 100) {
				hand_position_y -= h_speed;
			} else if (hand_position_y < 110) {
				isHandMoving = false;
				willHandBack = false;
			}
		}
	}

}
