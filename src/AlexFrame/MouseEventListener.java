package AlexFrame;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.event.MouseInputListener;

public class MouseEventListener implements MouseInputListener {
    
    Point origin;
    //鼠标拖拽想要移动的目标组件
    AlexFrame alexframe;
    
    public MouseEventListener(AlexFrame frame) {
      this.alexframe = frame;
      origin = new Point();
    }
     
    @Override
    public void mouseClicked(MouseEvent e) {}
  
    /**
    * 记录鼠标按下时的点
    */
    @Override
    public void mousePressed(MouseEvent e) {
      origin.x = e.getX(); 
      origin.y = e.getY();
      //变更图标
      alexframe.changeStatus("click.png");
    }
 
    private void waitToChange()
    {
    	Date d = new Date();
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
      //变更回去
      this.waitToChange();
      alexframe.changeStatus("normal.png");
    }
 
    /**
    * 鼠标移进标题栏时，设置鼠标图标为移动图标
    */
    @Override
    public void mouseEntered(MouseEvent e) {
      Image image = new ImageIcon("cursor.png").getImage(); 
      Toolkit tk = Toolkit.getDefaultToolkit(); 
      Cursor cursor = tk.createCustomCursor(image, new Point(10, 10), "norm");
      this.alexframe.setCursor(cursor);
    }
     
    /**
    * 鼠标移出标题栏时，设置鼠标图标为默认指针
    */
    @Override
    public void mouseExited(MouseEvent e) {
      this.alexframe.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
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
