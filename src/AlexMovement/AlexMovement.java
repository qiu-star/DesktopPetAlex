package AlexMovement;

import AlexFrame.AlexFrame;

public class AlexMovement {
	private AlexFrame alexframe;
	private WagTail wagTail;
	
	public AlexMovement(AlexFrame frame)
	{
		this.alexframe = frame;
		this.wagTail = new WagTail(alexframe);
	}
	
	public void toSetIfPauseWagTail(boolean flag)
	{
		this.wagTail.setIfPause(flag);
	}
}
