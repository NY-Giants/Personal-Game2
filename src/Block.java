import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Block extends GameObject2 {
	int speed;
	static boolean upkey;
	static boolean downkey;
	static boolean rightkey;
	static boolean leftkey;
	static boolean space;
	// static int size = 50;
	private boolean canJump = true;
	private boolean applyGravity = false;
	private int velocity;
	private int gravity;
	private int jumpPower;
	private int ground;
	public static BufferedImage QbertImg;

	public boolean isCanJump() {
		return canJump;
	}

	public void setCanJump(boolean canJump) {
		this.canJump = canJump;
	}

	public boolean isApplyGravity() {
		return applyGravity;
	}

	public void setApplyGravity(boolean applyGravity) {
		this.applyGravity = applyGravity;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getGravity() {
		return gravity;
	}

	public void setGravity(int gravity) {
		this.gravity = gravity;
	}

	public int getJumpPower() {
		return jumpPower;
	}

	public void setJumpPower(int jumpPower) {
		this.jumpPower = jumpPower;
	}

	public int getGround() {
		return ground;
	}

	public void setGround(int ground) {
		this.ground = ground;
	}

	Block(int x, int y) {
		super();
		jumpPower = -25;
		this.x = x;
		this.y = y;
		speed = 10;
		upkey = false;
		downkey = false;
		rightkey = false;
		leftkey = false;
		gravity = 1;
		velocity = 0;
		ground = y;
		System.out.println(x);
		System.out.println(y);
		try {
			QbertImg = ImageIO.read(this.getClass().getResourceAsStream("Qbert.png"));
			width = QbertImg.getWidth();
			height = QbertImg.getHeight();
		} catch (Exception e) {
			System.out.println("Block Image not found");
		}

	}

	void update() {

		if (rightkey) {
			x++;
		}
		if (leftkey) {
			x--;
		}
		y += velocity;
		if (applyGravity) {
			velocity += gravity;
		}

		if (y >= ground) {
			y = ground;
			applyGravity = false;
			canJump = true;
			velocity = 0;
		}
		// collisionBox.setBounds(x, y + 50 + height - 1, width, 2);
		collisionBox.setBounds(x, y, width, 120);
	}

	void draw(Graphics z) {
		z.setColor(Color.BLUE);
		// z.fillRect(x, y, width, height);
		// z.drawRect(x, y, width, height);
		z.drawImage(QbertImg, x, y, width, height, null);

		super.draw(z);

	}

	void jump() {
		System.out.println(canJump + " canJump ");
		if (canJump) {
			applyGravity = true;
			velocity = jumpPower;

		}
		System.out.println(velocity + " velocity ");
	}
}
