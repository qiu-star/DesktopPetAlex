package AlexMovement;

import AlexFrame.AlexFrame;

public class WagTail {
	private AlexFrame alexframe;
	private boolean ifpause;
	
	public WagTail(AlexFrame frame)
	{
		this.alexframe = frame;
		TailThread t = new TailThread(alexframe);
		t.start();
	}
	
	public void setIfPause(boolean flag)
	{
		this.ifpause = flag;
	}
	
	class TailThread extends Thread{
		private AlexFrame alexframe;
		
		public TailThread(AlexFrame alexframe)
		{
			this.alexframe = alexframe;
		}
		
		public void run()
		{
			int i = 1;
			try{
				while(true)
				{
					Thread.sleep(300);
					if(!ifpause)
					{
						alexframe.changeStatus("normal"+i+".png");
						i = (i+1)%3;
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
