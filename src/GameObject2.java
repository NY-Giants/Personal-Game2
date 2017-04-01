import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject2 {
int x;
int y;
int width;
int height;
Rectangle collisionBox;
	public GameObject2() {
		 collisionBox = new Rectangle(x ,y, width, height);
	}
void update(){
	collisionBox.setBounds(x, y, width, height);
	
}
void draw(Graphics z){

}
}