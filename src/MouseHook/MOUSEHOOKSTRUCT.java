package MouseHook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;
import com.sun.jna.platform.win32.BaseTSD.ULONG_PTR;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.LRESULT;
import com.sun.jna.platform.win32.WinDef.WPARAM;
import com.sun.jna.platform.win32.WinUser.HOOKPROC;
import com.sun.jna.platform.win32.WinUser.POINT;

public class MOUSEHOOKSTRUCT extends Structure{
	public class ByReference extends MOUSEHOOKSTRUCT implements
    Structure.ByReference {
	};
	
	public POINT pt;
	public HWND hwnd;
	public int wHitTestCode;
	public ULONG_PTR dwExtraInfo;
	@Override
	protected List getFieldOrder() {
		// TODO Auto-generated method stub
		return Arrays.asList("dwExtraInfo","hwnd","pt","wHitTestCode");
	}
}
