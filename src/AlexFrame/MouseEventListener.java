package AlexFrame;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.event.MouseInputListener;

import AlexMovement.AlexMovement;

public class MouseEventListener implements MouseInputListener {
    
    Point origin;
    

    private boolean talkflag = false;
    private boolean moveflag = false;
//    boolean functionflag = false;
    //�����ק��Ҫ�ƶ���Ŀ�����
    AlexFrame alexframe;
    AlexMovement alexmovement;
    
    public MouseEventListener(AlexFrame frame, AlexMovement alexmovement) {
      this.alexframe = frame;
      this.alexmovement = alexmovement;
      origin = new Point();
    }
     
    @Override
    public void mouseClicked(MouseEvent e) {
//    	final MouseEvent me = e;
    	this.talkflag = true;
    	alexframe.toSetTalk(true);
		alexframe.toShowTalk();
//    	this.clickflag = false;
//    	
//    	if(this.clickNum == 1)
//    	{
//    		functionflag = true;
//    		this.alexframe.toSetTalk(false);
//    		this.alexframe.toShowFuntion(true);
//    		
//    		this.clickNum = 0;
//    		this.clickflag = true;
//    		return;
//    	}
    	
//    	java.util.Timer timer = new java.util.Timer();
//    	
//    	timer.schedule(new java.util.TimerTask() {
//    		private int n = 0;
//    		public void run() {
//    			if(clickflag)
//    			{
//    				n = 0;
//    				clickNum = 0;
//    				this.cancel();
//    				return;
//    			}
//    			if(n == 1 && functionflag == false) {
//    				talkflag = true;
//    	    		alexframe.toSetTalk(true);
//    	    		alexframe.toShowTalk();
//    	    		clickflag = true;
//    	    		clickNum = 0;
//    	    		this.cancel();
//    	    		return;
//    			}
//    			clickNum++;
//    			n++;
//    		}
//    	}, new java.util.Date(),200);
    }
  
    /**
    * ��¼��갴��ʱ�ĵ�
    */
    @Override
    public void mousePressed(MouseEvent e) {
      origin.x = e.getX(); 
      origin.y = e.getY();
      //���ͼ��
//      this.alexmovement.toSetIfPauseWagTail(true);
      alexframe.changeStatus("click.png");
    }
 
    private void waitToChange(int time)
    {
		try
		{
		    Thread.sleep(time);
		}
		catch (InterruptedException e)
		{
		    e.printStackTrace();
		}
		alexframe.changeStatus("normal1.png");
//	    System.out.print("Y");
//	    this.alexmovement.toSetIfPauseWagTail(false);
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {}
 
    /**
    * ����ƽ�������ʱ���������ͼ��Ϊ�ƶ�ͼ��
    */
    @Override
    public void mouseEntered(MouseEvent e) {
		Image image = new ImageIcon("pic/Icon/cursor.png").getImage(); 
		Toolkit tk = Toolkit.getDefaultToolkit(); 
		Cursor cursor = tk.createCustomCursor(image, new Point(10, 10), "norm");
		this.alexframe.setCursor(cursor);
    }
     
    /**
    * ����Ƴ�������ʱ���������ͼ��ΪĬ��ָ��
    */
    @Override
    public void mouseExited(MouseEvent e) {
      if(talkflag)
      {
    	  this.waitToChange(3000);
    	  //�����ȥ
	      this.alexframe.toSetTalk(false);
	      //      this.alexframe.togetMusic().setVisible(false);
	      this.talkflag = false;
      }
      else if(moveflag)
      {
    	  this.waitToChange(1000);
    	  this.moveflag = false;
    	  this.alexframe.toSetTalk(false);
      }
//      if(functionflag)
//      {
//    	  //�����ȥ
//	      this.waitToChange(3000);
//	      this.alexframe.toShowFuntion(false);
//	      //      this.alexframe.togetMusic().setVisible(false);
//	      this.functionflag = false;
//      }
      this.alexframe.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
 
    /**
    * ����ڱ�������קʱ�����ô��ڵ�����λ��
    * �����µ�����λ�� = �ƶ�ǰ����λ��+�����ָ�뵱ǰ����-��갴��ʱָ���λ�ã�
    */
    @Override
    public void mouseDragged(MouseEvent e) {
    	
      Point p = this.alexframe.getLocation();
      this.alexframe.setLocation(
        p.x + (e.getX() - origin.x), 
        p.y + (e.getY() - origin.y)); 
  	this.moveflag = true;
    }
 
    @Override
    public void mouseMoved(MouseEvent e) {}
     
  }
