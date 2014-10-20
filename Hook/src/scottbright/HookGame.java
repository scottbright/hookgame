package scottbright;
import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;



public class HookGame extends BasicGame {

	int nEnemy = 12;
	static public int screen_x = 840;
	static public int screen_y = 720;
	static public Player player;
	static public int score = 0;
	private boolean gameStart = false;
	private Enemy[] EnemyList= new Enemy[nEnemy];
	private int time = 0;
	private int militime = 0;
	private int TimeLimit = 60;
	
	protected Image floor;
	protected Image background;
	protected Image sky;
	
	public HookGame(String title) {
		super(title);
	}
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		player.render(g);
		enemyrender(g);
		g.drawString("Score: " + score, screen_x-140, 10);
		g.drawString("Time: " + (TimeLimit-time), screen_x/2, 10);
		//background.draw(0,600);
		//floor.draw(0,600);
		//sky.draw(0,0);
		
	}

	public void enemyrender(Graphics g) {
		for(int i =0; i<nEnemy; i++){
			EnemyList[i].render(g);
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		player = new Player(screen_x/2,600);	
		initEnemy();	
//		floor = new Image("res/floor.png");
//		background = new Image("res/background.png");
//		sky = new Image("res/sky.png");
	}

	public void initEnemy() throws SlickException {
		Random rand = new Random();
		for(int i = 0; i<nEnemy; i++){
			if(i == 0 || i == 6)
				EnemyList[i] = new minion1(HookGame.screen_x+rand.nextInt((HookGame.screen_x*2 - 100) + 1) + 100,rand.nextInt((300 - 90) + 1) + 90);
			else if(i==1 || i==7)
				EnemyList[i] = new minion2(HookGame.screen_x+rand.nextInt((HookGame.screen_x*2 - 100) + 1) + 100,rand.nextInt((300 - 90) + 1) + 90);
			else if(i==2 || i==8)
				EnemyList[i] = new minion3(HookGame.screen_x+rand.nextInt((HookGame.screen_x*2 - 100) + 1) + 100,rand.nextInt((300 - 90) + 1) + 90);
			else if(i==3 || i==9)
				EnemyList[i] = new minion4(HookGame.screen_x+rand.nextInt((HookGame.screen_x*2 - 100) + 1) + 100,rand.nextInt((300 - 90) + 1) + 90);
			else if(i==4 || i==10)
				EnemyList[i] = new minion5(HookGame.screen_x+rand.nextInt((HookGame.screen_x*2 - 100) + 1) + 100,rand.nextInt((300 - 90) + 1) + 90);
			else
				EnemyList[i] = new bonus(HookGame.screen_x+rand.nextInt((HookGame.screen_x*2 - 100) + 1) + 100,rand.nextInt((300 - 90) + 1) + 90);
		}
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		
		Input input = container.getInput();
		newGame(input);
		if(gameStart){
			player.update(input);
			player.handupdate();
			enemyupdate();
			time();
		}
	}


	public void time() {
		militime++;
		if(militime == 60){
			militime = 0;
			time++;
		}
		if(time>=TimeLimit){
			gameStart=false;
		}
	}

	public void newGame(Input input) {
		if (input.isKeyDown(Input.KEY_S) && !gameStart) { 
			gameStart = true;
			time = 0;
			score = 0;
		 }
	}

	public void enemyupdate() {
		for(int i =0; i<nEnemy; i++){
			EnemyList[i].update();
			Enemy.checkCollision(EnemyList[i]);
		}
	}
	
	public static void main(String[] args) {
	    try {
	      HookGame game = new HookGame("Hook Game");
	      AppGameContainer appgc = new AppGameContainer(game);
	      appgc.setDisplayMode(screen_x,screen_y, false);
	      appgc.setTargetFrameRate(59);
	      //appgc.setMinimumLogicUpdateInterval(1);
	      appgc.start();
	    } catch (SlickException e) {
	      e.printStackTrace();
		}
	}
}
