import java.awt.Color;
import java.awt.Graphics;

public class Block extends GameObject2 {
	int speed;
	static boolean upkey;
	static boolean downkey;
	static boolean rightkey;
	static boolean leftkey;
	static boolean space;
	static int size = 50;
	boolean canJump = true;
	boolean applyGravity = false;
	int velocity;
	int gravity;
	int jumpPower;
	int ground;

	Block(int x, int y) {
		super();
		jumpPower = 20;
		this.x = x;
		width = Block.size;
		height = Block.size;
		this.y = y;
		speed = 10;
		upkey = false;
		downkey = false;
		rightkey = false;
		leftkey = false;
		gravity = 1;
		velocity = 0;
		ground = y;

	}

	void update() {

		if (rightkey) {
			x++;
		}
		if (leftkey) {
			x--;
		}
		if (applyGravity == true) {
			velocity += gravity;
			y += velocity;
		}
		if (y > ground) {
			y = ground;
			applyGravity = false;
			canJump = true;
			velocity = 0;
		} else {
			canJump = false;
		}

		super.update();
	}

	void draw(Graphics z) {
		z.setColor(Color.BLUE);
		z.fillRect(x, y, width, height);
		z.drawRect(x, y, width, height);
		super.draw(z);

	}

	void jump() {
		if (canJump) {
			applyGravity = true;
			velocity -= jumpPower;
			System.out.println(applyGravity);
			System.out.println(canJump);
		}
	}
}
