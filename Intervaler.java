import java.util.TimerTask;

public class Intervaler extends TimerTask{

    int currentSeconds;
    boolean running;

    public Intervaler(){
        currentSeconds = 0;
        running = true;
    }
    public void run(){
        if(running = true){}
        currentSeconds++;
        System.out.println(currentSeconds + " Seconds");
    }
}
