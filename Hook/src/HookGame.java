import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
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
	private int TimeLimit = 6;
	
	public HookGame(String title) {
		super(title);
	}
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		player.render(g);
		enemyrender(g);
		g.drawString("Score: " + score, screen_x-140, 10);
		g.drawString("Time: " + (TimeLimit-time), screen_x/2, 10);
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
	}

	public void initEnemy() throws SlickException {
		for(int i = 0; i<nEnemy; i++){
			if(i == 0 || i == 4)
				EnemyList[i] = new leader(HookGame.screen_x+i*400,90);
			else if(i==1 || i==9)
				EnemyList[i] = new minion1(HookGame.screen_x+i*400,100);
			else if(i==2 || i==12)
				EnemyList[i] = new minion2(HookGame.screen_x+i*400,120);
			else if(i==3 || i==6)
				EnemyList[i] = new minion3(HookGame.screen_x+i*400,130);
			else if(i==5 || i==11)
				EnemyList[i] = new bonus(HookGame.screen_x+i*400,140);
			else
				EnemyList[i] = new Mark(HookGame.screen_x+i*400,150);
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
