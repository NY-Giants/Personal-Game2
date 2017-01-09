import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel2 extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	GameObject2 object = new GameObject2();
GamePanel2(){
	timer = new Timer(1000/60, this);	
	}

@Override
public void actionPerformed(ActionEvent e) {
object.update();
	
}
void startGame(){
	timer.start();
}
public void paintComponent(Graphics z){
	object.draw(z);
	repaint();
}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}
