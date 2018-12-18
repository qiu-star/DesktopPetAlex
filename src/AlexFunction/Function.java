package AlexFunction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

public class Function {
	private JButton onLive;
	
	public Function(JButton onLive)
	{
		this.onLive = onLive;
		this.toSetOnLiveAction();
		
	}
	
	private void toSetOnLiveAction()
	{
		this.onLive.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler https://www.zhanqi.tv/873061235");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
