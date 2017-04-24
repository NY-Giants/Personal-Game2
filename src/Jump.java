import javax.swing.JFrame;

public class Jump {
	JFrame frame;
	static final int width = 500;
	static final int height = 800;
	GamePanel2 gPanel;

	public static void main(String[] args) {
		Jump jump = new Jump();
		jump.setup();
	}

	Jump() {
		gPanel = new GamePanel2(width, height);
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(width, height);
		frame.add(gPanel);
		frame.addKeyListener(gPanel);
	}

	void setup() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gPanel.startGame();
	}
}
