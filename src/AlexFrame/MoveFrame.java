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


public class MoveFrame extends JWindow{
	AlexFrame alexframe;
	
	public MoveFrame(AlexFrame jframe)
	{
		this.alexframe = jframe;
		// Û±ÍÕœ∂Ø
		addMouse();
	}
	
	private void addMouse()
	{
		MouseEventListener mouselisten = new MouseEventListener(alexframe);
		this.alexframe.addMouseListener(mouselisten);;
	}
	
	
}
