package com.monstrous.app.lwjgl3;


import com.monstrous.app.Main;
import com.monstrous.gdx.webgpu.backends.desktop.WgDesktopApplication;
import com.monstrous.gdx.webgpu.backends.desktop.WgDesktopApplicationConfiguration;


public class Launcher {
    public static void main (String[] argv) {

        WgDesktopApplicationConfiguration config = new WgDesktopApplicationConfiguration();
        config.setWindowedMode(640, 480);
        config.setTitle("WebGPU");
        config.enableGPUtiming = false;
        config.useVsync(true);
        new WgDesktopApplication(new Main(), config);
    }
}
