package AlexFunction;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class FunctionBubble {
	private JLabel bubble1;
	private JLabel bubble2;
	private JLabel bubble3;
	
	public FunctionBubble()
	{
		this.bubble1 = new JLabel();
		this.cgJLabelImg(bubble1, "pic/Icon/ÆøÅÝ4.png", 40, 95);
		this.bubble2 = new JLabel();
		this.cgJLabelImg(bubble2, "pic/Icon/ÆøÅÝ3.png", 50, 60);
		this.bubble3 = new JLabel();
		this.cgJLabelImg(bubble3, "pic/Icon/ÆøÅÝ2.png", 0, 0);
	}
	
	private ArrayList<Integer> cgJLabelImg(JLabel jLabel,String imgUrl,int x,int y){
		ArrayList<Integer> size = new ArrayList<Integer>();
		ImageIcon icon = new ImageIcon(imgUrl);
		int picWidth = icon.getIconWidth(),pinHeight = icon.getIconHeight();
		size.add(picWidth);
		size.add(pinHeight);
		icon.setImage(icon.getImage().getScaledInstance(picWidth,pinHeight, Image.SCALE_DEFAULT));
		jLabel.setBounds(x,y,picWidth,pinHeight);
		jLabel.setIcon(icon);
		return size;
	}
	
	public JLabel getBubble1()
	{
		return this.bubble1;
	}
	
	public JLabel getBubble2()
	{
		return this.bubble2;
	}
	
	public JLabel getBubble3()
	{
		return this.bubble3;
	}
}
