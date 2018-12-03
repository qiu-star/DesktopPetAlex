package MouseHook;


import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;

import com.sun.jna.platform.win32.*;
import com.sun.jna.platform.win32.WinUser.*;
import com.sun.jna.platform.win32.WinDef.HMODULE;
import com.sun.jna.platform.win32.WinDef.LRESULT;
import com.sun.jna.platform.win32.WinDef.WPARAM;
import com.sun.jna.platform.win32.WinUser.HHOOK;
import com.sun.jna.platform.win32.WinUser.KBDLLHOOKSTRUCT;
import com.sun.jna.platform.win32.WinUser.LowLevelKeyboardProc;

import AlexMovement.MoveEyes;

public class MouseLLHook {
	MoveEyes moveEyes;
	
   // 鼠标钩子函数里判断按键类型的常数
   public static final int WM_LBUTTONUP = 514;
   public static final int WM_LBUTTONDOWN = 513;
   public static final int WM_RBUTTONUP = 517;
   public static final int WM_RBUTTONDOWN = 516;
   public static final int WM_MOUSEHWHEEL = 526;
   public static final int WM_MOUSEWHEEL = 522;
   public static final int WM_MOUSEMOVE = 512;
    
   static HHOOK mouseHHK;//鼠标、键盘钩子的句柄
   static LowLevelMouseProc mouseHook;//鼠标钩子函数
    
   public MouseLLHook(MoveEyes moveEyes)
   {
	   this.moveEyes = moveEyes;
   }
   
   // 安装钩子
   static void setHook() {
       HMODULE hMod = Kernel32.INSTANCE.GetModuleHandle(null);
       mouseHHK = User32.INSTANCE.SetWindowsHookEx(WinUser.WH_MOUSE_LL, mouseHook, hMod, 0);     
   }
    
   //卸载钩子
   static void unhook() {
       User32.INSTANCE.UnhookWindowsHookEx(mouseHHK);      
   }
    
   public void run() {
       mouseHook = new LowLevelMouseProc() {
            
           @Override
           public LRESULT callback(int nCode, WPARAM wParam, MOUSEHOOKSTRUCT lParam) {
               switch (wParam.intValue()) {
               case WM_MOUSEMOVE:
                   PointerInfo pinfo = MouseInfo.getPointerInfo();
                   Point p = pinfo.getLocation();
                   int mx = (int) p.getX();
                   int my = (int) p.getY();
                   moveEyes.setCursorLocation(mx, my);
                   break;              
               }
//               System.out.println("("+lParam.pt.x+","+lParam.pt.y+")");
               return User32.INSTANCE.CallNextHookEx(mouseHHK, nCode, wParam, lParam.getPointer());
           }
       };
       setHook();      
                
       int result;
       MSG msg = new MSG();
       // 消息循环
       // 实际上while循环一次都不执行，这些代码的作用我理解是让程序在GetMessage函数这里阻塞，不然程序就结束了。
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
