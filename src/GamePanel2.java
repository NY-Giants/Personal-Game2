import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel2 extends JPanel implements ActionListener {
	Timer timer;

GamePanel2(){
	timer = new Timer(1000/60, this);	
	}

@Override
public void actionPerformed(ActionEvent e) {

	
}
void startGame(){
	timer.start();
}
public void paintComponent(Graphics z){
	z.fillRect(10, 10, 100, 100);
	repaint();
}
}
