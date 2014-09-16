import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;



public class HookGame extends BasicGame {

	static public int screen_x = 1240;
	static public int screen_y = 720;
	private Player nak;
	private int nEnemy = 100;
	private Enemy[] enemy= new Enemy[nEnemy];
	public HookGame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		nak.render(g);
		enemyrender(g);
		
	}

	public void enemyrender(Graphics g) {
		for(int i =0; i<nEnemy; i++){
			enemy[i].render(g);
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		nak = new Player(screen_x/2,600);
		for(int i = 0; i<nEnemy; i++){
			enemy[i] = new Enemy(HookGame.screen_x+i*1000);
		}
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		// TODO Auto-generated method stub
		Input input = container.getInput();
		nak.update(input);
		nak.handupdate();
		enemyupdate();
	}

	public void enemyupdate() {
		for(int i =0; i<nEnemy; i++){
			enemy[i].update();
		}
	}
	
	
	
	public static void main(String[] args) {
	    try {
	      HookGame game = new HookGame("Hook Game");
	      AppGameContainer appgc = new AppGameContainer(game);
	      appgc.setDisplayMode(screen_x,screen_y, false);
	      appgc.setTargetFrameRate(60);
	      appgc.start();
	    } catch (SlickException e) {
	      e.printStackTrace();
	    }
	  }
}
