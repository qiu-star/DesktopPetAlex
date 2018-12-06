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
    boolean flag = false;
    //鼠标拖拽想要移动的目标组件
    AlexFrame alexframe;
    AlexMovement alexmovement;
    
    public MouseEventListener(AlexFrame frame, AlexMovement alexmovement) {
      this.alexframe = frame;
      this.alexmovement = alexmovement;
      origin = new Point();
    }
     
    @Override
    public void mouseClicked(MouseEvent e) {
    	if(e.getClickCount() == 1)
    	{
    		this.alexframe.toSetTalk(true);
    		this.alexframe.toShowTalk();
    		
    	}
    	else if(e.getClickCount() == 2)
    	{
//    	      this.alexframe.togetMusic().setVisible(true);
    	}
    }
  
    /**
    * 记录鼠标按下时的点
    */
    @Override
    public void mousePressed(MouseEvent e) {
      origin.x = e.getX(); 
      origin.y = e.getY();
      //变更图标
//      this.alexmovement.toSetIfPauseWagTail(true);
      alexframe.changeStatus("click.png");
      this.flag = true;
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
    * 鼠标移进标题栏时，设置鼠标图标为移动图标
    */
    @Override
    public void mouseEntered(MouseEvent e) {
		Image image = new ImageIcon("pic/Icon/cursor.png").getImage(); 
		Toolkit tk = Toolkit.getDefaultToolkit(); 
		Cursor cursor = tk.createCustomCursor(image, new Point(10, 10), "norm");
		this.alexframe.setCursor(cursor);
    }
     
    /**
    * 鼠标移出标题栏时，设置鼠标图标为默认指针
    */
    @Override
    public void mouseExited(MouseEvent e) {
      if(flag)
      {
    	  //变更回去
	      this.waitToChange(3000);
	      this.alexframe.toSetTalk(false);
	      this.alexframe.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	      //      this.alexframe.togetMusic().setVisible(false);
	      this.flag = false;
      }
    }
 
    /**
    * 鼠标在标题栏拖拽时，设置窗口的坐标位置
    * 窗口新的坐标位置 = 移动前坐标位置+（鼠标指针当前坐标-鼠标按下时指针的位置）
    */
    @Override
    public void mouseDragged(MouseEvent e) {
      Point p = this.alexframe.getLocation();
      this.alexframe.setLocation(
        p.x + (e.getX() - origin.x), 
        p.y + (e.getY() - origin.y)); 
    }
 
    @Override
    public void mouseMoved(MouseEvent e) {}
     
  }
