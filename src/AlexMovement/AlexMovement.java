package AlexMovement;

import AlexFrame.AlexFrame;
import MouseHook.MouseLLHook;

public class AlexMovement {
	private AlexFrame alexframe;
	private WagTail wagTail;
	private MoveEyes moveEyes;
	
	public AlexMovement(AlexFrame frame)
	{
		this.alexframe = frame;
//		this.wagTail = new WagTail(alexframe);
		this.moveEyes = new MoveEyes(alexframe);
		MouseLLHook mouseHook = new MouseLLHook(moveEyes);
		new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				mouseHook.run();
//				int i=0;
				while (true) {
//					System.out.println(i++);
				}
			}
		}.start();
	}
	
//	public void toSetIfPauseWagTail(boolean flag)
//	{
//		this.wagTail.setIfPause(flag);
//	}
}
