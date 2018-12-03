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
    //�����ק��Ҫ�ƶ���Ŀ�����
    AlexFrame alexframe;
    AlexMovement alexmovement;
    
    public MouseEventListener(AlexFrame frame, AlexMovement alexmovement) {
      this.alexframe = frame;
      this.alexmovement = alexmovement;
      origin = new Point();
    }
     
    @Override
    public void mouseClicked(MouseEvent e) {}
  
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
 
    private void waitToChange()
    {
		try
		{
		    Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
		    e.printStackTrace();
		}
	    alexframe.changeStatus("normal0.png");
//	    this.alexmovement.toSetIfPauseWagTail(false);
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
      //�����ȥ
      this.waitToChange();
    }
 
    /**
    * ����ƽ�������ʱ���������ͼ��Ϊ�ƶ�ͼ��
    */
    @Override
    public void mouseEntered(MouseEvent e) {
      Image image = new ImageIcon("cursor.png").getImage(); 
      Toolkit tk = Toolkit.getDefaultToolkit(); 
      Cursor cursor = tk.createCustomCursor(image, new Point(10, 10), "norm");
      this.alexframe.setCursor(cursor);
    }
     
    /**
    * ����Ƴ�������ʱ���������ͼ��ΪĬ��ָ��
    */
    @Override
    public void mouseExited(MouseEvent e) {
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
    }
 
    @Override
    public void mouseMoved(MouseEvent e) {}
     
  }
