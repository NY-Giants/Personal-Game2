import java.awt.Color;
import java.awt.Graphics;

public class Platform extends GameObject2 {
	int speed;
	int velocity;
	int gravity;
	int ground;
	boolean isAlive = true;
	Platform(int x, int y) {
		super();
		this.x = x;
		width = 65;
		height = 20;
		this.y = y;
		speed = 10;
		gravity = 1;
		velocity = 0;
		ground = 725;
	}

	void update() {
		velocity += gravity;
		y += velocity;
		if (y > ground) {
			y = ground;		
			velocity = 0;
		} else {

		}

	}

	void draw(Graphics z) {
		z.setColor(Color.BLUE);
		z.fillRect(x, y, width, height);
		z.drawRect(x, y, width, height);
		super.draw(z);

	}

	}
