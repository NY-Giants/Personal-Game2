import java.awt.Color;
import java.awt.Graphics;

public class Block extends GameObject2 {
int speed;
static boolean upkey;
static boolean downkey;
static boolean rightkey;
static boolean leftkey;
int velocity;
int gravity;
	public static void main(String[] args) {
	

	}
Block(int x, int y){
	super();
	this.x=x;
width = 35;
height = 35;
this.y = y;
speed = 2;
upkey = false;
downkey = false;
rightkey = false;
leftkey = false;
gravity = 1;
velocity = 0;
}
void update(){

	if(upkey){
	y--;
	
}
	
if(downkey){
	y++;
}
if(rightkey){
	x++;
}
if(leftkey){
	x--;
}
if(y >= 750){
	y = 750;
}
else{
	velocity+=gravity;
	y+=velocity;
}
}
void draw(Graphics z){
	z.setColor(Color.BLUE);
	z.fillRect(x, y, width, height);
	super.draw(z);
	
	
}
}
