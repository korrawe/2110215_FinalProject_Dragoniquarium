package logic;

import java.awt.Graphics2D;

import javax.swing.Box.Filler;

import render.DrawingUtility;
import render.GameAnimation;
import render.Resource;

public class Dragon1 extends DamageableObject {
	
	public boolean layingEgg = false;
	private GameAnimation walkingAnimation;
	private GameAnimation layingAnimation;
	
	public Dragon1(int x, int y, int z) {
		super(x, y, 25, z, 2, 1, 0);
		stateTime = RandomUtility.random(150, 250);
		walkingAnimation = DrawingUtility.createDragon1Animation();
		layingAnimation = DrawingUtility.createDragon1AnimationLayingEgg();
	}
	
	@Override
	public void move() {
		if(destroyed) return;
		
		
		if(state == 1) {
			walkingAnimation.updateAnimation();
		} else if(state == 3) {
			layingAnimation.updateAnimation();
		}
		
		if(hasDestination) {
			moveIn();
			return ;
		}
		if(state == 1) {
			stateTime--;
			if(stateTime == 0) {
				state = 3;
				stateTime = 60;
				layingAnimation.setCurrentFrame(0);
			}
		} else if(state == 3) {
			stateTime--;
			if(stateTime == 15) {
				layingEgg = true;
			}
			
			if(stateTime == 0) {
				state = 1;
				stateTime = RandomUtility.random(400, 600);
			}
			return ;
		}
		
		calculateXaxis();
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		
		// TODO
//		g2d.drawImage(Resource.egg1Sprite, null, (int)x-radius, (int)y-radius);
		g2d.fillOval((int)x-radius, (int)y-radius, radius*2, radius*2);
		if(state == 1) {
			walkingAnimation.draw(g2d, (int)x-radius-5, (int)y-radius*2, isLeft);
		} else if(state == 3) {
			int temp = (int)x-radius;
			if(isLeft) {
				temp += 7;				
			} else {
				temp -= 7;
			}
			layingAnimation.draw(g2d, temp, (int)y-radius-8, isLeft);
		}
	}

}
