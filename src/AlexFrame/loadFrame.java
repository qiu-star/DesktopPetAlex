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
		if(SystemTray.isSupported()){// �ж�ϵͳ�Ƿ�֧��ϵͳ����
			SystemTray tray = SystemTray.getSystemTray(); // ��ȡ��ǰϵͳ������
			
			// Ϊ�������һ���Ҽ������˵�
			PopupMenu popMenu = new PopupMenu();
			
			MenuItem itemOpen = new MenuItem("��");
			itemOpen.addActionListener(e -> System.out.println("��"));
			
			MenuItem itemExit = new MenuItem("�˳�");
			itemExit.addActionListener(e -> System.exit(0));
			
			popMenu.add(itemOpen);
			popMenu.add(itemExit);
 
			// ��������ͼ��
			ImageIcon icon = new ImageIcon("pic/Icon/trayIcon.png");
			Image image = icon.getImage().getScaledInstance(icon.getIconWidth(),icon.getIconHeight(), Image.SCALE_DEFAULT);
			
			TrayIcon trayIcon = new TrayIcon(image,"Alex",popMenu);
			trayIcon.setImageAutoSize(true); // ����Ӧ�ߴ磬�������������Ҫ
			
			try {
				tray.add(trayIcon);
			} catch (AWTException e1) {
				e1.printStackTrace();
			}
		}
	}
}
