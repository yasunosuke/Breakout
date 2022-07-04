package com.breakout;

import com.sun.jna.Library;
import com.sun.jna.Native;

public interface CLibrary {
	CLibrary INSTANCE = (CLibrary)Native.loadLibrary("msvcrt", CLibrary.class);
	void printf(String format, Object... args);
}
