import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Banner extends JPanel {
	ArrayList<GameObject2> objects;
	public static int score = 0;
	
	Banner(){
		JLabel scoreexample = new JLabel("score");
		JLabel hiscore = new JLabel("hiscore");
		objects = new ArrayList<GameObject2>();
		
	}
	public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				GameObject2 o1 = objects.get(i);
				GameObject2 o2 = objects.get(j);
				
				if(o1.collisionBox.intersects(o2.collisionBox)){
					if((o1 instanceof Block && o2 instanceof Platform) ||
					   (o2 instanceof Block && o1 instanceof Platform)){
						score++;
						System.out.println(score +"score");
						o1.isAlive = true;
						o2.isAlive = true;
			          		}
					else if((o1 instanceof Block && o2 instanceof Enemy) ||
							(o2 instanceof Block && o1 instanceof Enemy)){
						o1.isAlive = false;
						o2.isAlive = false;
					} 
					else if((o1 instanceof Block && o2 instanceof BonusPoint) ||
							(o2 instanceof Block && o1 instanceof BonusPoint)){
						score++;
						System.out.println(score);
						o1.isAlive = true;
						o2.isAlive = true;
					} 
				}
			}
		}
	}
	
	public int getScore(){
		return score;
	}
}
