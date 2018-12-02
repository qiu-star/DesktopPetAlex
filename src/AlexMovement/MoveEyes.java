package AlexMovement;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import AlexFrame.AlexFrame;

public class MoveEyes {
	int lx,ly;
	int rx,ry;
	Eyes eyes;
	AlexFrame alexframe;
	
	public MoveEyes(AlexFrame alexframe){
		this.alexframe = alexframe;
		this.eyes = alexframe.getEyes();
		alexframe.addMouseListener(new MouseEyesListener());
	}
	
	class MouseEyesListener implements MouseInputListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			int R = 12;
			int x = arg0.getX();
			int y = arg0.getY();
			int X1 = eyes.getLeftEyeX();
			int Y1 = eyes.getLeftEyeY();
			int X2 = eyes.getRightEyeX();
			int Y2 = eyes.getRightEyeY();
			double a1 = Math.atan2(x-X1,y-Y1);
			double a2 = Math.atan2(x-X2,y-Y2);
			int lx = (int) (R*Math.sin(a1) + X1 -10);
			int ly = (int) (R*Math.cos(a1) + Y1 -10);
			int rx = lx + 60;
			int ry = (int) (R*Math.cos(a2) + Y2 -12);
			eyes.setLeftEyeLocation(lx, ly);
			eyes.setRightEyeLocation(rx, ry);
		}
		
	}
}
