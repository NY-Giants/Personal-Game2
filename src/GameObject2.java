import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class GameObject2 {
int x;
int y;
int width;
int height;
boolean isAlive;
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