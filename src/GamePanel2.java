import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel2 extends JPanel implements ActionListener, KeyListener {	
	PlatformManager manager = new PlatformManager();
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Block blocky;
	Font font;
	public static BufferedImage gamebackground;
	public static BufferedImage AlienImg;
	public static BufferedImage RubyImg;
	int imageHeight = 0;
	int frameWidth = 0;
	int frameHeight = 0;
	int y1 = 0;
	int y2 = 0;
	int scrollSpeed = 5;
	int score = 0;
	
	GamePanel2(int fWidth, int fHeight) {
		timer = new Timer(1000 / 60, this);
		blocky = new Block(fWidth / 2, 725 - 32);
		font = new Font("Arial", Font.PLAIN, 20);
		try {
			gamebackground = ImageIO.read(this.getClass().getResourceAsStream("Game Background.jpg"));
			imageHeight = gamebackground.getHeight();
			AlienImg = ImageIO.read(this.getClass().getResourceAsStream("Alien.png"));
			RubyImg = ImageIO.read(this.getClass().getResourceAsStream("Bonus Point.png"));

		} catch (Exception e) {
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
		blocky.update();
		manager.update();
		manager.checkCollision(blocky);
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
		z.drawString("JUMP", 200, 100);
		z.setColor(Color.BLUE);
		z.drawString("Press Enter To Start", 125, 500);
	}

	void drawGameState(Graphics z) {
		z.drawImage(gamebackground, 0, 100, frameWidth, frameHeight, 0, y1, frameWidth, y2, this);
		z.setColor(Color.RED);
		z.drawString("SCORE", 100, 50);
		z.setFont(font);
		z.setColor(Color.RED);
		z.drawString("Highscore", 300, 50);
		z.setFont(font);
		blocky.draw(z);
		// z.drawRect(blocky.collisionBox.x, blocky.collisionBox.y,
		// blocky.collisionBox.width, blocky.collisionBox.height);
		manager.draw(z);
		
	}

	void drawEndState(Graphics z) {
		z.setColor(Color.LIGHT_GRAY);
		z.fillRect(0, 0, Jump.width, Jump.height);
		z.setFont(font);
		z.drawString("JUMP", 200, 100);
		z.setColor(Color.BLUE);
		z.drawString("Game Over", 200, 100);
		z.setColor(Color.BLUE);
		z.drawString("Press Enter To Restart", 100, 500);

	}

	@Override
	public void keyTyped(KeyEvent e) {

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
			Block.rightkey = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Block.leftkey = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			blocky.jump();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Block.rightkey = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Block.leftkey = false;
		}
	}

	void moveBackground() {

		if (y2 >= imageHeight) {
			y1 = 0;
			y2 = frameHeight;

		} else {
			y1 += scrollSpeed;
			y2 += scrollSpeed;
		}
	}

}
