package AlexMovement;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import AlexFrame.AlexFrame;
import MouseHook.MouseLLHook;

public class MoveEyes {
	int lx,ly;
	int rx,ry;
	Eyes eyes;
	AlexFrame alexframe;
	
	public MoveEyes(AlexFrame alexframe){
		this.alexframe = alexframe;
		this.eyes = alexframe.getEyes();
	}
	
	public void setCursorLocation(int x ,int y)
	{
//		x = (int) (x*0.1);
//		y = (int) (y*0.1);
		int R = 12;
		int X1 = eyes.getLeftEyeX();
		int Y1 = eyes.getLeftEyeY();
		int X2 = eyes.getRightEyeX();
		int Y2 = eyes.getRightEyeY();
		double a1 = Math.atan2(x-X1,y-Y1);
		double a2 = Math.atan2(x-X2,y-Y2);
		int lx = (int) (R*Math.sin(a1) + X1 -10);
		int ly = (int) (R*Math.cos(a1) + Y1 -10);
		if(ly < 44)
		{
			ly = 44;
		}
		if(lx < 20)
		{
			lx = 20;
		}
		int rx = lx + 60;
		int ry = ly + 3;
//		eyes.setLeftEyeLocation(lx, Y1);
//		eyes.setRightEyeLocation(rx, Y2);
		
		eyes.setLeftEyeLocation(lx, ly);
		eyes.setRightEyeLocation(rx, ry);
	}
}
