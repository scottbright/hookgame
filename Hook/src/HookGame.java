import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;



public class HookGame extends BasicGame {

	static public int screen_x = 840;
	static public int screen_y = 720;
	static public Player player;
	static public int nEnemy = 12;
	private boolean gameStart = false;
	private Enemy[] enemyLine1= new Enemy[nEnemy];
	private Enemy[] enemyLine2= new Enemy[nEnemy];
	private Enemy[] enemyLine3= new Enemy[nEnemy];
	static public int time = 0;
	static public int smalltime = 0;
	static public int gameTime = 60;
	static public int score = 0;
	
	public HookGame(String title) {
		super(title);
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		player.render(g);
		enemyrender(g);
		g.drawString("Score: " + score, screen_x-140, 10);
		g.drawString("Time: " + (gameTime-time), screen_x/2, 10);
	}

	public void enemyrender(Graphics g) {
		for(int i =0; i<nEnemy; i++){
			enemyLine1[i].render(g);
			enemyLine2[i].render(g);
			enemyLine3[i].render(g);
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		player = new Player(screen_x/2,600);	
		initLine1();	
		initLine2();
		initLine3();
	}

	public void initLine3() throws SlickException {
		for(int i = 0; i<nEnemy; i++){
			if(i == 2 || i == 8)
				enemyLine3[i] = new leader(HookGame.screen_x+i*400+250,220);
			else if(i==5 || i==10)
				enemyLine3[i] = new minion1(HookGame.screen_x+i*400+250,230);
			else if(i==6 || i==9)
				enemyLine3[i] = new minion2(HookGame.screen_x+i*400+250,240);
			else if(i==3 || i==11)
				enemyLine3[i] = new minion3(HookGame.screen_x+i*400+250,250);
			else if(i==7 || i==4)
				enemyLine3[i] = new bonus(HookGame.screen_x+i*400+250,260);
			else
				enemyLine3[i] = new Mark(HookGame.screen_x+i*400+250,270);
		}
	}

	public void initLine2() throws SlickException {
		for(int i = 0; i<nEnemy; i++){
			if(i == 5 || i == 12)
				enemyLine2[i] = new leader(HookGame.screen_x+i*400+100,160);
			else if(i==4 || i==10)
				enemyLine2[i] = new minion1(HookGame.screen_x+i*400+100,170);
			else if(i==3 || i==11)
				enemyLine2[i] = new minion2(HookGame.screen_x+i*400+100,180);
			else if(i==0 || i==9)
				enemyLine2[i] = new minion3(HookGame.screen_x+i*400+100,190);
			else if(i==1 || i==8)
				enemyLine2[i] = new bonus(HookGame.screen_x+i*400+100,200);
			else
				enemyLine2[i] = new Mark(HookGame.screen_x+i*400+100,210);
		}
	}

	public void initLine1() throws SlickException {
		for(int i = 0; i<nEnemy; i++){
			if(i == 0 || i == 4)
				enemyLine1[i] = new leader(HookGame.screen_x+i*400,90);
			else if(i==1 || i==9)
				enemyLine1[i] = new minion1(HookGame.screen_x+i*400,100);
			else if(i==2 || i==12)
				enemyLine1[i] = new minion2(HookGame.screen_x+i*400,120);
			else if(i==3 || i==6)
				enemyLine1[i] = new minion3(HookGame.screen_x+i*400,130);
			else if(i==5 || i==11)
				enemyLine1[i] = new bonus(HookGame.screen_x+i*400,140);
			else
				enemyLine1[i] = new Mark(HookGame.screen_x+i*400,150);
		}
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		
		Input input = container.getInput();
		checkStart(input);
		if(gameStart&&time<gameTime){
			player.update(input);
			player.handupdate();
			enemyupdate();
			smalltime++;
			if(smalltime == 60){
				smalltime = 0;
				time++;
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
			enemyLine1[i].update();
			Enemy.checkCollision(enemyLine1[i]);
		}
		
		for(int i =0; i<nEnemy; i++){
			enemyLine2[i].update();
			Enemy.checkCollision(enemyLine2[i]);
		}
		
		for(int i =0; i<nEnemy; i++){
			enemyLine3[i].update();
			Enemy.checkCollision(enemyLine3[i]);
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
