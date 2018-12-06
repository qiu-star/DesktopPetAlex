package Main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import AlexFrame.loadFrame;
import AlexTalk.AlexTalk;
import MouseHook.MouseLLHook;

public class main {
	public static void setUIFont()
	{
		Font f = new Font("ºÚÌå",Font.PLAIN,14);
		String   names[]={ "Label", "CheckBox", "PopupMenu","MenuItem", "CheckBoxMenuItem",
				"JRadioButtonMenuItem","ComboBox", "Button", "Tree", "ScrollPane",
				"TabbedPane", "EditorPane", "TitledBorder", "Menu", "TextArea",
				"OptionPane", "MenuBar", "ToolBar", "ToggleButton", "ToolTip",
				"ProgressBar", "TableHeader", "Panel", "List", "ColorChooser",
				"PasswordField","TextField", "Table", "Label", "Viewport",
				"RadioButtonMenuItem","RadioButton", "DesktopPane", "InternalFrame"
		}; 
		for (String item : names) {
			 UIManager.put(item+ ".font",f); 
		}
	}
	
	public static void main(String[] args)  
	{
		setUIFont();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                loadFrame frame = new loadFrame();
            }
        });
	}
}
