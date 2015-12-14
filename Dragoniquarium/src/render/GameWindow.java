package render;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameWindow extends JFrame{

	private static final long serialVersionUID = 5638174721832171084L;
	private JComponent currentScene;
	
	public GameWindow(JComponent scene){
		super("Dragoniquarium");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		this.currentScene = scene;
		getContentPane().add(currentScene);
		pack();
		setVisible(true);
		currentScene.requestFocus();
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = new ImageIcon("src/res/AncientCursor.png").getImage();
//		Image image = new ImageIcon("src/res/Cursor.png").getImage();
		Cursor c = toolkit.createCustomCursor(image , new Point(0, 0), "custom cursor");
		this.setCursor (c);
		
//		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		Resource.coinSound.loop();
	}
	
	public void switchScene(JComponent scene){
		getContentPane().remove(currentScene);
		this.currentScene = scene;
		getContentPane().add(currentScene);
		getContentPane().validate();
		pack();
		currentScene.requestFocus();
	}
	
	public JComponent getCurrentScene(){
		return currentScene;
	}
}
