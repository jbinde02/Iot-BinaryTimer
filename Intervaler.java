import java.util.TimerTask;

public class Intervaler extends TimerTask{

    int currentSeconds;
    int currentMinutes;
    boolean running;
    TimerWindow timerWindow;

    public Intervaler(){
        currentSeconds = 0;
        currentMinutes = 0;
        running = true;
        timerWindow = new TimerWindow();
    }
    public void run(){
        if(running = true){
        if(currentSeconds<60){
            currentSeconds++;
        }else{
            currentSeconds = 0;
            currentMinutes++;
        }
        System.out.println(currentSeconds);
        //This long thing sets the text area with the current mintues and seconds.
        timerWindow.area.setText(Integer.toString(currentMinutes) + " Mintues" + Integer.toString(currentSeconds) + " Seconds");
        }
    }
    public void setRunning(boolean running){
        this.running = running;
    }
    public void setCurrentSeconds(int currentSeconds){
        this.currentSeconds = currentSeconds;
    }
}
