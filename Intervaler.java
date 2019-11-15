import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Intervaler extends TimerTask{

    int currentSeconds;
    int currentMinutes;
    boolean isRunning;

    JFrame frame;
    JPanel panel;
    JButton button1, button2;
    JTextArea area;
    ButtonListener buttonListener;
    Intervaler intervaler;

    public Intervaler(){
        currentSeconds = 0;
        currentMinutes = 0;
        isRunning = false;
        //Creates the frame
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
        panel = new JPanel();
        frame.add(panel);
        buttonListener = new ButtonListener(this);
        //Start/Stop button
        button1 = new JButton("Start/Stop");
        panel.add(button1);
        button1.addActionListener(buttonListener);
        //Clear Timer Button
        button2 = new JButton("Clear");       
        panel.add(button2);
        button2.addActionListener(buttonListener);
        
        area = new JTextArea(5, 20);
        panel.add(area);
    }
    public void run(){
        if(isRunning){
            if(currentSeconds<60){
                currentSeconds++;
            }else{
                currentSeconds = 0;
                currentMinutes++;
            }
        }
        //System.out.println(currentSeconds);
        //This long thing sets the text area with the current mintues and seconds.
        area.setText(Integer.toString(currentMinutes) + " : " + Integer.toString(currentSeconds));    
    }
    public void setRunning(boolean isRunning){
        this.isRunning = isRunning;
    }
    public void setCurrentSeconds(int currentSeconds){
        this.currentSeconds = currentSeconds;
    }

    public void handleButtonPress(Object src){
        //Start/Stop button
        if(src == button1 && isRunning){          
            isRunning = false;
            area.append(" Stopped! ");
        }else if(src == button1 && !isRunning){
            isRunning = true;
            area.append(" Started! ");
        }

        if(src == button2){
            area.setText("Cleared");
            currentSeconds = 0;
            currentMinutes = 0;
        }
    }
}
