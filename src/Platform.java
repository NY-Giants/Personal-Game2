import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Platform extends GameObject2 {
	int speed;
	int velocity;
	int gravity;
	int ground;
	boolean isAlive = true;

	Platform(int x, int y) {
		super();
		this.x = x;
		width = 60;
		height = 20;
		this.y = y;
		speed = 10;
		gravity = 1;
		velocity = 0;
		ground = 725;
		collisionBox = new Rectangle(x, y, width, 1);
	}

	void update() {
		velocity += gravity;
		// y += velocity;
		if (y > ground) {
			y = ground;
			System.out.println("on ground");
			velocity = 0;

		}
		collisionBox.setBounds(x, y, width, 1);
	}

	void draw(Graphics z) {
		z.setColor(Color.BLUE);
		z.fillRect(x, y, width, height);
		z.drawRect(x, y, width, height);
		super.draw(z);

	}

}
