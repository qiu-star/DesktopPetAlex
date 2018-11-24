package AlexFrame;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

import AlexMovement.AlexMovement;


public class MoveFrame extends JWindow{
	AlexFrame alexframe;
	AlexMovement alexmovement;
	public MoveFrame(AlexFrame jframe, AlexMovement alexmovement)
	{
		this.alexframe = jframe;
		this.alexmovement = alexmovement;
		// Û±ÍÕœ∂Ø
		addMouse();
	}
	
	private void addMouse()
	{
		MouseEventListener mouselisten = new MouseEventListener(alexframe,alexmovement);
		this.alexframe.addMouseListener(mouselisten);;
	}
	
	
}
