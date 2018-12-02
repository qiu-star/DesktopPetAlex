package AlexFrame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.MouseInputListener;

import AlexMovement.Eyes;


public class AlexFrame{
	private JFrame frame;
	private JLabel alex;
	private Eyes eyes;
	private int iconWidth;
	private int iconHeight;
	
	public AlexFrame()
	{
		this.frame = new JFrame();
		this.frame.setLayout(null);
		this.eyes = new Eyes();
		this.alex = new JLabel();
		this.cgJLabelImg("normal0.png");
		this.tosetLocation(this.togetX(), this.togetY());
		frame.getContentPane().add(alex);
		frame.getContentPane().add(eyes.getLeftEye());
		frame.getContentPane().add(eyes.getRightEye());
		this.initFrame();
	}
	
	private void initFrame()
	{
		this.frame.setType(JFrame.Type.UTILITY);
        this.frame.setAlwaysOnTop(true);
        this.frame.setUndecorated(true);
		this.frame.setBackground(new Color(0,0,0,0));
        
        
        // ��ʾ����
//        this.frame.pack();
		this.frame.setSize(this.iconWidth, this.iconHeight);
        this.frame.setVisible(true);
	}
	
	private int togetX()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //�õ���Ļ�ĳߴ�
		int x = screenSize.width-iconWidth;
		return x;
	}
	
	private int togetY()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //�õ���Ļ�ĳߴ�
		int y = screenSize.height-iconHeight;
		return y;
	}
	
	public void changeStatus(String imgUrl)
	{
		this.cgJLabelImg(imgUrl);
	}
	
	private void tosetLocation(int x, int y)
	{
		frame.setLocation(x, y);
	}
	
	private void cgJLabelImg(String imgUrl){
		ImageIcon icon = new ImageIcon(imgUrl);
		int picWidth = icon.getIconWidth(),pinHeight = icon.getIconHeight();
		this.iconWidth = picWidth;
		this.iconHeight = pinHeight;
		icon.setImage(icon.getImage().getScaledInstance(picWidth,pinHeight, Image.SCALE_DEFAULT));
		alex.setBounds(0,0,picWidth,pinHeight);
		alex.setIcon(icon);
	}
	
//	public void addMouseListener(MouseEventListener mouselisten)
//	{
//		this.frame.addMouseListener(mouselisten);
//		this.frame.addMouseMotionListener(mouselisten);
//	}
	
	public void setCursor(Cursor cursor)
	{
		this.frame.setCursor(cursor);
	}
	
	public Point getLocation()
	{
		return this.frame.getLocation();
	}
	
	public void setLocation(int x, int y)
	{
		this.frame.setLocation(x, y); 
	}

	public void addMouseListener(MouseInputListener mouseEyesListener) {
		// TODO Auto-generated method stub
		this.frame.addMouseListener(mouseEyesListener);
		this.frame.addMouseMotionListener(mouseEyesListener);
	}
	
	public Eyes getEyes()
	{
		return this.eyes;
	}
}
