import java.awt.Graphics;
import java.util.ArrayList;

public class PlatformManager {
ArrayList <Platform> platformList = new ArrayList<Platform>();
public PlatformManager(){
platformList.add(new Platform(0, 450));
platformList.add(new Platform(150, 150));
platformList.add(new Platform(450, 500));
platformList.add(new Platform(100, 600));
platformList.add(new Platform(400, 195));
}
public void draw(Graphics m){
	for(Platform p: platformList){
		p.draw(m);
	}
	}
public void update(){
	for(Platform p: platformList){
		p.update();
	}
}
public boolean checkCollision(Block blocky){
	for(Platform p: platformList){
		if (blocky.collisionBox.intersects(p.collisionBox)) {
			blocky.y = p.y - blocky.collisionBox.height;
			blocky.setApplyGravity(false);
			blocky.setVelocity(0);
			blocky.setCanJump(true);
			return true;

		} else {
			blocky.setApplyGravity(true);
			

		}
	}
	return false;
}
}
