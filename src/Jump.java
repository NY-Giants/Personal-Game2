import javax.swing.JFrame;

public class Jump {
	JFrame frame;
	static final int width = 1000;
	static final int height = 800;
	GamePanel2 Gpanel = new GamePanel2();
	public static void main(String[] args) {
	Jump jump = new Jump();
	jump.setup();
	}
Jump(){
	Gpanel = new GamePanel2();
	frame = new JFrame();
	frame.setVisible(true);
	frame.setSize(width, height);
	frame.add(Gpanel);
	
	
}
void setup(){
	frame.add(Gpanel);
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	Gpanel.startGame();
}
}
