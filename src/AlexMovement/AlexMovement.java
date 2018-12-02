package AlexMovement;

import AlexFrame.AlexFrame;

public class AlexMovement {
	private AlexFrame alexframe;
	private WagTail wagTail;
	private MoveEyes moveEyes;
	
	public AlexMovement(AlexFrame frame)
	{
		this.alexframe = frame;
		this.wagTail = new WagTail(alexframe);
		this.moveEyes = new MoveEyes(alexframe);
	}
	
	public void toSetIfPauseWagTail(boolean flag)
	{
		this.wagTail.setIfPause(flag);
	}
}
