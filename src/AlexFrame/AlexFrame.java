package AlexFrame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.List;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.MouseInputListener;

import AlexFunction.Function;
import AlexFunction.FunctionBubble;
import AlexMovement.Eyes;
import AlexTalk.AlexTalk;


public class AlexFrame{
	private JFrame frame;
	private JPanel AlexPanel;
	private JLabel alex;
	private Eyes eyes;
	
	private JPanel FunctionPanel;
	private Function alexFunction;
//	private JPanel BubblePanel;
//	private FunctionBubble functionBubble;
//	private JButton music;
	private JButton onLive;
//	private JButton tieba;
//	private JButton weibo;
	
	private JPanel TalkPanel;
	private JLabel dialog;
	private JTextArea talk;
	private AlexTalk alexTalk;
	
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
		
		this.tosetLocation(this.togetX()-70, this.togetY()-80);

		frame.getContentPane().add(this.FunctionPanel);
		frame.getContentPane().add(TalkPanel);
		frame.getContentPane().add(this.AlexPanel);
		this.initFrame();
	}
	
	private void toMakeTalkPanel()
	{
		this.alexTalk = new AlexTalk();
		
		this.TalkPanel = new JPanel();
		this.TalkPanel.setLayout(null);
		this.TalkPanel.setBackground(new Color(0,0,0,0));
		
		this.dialog = new JLabel();
		ArrayList<Integer> size = this.cgJLabelImg(dialog, "pic/Icon/气泡1.png", 0, 0);
		this.dialogWidth = size.get(0);
		this.dialogHeight = size.get(1);
		
		this.talk = new JTextArea();
		this.talk.setBackground(new Color(0,0,0,0));
		this.talk.setForeground(Color.WHITE);
		this.talk.setSize(dialogWidth-100, dialogHeight);
		this.talk.setLineWrap(true);        //激活自动换行功能 
		this.talk.setWrapStyleWord(true);
		this.talk.setLocation(70, 25);
		
		this.TalkPanel.setSize(dialogWidth,dialogHeight);
		this.TalkPanel.setLocation(60, 0);
		this.TalkPanel.add(talk);
		this.TalkPanel.add(dialog);
		this.TalkPanel.setVisible(false);
	}
	
	public void toSetTalk(boolean flag)
	{
		this.TalkPanel.setVisible(flag);
	}
	
	public void toShowTalk()
	{
		this.talk.setText(null);
		this.TalkPanel.repaint();
		String str = this.alexTalk.toGetDialog();
		this.talk.setText(str);
	}
	
	private void toMakeFunctionPanel()
	{	
		this.FunctionPanel = new JPanel();
		this.FunctionPanel.setLayout(null);
		this.FunctionPanel.setBackground(new Color(0,0,0,0));
//		
//		this.BubblePanel = new JPanel();
//		this.BubblePanel.setLayout(null);
//		this.BubblePanel.setBackground(new Color(0,0,0,0));
//		
//		
//		
		this.onLive = new JButton();
		this.cgJLabelImg(onLive, "pic/Icon/阿旗.png", 0, 0,"pic/Icon/阿旗_.png");
		this.onLive.setToolTipText("阿旗");
		this.FunctionPanel.add(onLive);
//		this.music = new JButton();
//		this.cgJLabelImg(music, "pic/Icon/音乐.png", 120, 15);
//		this.music.setToolTipText("网易云");
//		
//		BubblePanel.add(onLive);
//		BubblePanel.add(music);
//		
		this.alexFunction = new Function(onLive);
//		
//		this.functionBubble = new FunctionBubble();
//		
//		BubblePanel.setSize(300,248);
//		
//		FunctionPanel.add(BubblePanel);
//		FunctionPanel.add(this.functionBubble.getBubble3());
//		FunctionPanel.add(this.functionBubble.getBubble1());
//		FunctionPanel.add(this.functionBubble.getBubble2());
//		
//		
		this.FunctionPanel.setBounds(0, 0, 200, 200);
//		
//		this.FunctionPanel.setVisible(false);
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
		this.AlexPanel.setLocation(60, 100);
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
	
	private ArrayList<Integer> cgJLabelImg(JButton jButton,String imgUrl,int x,int y,String imgUrl2){
		ArrayList<Integer> size = new ArrayList<Integer>();
		ImageIcon icon = new ImageIcon(imgUrl);
		int picWidth = icon.getIconWidth(),pinHeight = icon.getIconHeight();
		size.add(picWidth);
		size.add(pinHeight);
		icon.setImage(icon.getImage().getScaledInstance(picWidth,pinHeight, Image.SCALE_DEFAULT));
//		jButton.setBounds(x,y,picWidth,pinHeight);
		jButton.setSize(picWidth, pinHeight);
		jButton.setLocation(x, y);
		jButton.setIcon(icon);
//		ImageIcon icon = new ImageIcon(imgUrl);
		jButton.setRolloverIcon(new ImageIcon(imgUrl2));
		jButton.setMargin(new Insets(0,0,0,0));
		jButton.setContentAreaFilled(false);
		jButton.setBorderPainted(false);
		return size;
	}
	
//	public void toShowFuntion(boolean flag)
//	{
//		this.FunctionPanel.setVisible(flag);
//	}
	
	private void initFrame()
	{
		this.frame.setType(JFrame.Type.UTILITY);
        this.frame.setAlwaysOnTop(true);
        this.frame.setUndecorated(true);
		this.frame.setBackground(new Color(0,0,0,0));
        
        
        // 显示窗口
//        this.frame.pack();
		this.frame.setSize(this.iconWidth+1300, this.iconHeight+100);
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
