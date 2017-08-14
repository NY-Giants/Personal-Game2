import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class PlatformManager  {
ArrayList <Platform> platformList = new ArrayList<Platform>();
static boolean hasStarted = false;
public PlatformManager(){
Random r1 = new Random();
for(int i = 0;i<=100000 ; i+= (r1.nextInt(251)+50)){
addObject(new Platform(r1.nextInt(501),i));
System.out.println(i);
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

public void manage(){
	if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
		addObject(new Platform(new Random().nextInt(GamePanel2.imageHeight), 0));
		enemyTimer = System.currentTimeMillis();
		
	}
}
public void draw(Graphics m){
	for(Platform p: platformList){
		p.draw(m);
	}
//	for (int i = 0; i < platformList.size(); i++) {
//		GameObject2 o = platformList.get(i);
//		o.draw(m);
//	}
	}
public void update(){
	for(Platform p: platformList){
		p.update();
	}
//	for (int i = 0; i < platformList.size(); i++) {
//		GameObject2 o = platformList.get(i);
//		o.update();
//	}
	manage();
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
	if(blocky.y < 673) {
		hasStarted = true;
		
	}
	if(hasStarted == true && blocky.y == 673) {
		System.out.println("ererh");
	}
	return false;
	
}
}
