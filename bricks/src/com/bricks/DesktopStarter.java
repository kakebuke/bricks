package com.bricks;

import com.badlogic.gdx.backends.jogl.JoglApplication;

public class DesktopStarter {
	public static void main(String[] args) {
		new JoglApplication(new Bricks(), "title",480, 320, true);
	}
	
}
