package logic;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.Box.Filler;

import render.DrawingUtility;
import render.IRenderable;
import render.RenderableHolder;

public class Button implements IRenderable{

	private int x, y;
	private int cost;
	private int width, height;
	private boolean visible = true;
	private boolean isPointerOver = false;
	
	private int type;
	/* type 1 to 5 - create dragon 1-5
	 * type 6 pause
	*/
	public Button(int type, int x, int y, int width, int height,int cost) {
		super();
		this.type = type;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.cost = cost;
	}
	public void click(List <TargetObject> onScreenObject, PlayerStatus player,int zCounter) {
		if( 1<= type && type <= 5) {
			if( player.getEgg() < cost) {
				return ;
			} else {
				player.subtractEgg(cost);
			}
		}
		TargetObject dragon = null;
		switch (type) {
		case 1:
			dragon = new Dragon1(RandomUtility.random(300, 700), 0, zCounter);
			break;
		case 2:
			dragon = new Dragon2(RandomUtility.random(300, 700), 0, zCounter);
			break;
		case 3:
			break;
		
		case 4:
			dragon = new Dragon4(RandomUtility.random(300, 700), 0, zCounter);
			break;
			
		case 5:
			break;
			
		case 6:
			
			break;
		
		default:
			break;
		}
		
		if(dragon != null) {
			onScreenObject.add(dragon);
			RenderableHolder.getInstance().add(dragon);
		}
	}
	
	public boolean contains(double x, double y){
		return this.x <= x && x <= this.x + width && this.y <= y && y <= this.y + height ;
	}
	
	public void setPointerOver(boolean isPointerOver) {
		this.isPointerOver = isPointerOver;
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		if(isPointerOver) {
			g2d.setColor(Color.RED);
		} else {
			g2d.setColor(Color.GREEN);
		}
		
		g2d.fillRect(x, y, width, height);
//		DrawingUtility.drawButton(type);
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	@Override
	public int getZ() {
		return Integer.MAX_VALUE;
	}
	
	

}
