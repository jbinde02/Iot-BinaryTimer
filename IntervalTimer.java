import java.util.Timer;
import java.util.TimerTask;

public class IntervalTimer extends Timer{
    Timer t;
    TimerTask tt;
    public IntervalTimer(){
        t = new Timer();
        t.schedule(tt, 1000);
    }
    public static void main(String[] args) {
        System.out.println("Hello World");
        IntervalTimer IT = new IntervalTimer();
    }
}