package Main;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import AlexFrame.loadFrame;
import MouseHook.MouseLLHook;

public class main {

	
	public static void main(String[] args)  
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                loadFrame frame = new loadFrame();
            }
        });
		
//		MouseLLHook.main(args);
	}
}
