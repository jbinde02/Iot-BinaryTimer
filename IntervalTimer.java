import java.util.Timer;

public class IntervalTimer extends Timer{
    Timer timer;
    Intervaler intervaler;
    public IntervalTimer(){
        timer = new Timer();
        intervaler = new Intervaler();
        timer.schedule(intervaler, 1000);
    }
    public static void main(String[] args) {
        System.out.println("Hello World");
        new IntervalTimer();
    }
}