package AlexMovement;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Eyes {
	private JLabel lefteye;
	private JLabel righteye;
	private int lx=25,ly=53;
	private int rx=85,ry=55;
	
	public Eyes()
	{
		this.lefteye = new JLabel();
		this.cgJLabelImg(this.lefteye,this.lx,this.ly, "×óÑÛ.png");
		this.righteye = new JLabel();
		this.cgJLabelImg(this.righteye, this.rx, this.ry, "ÓÒÑÛ1.jpg");
	}
	
	private void cgJLabelImg(JLabel eye,int x,int y,String imgUrl){
		ImageIcon icon = new ImageIcon(imgUrl);
		int picWidth = icon.getIconWidth(),pinHeight = icon.getIconHeight();
		
		icon.setImage(icon.getImage().getScaledInstance(picWidth,pinHeight, Image.SCALE_DEFAULT));
		eye.setBounds(x,y,picWidth,pinHeight);
		eye.setIcon(icon);
	}
	
	public JLabel getLeftEye()
	{
		return this.lefteye;
	}
	
	public JLabel getRightEye()
	{
		return this.righteye;
	}
	
	public int getRightEyeX()
	{
		return this.rx;
	}
	
	public int getRightEyeY()
	{
		return this.ry;
	}
	
	public int getLeftEyeX()
	{
		return this.lx;
	}
	
	public int getLeftEyeY()
	{
		return this.ly;
	}
	
	public void setLeftEyeLocation(int x, int y)
	{
//		this.lx = x;
//		this.ly = y;
		this.lefteye.setLocation(x, y);

//		System.out.println("lx: "+this.lefteye.getX()+" ly: "+this.lefteye.getY());
	}
	
	public void setRightEyeLocation(int x, int y)
	{
//		this.rx = x;
//		this.ry = y;
		this.righteye.setLocation(x, y);
	}
}
