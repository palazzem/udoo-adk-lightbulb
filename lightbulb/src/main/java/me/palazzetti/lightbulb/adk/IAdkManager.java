package me.palazzetti.lightbulb.adk;

import android.hardware.usb.UsbAccessory;

/**
 * Defines ADK interfaces
 */

public interface IAdkManager {
    void openAccessory(UsbAccessory usbAccessory);
    void closeAccessory();
    void readText();
    void sendText(String text);

    // Activity related interfaces
    void closeAdk();
    void resumeAdk();
}
