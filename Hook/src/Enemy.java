import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Enemy {

	protected float x;
	protected float y;
	static protected float enemy_width;
	static protected float enemy_heigh;
	protected float speed = 7;
	protected Image image_enemy;
	protected boolean isCollision = false;
	
	public Enemy (float x , float y) throws SlickException {
		setXY(x,y);
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
			moveWithHand();
			if(y>600){
				x = (HookGame.nEnemy-2)*1400;
				y = 90;
				isCollision = false;
			}
		}
		 
	  }

	public void moveWithHand() {
		x = HookGame.player.hand_x - 10;
		y = HookGame.player.hand_y;
	}
	 
	public static void checkCollision(Enemy temp){
		if( (HookGame.player.hand_x - temp.x <= enemy_width && HookGame.player.hand_x - temp.x >- 0  ) && Math.abs(HookGame.player.hand_y - temp.y)<= enemy_heigh/2 ){
			temp.isCollision = true;
		}
		
	}
}
