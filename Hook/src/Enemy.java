import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class Enemy {

	protected float x;
	protected float y;
	protected float speed = 3;
	protected Image image_enemy;
	
	public Enemy () throws SlickException {
		image_enemy = new Image("res/nak.png");
		setXY(HookGame.screen_x,90);
	  }
	
	public void setXY(float x,float y){
		this.x = x;
	    this.y = y;
	}
	
	public void render(Graphics g) {
		  image_enemy.draw(x,y);
	  }
	
	 public void update() {
		  x-=speed;
	  }
}
