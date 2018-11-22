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
		//����϶�
		addMouse();
	}
	
	private void addMouse()
	{
		MouseEventListener mouselisten = new MouseEventListener(alexframe);
		this.alexframe.addMouseListener(mouselisten);
	}
	
	class MouseEventListener implements MouseInputListener {
	     
	    Point origin;
	    //�����ק��Ҫ�ƶ���Ŀ�����
	    AlexFrame alexframe;
	    
	    public MouseEventListener(AlexFrame frame) {
	      this.alexframe = frame;
	      origin = new Point();
	    }
	     
	    @Override
	    public void mouseClicked(MouseEvent e) {}
	    
	    private void cgJLabelImg(JLabel jLabel,String imgUrl){
			ImageIcon icon = new ImageIcon(imgUrl);
			int picWidth = icon.getIconWidth(),pinHeight = icon.getIconHeight();
			icon.setImage(icon.getImage().getScaledInstance(picWidth,pinHeight, Image.SCALE_DEFAULT));
			jLabel.setBounds(0,0,picWidth,pinHeight);
			jLabel.setIcon(icon);
		}
	    
	    /**
	    * ��¼��갴��ʱ�ĵ�
	    */
	    @Override
	    public void mousePressed(MouseEvent e) {
	      origin.x = e.getX(); 
	      origin.y = e.getY();
	      //���ͼ��
	      alexframe.changeStatus("click.png");
	    }
	 
	    @Override
	    public void mouseReleased(MouseEvent e) {
	      //�����ȥ
	      alexframe.changeStatus("normal.png");
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
}
