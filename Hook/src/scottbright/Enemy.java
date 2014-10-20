package scottbright;
import java.util.Random;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Enemy {

	protected float position_x;
	protected float position_y;
	static protected float enemy_width;
	static protected float enemy_heigh;
	protected float speed;
	protected Image image_enemy;
	protected boolean isCollision = false;
	protected static int score = 0;
	int nEnemy = 12;

	public Enemy(float x, float y) throws SlickException {
		setXY(x, y);
	}

	public void setXY(float x, float y) {
		this.position_x = x;
		this.position_y = y;
	}

	public void render(Graphics g) {
		image_enemy.draw(position_x, position_y);
		if (isCollision) {
			g.drawString("+" + score, position_x, position_y - 40);
		}
	}

	public void update() {
		Random rand = new Random();
		if (isCollision == false) {
			position_x -= speed;
			if (position_x <= -100) {
				position_x = HookGame.screen_x
						+ rand.nextInt((HookGame.screen_x * 2 - 100) + 1) + 100;
			}
		} else if (isCollision == true) {
			moveWithHand();

			if (position_y > 600) {
				HookGame.score += score++;
				position_x = HookGame.screen_x
						+ rand.nextInt((HookGame.screen_x * 2 - 100) + 1) + 100;
				position_y = rand.nextInt((300 - 90) + 1) + 90;
				isCollision = false;
			}
		}

	}

	public void moveWithHand() {
		position_x = HookGame.player.hand_position_x - 10;
		position_y = HookGame.player.hand_position_y;
	}

	public static void checkCollision(Enemy enemy) {

		if (HookGame.player.hand_position_x - enemy.position_x <= enemy_width) {
			if (HookGame.player.hand_position_x - enemy.position_x > -0) {
				if (Math.abs(HookGame.player.hand_position_y - enemy.position_y) <= enemy_heigh / 2)
					/* && (temp.isCollision == false) */
					enemy.isCollision = true;
			}
		}

	}
}
