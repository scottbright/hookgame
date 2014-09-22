import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;



public class HookGame extends BasicGame {

	static public int screen_x = 1240;
	static public int screen_y = 720;
	static public Player player;
	static public int nEnemy = 20;
	private boolean gameStart = false;
	private Enemy[] enemy= new Enemy[nEnemy];
	static public float time = 60;
	static public float smalltime = 0;
	static public int score = 0;
	
	public HookGame(String title) {
		super(title);
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		player.render(g);
		enemyrender(g);
		g.drawString("Score: " + score, screen_x-140, 10);
		g.drawString("Time: " + time, screen_x/2, 10);
	}

	public void enemyrender(Graphics g) {
		for(int i =0; i<nEnemy; i++){
			enemy[i].render(g);
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		player = new Player(screen_x/2,600);
		for(int i = 0; i<nEnemy; i++){
			enemy[i] = new minion2(HookGame.screen_x+i*1000,90);
		}
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		
		Input input = container.getInput();
		checkStart(input);
		if(gameStart){
			player.update(input);
			player.handupdate();
			enemyupdate();
			smalltime++;
			if(smalltime == 61){
				smalltime = 0;
				time--;
			}
		}
	}

	public void checkStart(Input input) {
		if (input.isKeyDown(Input.KEY_S) && !gameStart) { 
			gameStart = true;
		 }
	}

	public void enemyupdate() {
		for(int i =0; i<nEnemy; i++){
			enemy[i].update();
			Enemy.checkCollision(enemy[i]);
		}
	}
	
	
	
	public static void main(String[] args) {
	    try {
	      HookGame game = new HookGame("Hook Game");
	      AppGameContainer appgc = new AppGameContainer(game);
	      appgc.setDisplayMode(screen_x,screen_y, false);
	      appgc.setTargetFrameRate(60);
	      //appgc.setMinimumLogicUpdateInterval(1);
	      appgc.start();
	    } catch (SlickException e) {
	      e.printStackTrace();
	    }
	  }
}
