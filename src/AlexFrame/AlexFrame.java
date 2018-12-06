package AlexFrame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.List;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import AlexMovement.Eyes;


public class AlexFrame{
	private JFrame frame;
	private JPanel AlexPanel;
	private JLabel alex;
	private Eyes eyes;
	
	private JPanel FunctionPanel;
	private JLabel music;
	
	private JPanel TalkPanel;
	private JLabel dialog;
	
	private int iconWidth;
	private int iconHeight;
	private int menuWidth;
	private int menuHeight;
	private int dialogWidth;
	private int dialogHeight;
	
	public AlexFrame()
	{
		this.frame = new JFrame();
		this.frame.setLayout(null);
		
		this.toMakeAlexPanel();
		this.toMakeFunctionPanel();
		this.toMakeTalkPanel();
		
		this.tosetLocation(this.togetX(), this.togetY()-80);

		frame.getContentPane().add(TalkPanel);
		frame.getContentPane().add(this.AlexPanel);
		
//		frame.getContentPane().add(this.FunctionPanel);
		this.initFrame();
	}
	
	private void toMakeTalkPanel()
	{
		this.TalkPanel = new JPanel();
		this.TalkPanel.setLayout(null);
		this.TalkPanel.setBackground(new Color(0,0,0,0));
		
		this.dialog = new JLabel();
		ArrayList<Integer> size = this.cgJLabelImg(dialog, "pic/Icon/气泡1.png", 0, 0);
		this.dialogWidth = size.get(0);
		this.dialogHeight = size.get(1);
		
		this.TalkPanel.setSize(200,110);
		this.TalkPanel.setLocation(0, 0);
		this.TalkPanel.add(dialog);
		this.TalkPanel.setVisible(false);
	}
	
	public void toSetTalk(boolean flag)
	{
		this.TalkPanel.setVisible(flag);
	}
	
	private void toMakeFunctionPanel()
	{
		this.FunctionPanel = new JPanel();
		this.FunctionPanel.setLayout(null);
		this.FunctionPanel.setBackground(new Color(0,0,0,0));
		
		this.music = new JLabel();
		this.cgJLabelImg(music,"pic/Icon/备忘录.png",230, 145);
		
		
		this.FunctionPanel.setSize(60,250);
		this.FunctionPanel.add(music);
	}
	
	private void toMakeAlexPanel()
	{
		this.AlexPanel = new JPanel();
		this.AlexPanel.setLayout(null);
		this.AlexPanel.setBackground(new Color(0,0,0,0));
		
		this.eyes = new Eyes();
		this.alex = new JLabel();
		this.cgJLabelImg("normal1.png");
		
		this.AlexPanel.setSize(this.iconWidth,this.iconHeight);
		this.AlexPanel.add(alex);
		this.AlexPanel.setLocation(0, 100);
		this.AlexPanel.add(eyes.getLeftEye());
		this.AlexPanel.add(eyes.getRightEye());
	}
	
	private void cgJLabelImg(String imgUrl){
		ImageIcon icon = new ImageIcon("pic/Status/"+imgUrl);
		int picWidth = icon.getIconWidth(),pinHeight = icon.getIconHeight();
		this.iconWidth = picWidth;
		this.iconHeight = pinHeight;
		icon.setImage(icon.getImage().getScaledInstance(picWidth,pinHeight, Image.SCALE_DEFAULT));
		alex.setBounds(0,0,picWidth,pinHeight);
		alex.setIcon(icon);
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
	
	private void initFrame()
	{
		this.frame.setType(JFrame.Type.UTILITY);
        this.frame.setAlwaysOnTop(true);
        this.frame.setUndecorated(true);
		this.frame.setBackground(new Color(0,0,0,0));
        
        
        // 显示窗口
//        this.frame.pack();
		this.frame.setSize(this.iconWidth+50, this.iconHeight+100);
        this.frame.setVisible(true);
	}
	
	private int togetX()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //得到屏幕的尺寸
		int x = screenSize.width-iconWidth;
		return x;
	}
	
	private int togetY()
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //得到屏幕的尺寸
		int y = screenSize.height-iconHeight;
		return y;
	}
	
	public void changeStatus(String imgUrl)
	{
		this.cgJLabelImg(imgUrl);
		this.frame.repaint();
	}
	
	private void tosetLocation(int x, int y)
	{
		frame.setLocation(x, y);
	}
	
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

	public void AlexPanelAddMouseListener(MouseInputListener mouseListener) {
		// TODO Auto-generated method stub
		this.AlexPanel.addMouseListener(mouseListener);
		this.AlexPanel.addMouseMotionListener(mouseListener);
	}
	
	public Eyes getEyes()
	{
		return this.eyes;
	}
}
