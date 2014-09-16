import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Enemy {

	protected float x;
	protected float y;
	protected float speed = 4;
	protected Image image_enemy;
	protected boolean isCollision = false;
	
	public Enemy (float x) throws SlickException {
		image_enemy = new Image("res/nak.png");
		setXY(x,90);
	  }
	
	public void setXY(float x,float y){
		this.x = x;
	    this.y = y;
	}
	
	public void render(Graphics g) {
		  image_enemy.draw(x,y);
	  }
	
	public void update() {
		if(isCollision == false){
			x-=speed;
			if(x<=-100){
				x = (HookGame.nEnemy)*1400;
			}
		}
		else if(isCollision == true){
			x = HookGame.nak.hand_x - 10;
			y = HookGame.nak.hand_y;
			if(y>600){
				x = (HookGame.nEnemy-2)*1400;
				y = 90;
				isCollision = false;
			}
		}
		 
	  }
	 
	public static void checkCollision(Enemy temp){
		if( (HookGame.nak.hand_x - temp.x <= 40 && HookGame.nak.hand_x - temp.x >- 0  ) && Math.abs(HookGame.nak.hand_y - temp.y)<= 30 ){
			temp.isCollision = true;
		}
		
	}
}
