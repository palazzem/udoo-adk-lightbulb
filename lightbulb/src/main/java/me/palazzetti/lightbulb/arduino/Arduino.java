package me.palazzetti.lightbulb.arduino;

import me.palazzetti.adktoolkit.AdkManager;

/**
 * Implements Arduino commands interface
 */
public class Arduino {
    public static void command(AdkManager adkManager, int command) throws NotImplementedCommand {
        switch (command) {
            case 0:
                bulbOff(adkManager);
                break;
            case 1:
                bulbOn(adkManager);
                break;
            default:
                throw new NotImplementedCommand("This command is not available");
        }
    }

    private static void bulbOff(AdkManager adkManager) {
        adkManager.writeSerial("0");
    }

    private static void bulbOn(AdkManager adkManager) {
        adkManager.writeSerial("1");
    }
}
