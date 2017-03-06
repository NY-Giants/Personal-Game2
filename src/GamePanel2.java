import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel2 extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Block Blocky;
	Font font;
	BufferedImage gamebackground;
	int imageHeight = 0;
	int frameWidth = 0;
	int frameHeight = 0;
	int y1 = 0;
	int y2 = 0;
	int scrollSpeed = 5;
	GamePanel2(int fWidth, int fHeight) {
		timer = new Timer(1000 / 60, this);
		Blocky = new Block(50, 50);
		Blocky.x = 250;
		Blocky.y = 400;
		font = new Font("Arial", Font.PLAIN, 48);
		try{
			gamebackground = ImageIO.read(this.getClass().getResourceAsStream("Game Background.jpg"));
			imageHeight = gamebackground.getHeight();
		}
		catch (Exception e) {
			System.out.println("Background Image not found");
		}
		frameHeight = fHeight;
		frameWidth = fWidth;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}               
		moveBackground(); 
		repaint();
		
	}

	void startGame() {
		timer.start();
	}

	public void paintComponent(Graphics z) {
		if (currentState == MENU_STATE) {
			drawMenuState(z);
		} else if (currentState == GAME_STATE) {
			drawGameState(z);
		} else if (currentState == END_STATE) {
			drawEndState(z);
		}
		repaint();
	}

	void updateGameState() {
		Blocky.update();

	}

	void updateMenuState() {

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics z) {
		z.setColor(Color.RED);
		z.fillRect(0, 0, Jump.width, Jump.height);
		z.setFont(font);
		z.setColor(Color.BLUE);
		z.drawString("JUMP", 400, 100);
		z.setColor(Color.BLUE);
		z.drawString("Press Enter To Start", 250, 500);
	}

	void drawGameState(Graphics z) {
		z.drawImage(gamebackground, 0, 0, frameWidth, frameHeight, 0, y1, frameWidth, y2, this);
		//z.setColor(Color.BLACK);
		//z.fillRect(0, 0, Jump.width, Jump.height);
		// z.setFont();
		Blocky.draw(z);
		
	}

	void drawEndState(Graphics z) {
		z.setColor(Color.LIGHT_GRAY);
		z.fillRect(0, 0, Jump.width, Jump.height);
		z.setFont(font);
		z.drawString("JUMP", 400, 100);
		z.setColor(Color.BLUE);
		z.drawString("Game Over", 400, 100);
		z.setColor(Color.BLUE);
		z.drawString("Press Enter To Restart", 250, 500);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;

			if (currentState > END_STATE) {
				currentState = MENU_STATE;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Blocky.rightkey = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Blocky.leftkey = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Blocky.jump();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Blocky.rightkey = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Blocky.leftkey = false;
		}
	}
	void moveBackground(){
		System.out.println("move");
		if(y2 >= imageHeight){
			y1 = 0;
			y2 = frameHeight;
			
		}
		else{
			y1 += scrollSpeed;
			y2 += scrollSpeed;	
		}
	}
}
