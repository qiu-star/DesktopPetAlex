package MouseHook;


import com.sun.jna.platform.win32.*;
import com.sun.jna.platform.win32.WinUser.*;
import com.sun.jna.platform.win32.WinDef.HMODULE;
import com.sun.jna.platform.win32.WinDef.LRESULT;
import com.sun.jna.platform.win32.WinDef.WPARAM;
import com.sun.jna.platform.win32.WinUser.HHOOK;
import com.sun.jna.platform.win32.WinUser.KBDLLHOOKSTRUCT;
import com.sun.jna.platform.win32.WinUser.LowLevelKeyboardProc;

public class MouseLLHook {
   
   // ��깳�Ӻ������жϰ������͵ĳ���
   public static final int WM_LBUTTONUP = 514;
   public static final int WM_LBUTTONDOWN = 513;
   public static final int WM_RBUTTONUP = 517;
   public static final int WM_RBUTTONDOWN = 516;
   public static final int WM_MOUSEHWHEEL = 526;
   public static final int WM_MOUSEWHEEL = 522;
   public static final int WM_MOUSEMOVE = 512;
    
   static HHOOK mouseHHK,keyboardHHK;//��ꡢ���̹��ӵľ��
   static LowLevelMouseProc mouseHook;//��깳�Ӻ���
   static LowLevelKeyboardProc keyboardHook;//���̹��Ӻ���
    
   // ��װ����
   static void setHook() {
       HMODULE hMod = Kernel32.INSTANCE.GetModuleHandle(null);
       mouseHHK = User32.INSTANCE.SetWindowsHookEx(WinUser.WH_MOUSE_LL, mouseHook, hMod, 0);
       keyboardHHK = User32.INSTANCE.SetWindowsHookEx(WinUser.WH_KEYBOARD_LL, keyboardHook, hMod, 0);       
   }
    
   //ж�ع���
   static void unhook() {
       User32.INSTANCE.UnhookWindowsHookEx(keyboardHHK);
       User32.INSTANCE.UnhookWindowsHookEx(mouseHHK);      
   }
    
   public static void main(String[] args) {
        
       keyboardHook = new LowLevelKeyboardProc() {
            
           @Override
           //�ú�����������˼�ο���http://msdn.microsoft.com/en-us/library/windows/desktop/ms644985(v=vs.85).aspx
           public LRESULT callback(int nCode, WPARAM wParam, KBDLLHOOKSTRUCT lParam) {
               int w = wParam.intValue();
               //����alt��ʱw=.WM_SYSKEYDOWN; ���������󲿷ּ�ʱw=WinUser.WM_KEYDOWN
               if(w==WinUser.WM_KEYDOWN || w==WinUser.WM_SYSKEYDOWN)
                   System.out.println("key down: vkCode = "+lParam.vkCode);
               else if(w==WinUser.WM_KEYUP || w==WinUser.WM_SYSKEYUP)
                   System.out.println("key up: vkCode = "+lParam.vkCode);
                
               // �������'q'�˳�����'q'��vkCode��81
               if(lParam.vkCode==81) { 
                   unhook();
                   System.err.println("program terminated.");
                   System.exit(0);
               }
               return User32.INSTANCE.CallNextHookEx(keyboardHHK, nCode, wParam, lParam.getPointer());
           }
       };
        
       mouseHook = new LowLevelMouseProc() {
            
           @Override
           //�ú�����������˼�ο���http://msdn.microsoft.com/en-us/library/windows/desktop/ms644986(v=vs.85).aspx
           public LRESULT callback(int nCode, WPARAM wParam, MOUSEHOOKSTRUCT lParam) {
               switch (wParam.intValue()) {
               case WM_MOUSEMOVE:
                   System.out.print("mouse moved:");
                   break;
               case WM_LBUTTONDOWN:
                   System.out.print("mouse left button down:");
                   break;
               case WM_LBUTTONUP:
                   System.out.print("mouse left button up");
                   break;
               case WM_RBUTTONUP:
                   System.out.print("mouse right button up:");
                   break;
               case WM_RBUTTONDOWN:
                   System.out.print("mouse right button down:");
                   break;
               case WM_MOUSEWHEEL:
                   System.out.print("mouse wheel rotated:");
                   break;              
               }
               System.out.println("("+lParam.pt.x+","+lParam.pt.y+")");
               return User32.INSTANCE.CallNextHookEx(mouseHHK, nCode, wParam, lParam.getPointer());
           }
       };
        
       System.out.println("press 'q' to quit.");
       setHook();      
                
       int result;
       MSG msg = new MSG();
       // ��Ϣѭ��
       // ʵ����whileѭ��һ�ζ���ִ�У���Щ�����������������ó�����GetMessage����������������Ȼ����ͽ����ˡ�
       while ((result = User32.INSTANCE.GetMessage(msg, null, 0, 0)) != 0) {           
           if (result == -1) {
               System.err.println("error in GetMessage");
               unhook();
               break;
           } else {
               User32.INSTANCE.TranslateMessage(msg);                
               User32.INSTANCE.DispatchMessage(msg);
           }
       }
       unhook();
   }    
    
    
}
