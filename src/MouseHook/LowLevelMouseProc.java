package MouseHook;

import com.sun.jna.Structure;
import com.sun.jna.platform.win32.BaseTSD.ULONG_PTR;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.LRESULT;
import com.sun.jna.platform.win32.WinDef.WPARAM;
import com.sun.jna.platform.win32.WinUser.HOOKPROC;
import com.sun.jna.platform.win32.WinUser.POINT;

public interface LowLevelMouseProc extends HOOKPROC{
	LRESULT callback(int nCode, WPARAM wParam, MOUSEHOOKSTRUCT lParam);
}
