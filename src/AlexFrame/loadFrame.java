package AlexFrame;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import AlexMovement.AlexMovement;

public class loadFrame {
	private AlexFrame alexframe; 
	private MoveFrame moveFrame;
	private AlexMovement alexMovement;
	
	public loadFrame()
	{
        this.alexframe = new AlexFrame();
        this.createAndShowGUI();

        this.alexMovement = new AlexMovement(alexframe);
        this.moveFrame = new MoveFrame(alexframe,alexMovement);
	}
	
	private void createAndShowGUI() {
        this.setTray();
    }
	

	private void setTray(){
		if(SystemTray.isSupported()){// 判断系统是否支持系统托盘
			SystemTray tray = SystemTray.getSystemTray(); // 获取当前系统的托盘
			
			// 为托盘添加一个右键弹出菜单
			PopupMenu popMenu = new PopupMenu();
			
			MenuItem itemOpen = new MenuItem("打开");
			itemOpen.addActionListener(e -> System.out.println("打开"));
			
			MenuItem itemExit = new MenuItem("退出");
			itemExit.addActionListener(e -> System.exit(0));
			
			popMenu.add(itemOpen);
			popMenu.add(itemExit);
 
			// 设置托盘图标
			ImageIcon icon = new ImageIcon("pic/Icon/trayIcon.png");
			Image image = icon.getImage().getScaledInstance(icon.getIconWidth(),icon.getIconHeight(), Image.SCALE_DEFAULT);
			
			TrayIcon trayIcon = new TrayIcon(image,"Alex",popMenu);
			trayIcon.setImageAutoSize(true); // 自适应尺寸，这个属性至关重要
			
			try {
				tray.add(trayIcon);
			} catch (AWTException e1) {
				e1.printStackTrace();
			}
		}
	}
}
