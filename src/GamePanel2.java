import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel2 extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Block Blocky;
GamePanel2(){
	timer = new Timer(1000/60, this);	
	 Blocky = new Block(50, 50);
		Blocky.x = 250;
		Blocky.y = 400;
	}

@Override
public void actionPerformed(ActionEvent e) {
	if(currentState == MENU_STATE){
		updateMenuState( );
	}else if(currentState == GAME_STATE){
		updateGameState( );
	}else if(currentState == END_STATE){
		updateEndState();
	}
	repaint();
}
void startGame(){
	timer.start();
}
public void paintComponent(Graphics z){
	if(currentState == MENU_STATE){
		drawMenuState(z);
	}else if(currentState == GAME_STATE){
		drawGameState(z);
	}else if(currentState == END_STATE){
		drawEndState(z);
	}
	repaint();
}
void updateGameState(){
	Blocky.update();
	
}
void updateMenuState(){
	
}
void updateEndState(){
	
}
void drawMenuState(Graphics z){
	z.setColor(Color.RED);
	z.fillRect(0, 0, Jump.width, Jump.height);  
	//z.setFont(); 
	z.setColor(Color.BLUE);
	z.drawString("JUMP", 500, 100);
}
void drawGameState(Graphics z){
	z.setColor(Color.BLACK);
	z.fillRect(0, 0, Jump.width, Jump.height);  
	//z.setFont(); 
	Blocky.draw(z);

}
void drawEndState(Graphics z){
	z.setColor(Color.LIGHT_GRAY);
	z.fillRect(0, 0, Jump.width, Jump.height);  
	//z.setFont(); 
	
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyPressed(KeyEvent e) {
	if(e.getKeyCode()==KeyEvent.VK_ENTER)
	{
		currentState++;
		
		if(currentState > END_STATE){
			currentState = MENU_STATE;
		}	
	}	
	if(e.getKeyCode()==KeyEvent.VK_RIGHT){
		Blocky.rightkey = true;
	}
	if(e.getKeyCode()==KeyEvent.VK_LEFT){
		Blocky.leftkey = true;
	}
}

@Override
public void keyReleased(KeyEvent e) {
	if(e.getKeyCode()==KeyEvent.VK_RIGHT){
		Blocky.rightkey = false;
	}	
	if(e.getKeyCode()==KeyEvent.VK_LEFT){
		Blocky.leftkey = false;
	}
}
}
