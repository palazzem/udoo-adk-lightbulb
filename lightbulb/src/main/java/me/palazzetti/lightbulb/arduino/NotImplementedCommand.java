package me.palazzetti.lightbulb.arduino;

/**
 * Exception when a not implemented command is launched to Arduino.
 */
public class NotImplementedCommand extends Exception {
    public NotImplementedCommand() {}
    public NotImplementedCommand(String message) {
        super(message);
    }
}
