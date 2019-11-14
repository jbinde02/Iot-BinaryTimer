import java.util.TimerTask;

public class Intervaler extends TimerTask{
    int currentSeconds;
    public Intervaler(){
        currentSeconds = 0;
    }
     public void run(){
        currentSeconds++;
        System.out.println(currentSeconds);
    }
}