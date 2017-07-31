import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class PlatformManager {
ArrayList <Platform> platformList = new ArrayList<Platform>();
public PlatformManager(){
	int y = 850;
Random r1 = new Random();
int Random= r1.nextInt(11) + 30;
for(int i = 0; i< 200; i++){
platformList.add(new Platform(0, 450));
platformList.add(new Platform(150, 150));
platformList.add(new Platform(400, 195));
platformList.add(new Platform(450, 500));
platformList.add(new Platform(100, 600));
//platformList.add(new Platform(Random r2.nextInt(frameWidth), y+= 250));
platformList.add(new Platform(150, 150));
platformList.add(new Platform(450, 500));
platformList.add(new Platform(100, 600));
platformList.add(new Platform(400, 195));
platformList.add(new Platform(0, 450));
platformList.add(new Platform(150, 150));
platformList.add(new Platform(450, 500));
platformList.add(new Platform(100, 600));
platformList.add(new Platform(400, 195));
platformList.add(new Platform(0, 450));
platformList.add(new Platform(150, 150));
platformList.add(new Platform(450, 500));
platformList.add(new Platform(100, 600));
platformList.add(new Platform(400, 195));
platformList.add(new Platform(0, 450));
platformList.add(new Platform(150, 150));
platformList.add(new Platform(450, 500));
platformList.add(new Platform(100, 600));
platformList.add(new Platform(400, 195));
}
}
long enemyTimer = 0;
int enemySpawnTime = 1000;
public void addObject(Platform o) {
	platformList.add(o);
}

private void purgeplatformList() {
	for (int i = 0; i < platformList.size(); i++) {
		if (!platformList.get(i).isAlive) {
			platformList.remove(i);
		}
	}
}

public void manageEnemies(){
	if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
		addObject(new Platform(new Random().nextInt(GamePanel2.imageHeight), 0));
		enemyTimer = System.currentTimeMillis();
		
	}
}
public void draw(Graphics m){
	for(Platform p: platformList){
		p.draw(m);
	}
	for (int i = 0; i < platformList.size(); i++) {
		GameObject2 o = platformList.get(i);
		o.draw(m);
	}
	}
public void update(){
	for(Platform p: platformList){
		p.update();
	}
	for (int i = 0; i < platformList.size(); i++) {
		GameObject2 o = platformList.get(i);
		o.update();
	}
	
	purgeplatformList();	
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
