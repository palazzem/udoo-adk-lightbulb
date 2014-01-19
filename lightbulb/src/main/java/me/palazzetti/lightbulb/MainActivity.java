package me.palazzetti.lightbulb;

import me.palazzetti.lightbulb.adk.AdkManager;
import me.palazzetti.lightbulb.arduino.Arduino;
import me.palazzetti.lightbulb.arduino.NotImplementedCommand;

import android.app.Activity;
import android.content.Context;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Activity to control light bulb status
 */
public class MainActivity extends Activity {
    // Needed for UI
    private ImageView lightBulbView;

    // Needed for Adk and status switching
    private AdkManager mAdkManager;
    private boolean bulbStatus = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI references
        lightBulbView = (ImageView) findViewById(R.id.lightbulb);

        // Android ADK
        mAdkManager = new AdkManager((UsbManager) getSystemService(Context.USB_SERVICE));
        registerReceiver(mAdkManager.getUsbReceiver(), mAdkManager.getDetachedFilter());
    }

    @Override
    protected void onPause() {
        super.onPause();
        mAdkManager.closeAdk();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdkManager.resumeAdk();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mAdkManager.getUsbReceiver());
    }

    /**
     * Click listener for light bulb ImageView
     */

    public void switchLight(View v) {
        bulbStatus = !bulbStatus;

        try {
            int command = bulbStatus ? 1 : 0;
            int resourceImage = bulbStatus ? R.drawable.lightbulb : R.drawable.lightbulb_off;
            Arduino.command(mAdkManager, command);
            lightBulbView.setImageResource(resourceImage);
        } catch (NotImplementedCommand e) {
            e.printStackTrace();
        }
    }
}
