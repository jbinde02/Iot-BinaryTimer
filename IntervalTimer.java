import java.util.Timer;

/**
 * This timer program is more of a stopwatch. It will start when the start button is pressed and will display the current
 * decimal and binary seconds in a window on the computer. It will also update the lights on the circuit created
 * with the Raspberry Pi.
 *
 * @author Jacob Binder
 * @version 1.0
 *
 */
public class IntervalTimer extends Timer{
    /**
    This constructor creates a new timer and its timer task. The timer runs every 1 second.
     */
    private IntervalTimer(){
        Timer timer = new Timer();
        Intervaler intervaler = new Intervaler();
        timer.schedule(intervaler, 1000, 1000);      
    }
    /**
    Starts everything.
     */
    public static void main(String[] args) {
        new IntervalTimer();
    }
}