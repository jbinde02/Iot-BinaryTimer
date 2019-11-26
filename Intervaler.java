import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * This class does most of the work. It creates the window with its text area and buttons. It also has the current
 * decimal and binary time which will be updated every one second according to the Interval Timer class. Button presses
 * and text area updates are handled here.
 *
 * @author Jacob Binder
 * @version 1.0
 */
public class Intervaler extends TimerTask{
    int decimalSeconds;
    int decimalMinutes;
    String binarySeconds;
    String binaryMinutes;
    boolean isRunning;
    JFrame frame;
    JPanel panel;
    JButton button1, button2;
    JTextArea area;
    ButtonListener buttonListener;
    Intervaler intervaler;
    PiControlGpio controlGpio;
    /**
     * This constructor will create the items for the window and set the timers current interval to 0.
     */
    public Intervaler(){
        decimalSeconds = 0;
        decimalMinutes = 0;
        binarySeconds = "";
        binaryMinutes = "";
        isRunning = false;
        controlGpio = new PiControlGpio();
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
        //Creates the text area
        area = new JTextArea(5, 20);
        panel.add(area);
    }

    /**
     * This runs every one second according to the Intervaler class. It will increase the decimal interval for seconds
     * by one and at 60 seconds will increase the minutes interval by one while resetting the seconds to 0.
     * It will then format the current decimal time and put it in the text area. Next it sets the binary time
     * and puts that formatted into the text area. Finally it runs the update seconds and minutes led methods
     * in the PiControlGpio class.
     */
    public void run(){
        if(isRunning){
            if(decimalSeconds<60){
                decimalSeconds++;
            }else{
                decimalSeconds = 0;
                decimalMinutes++;
            }
        //This sets the text area with the decimal Minutes and seconds.
        area.setText(stringOfDecimalMinutes() + " : " + stringOfDecimalSeconds()); 
        //This sets the binary time in PiControlGpio equal to the current time and also puts it in the text area.
        setBinaryTime(decimalSeconds, decimalMinutes);
        area.append("\n" + binaryMinutes + " : " + binarySeconds);
        //This is the Pi bit
        controlGpio.updateSecondsLeds(binarySeconds);
        System.out.println("");
        controlGpio.updateMinutesLeds(binaryMinutes);
        System.out.println();
        }
    }

    /**
     * This method will set the binary time according to the current decimal seconds and minutes. If the binary time is
     * less than 6 characters long, it will add some zeros to it.
     * @param currentSeconds The current seconds interval
     * @param currentMinutes The current minutes interval
     */
    public void setBinaryTime(int currentSeconds, int currentMinutes){
        binarySeconds = Integer.toBinaryString(currentSeconds);
            for(int i = binarySeconds.length(); i<6; i++){
                binarySeconds = "0" + binarySeconds;
            }  
        binaryMinutes = Integer.toBinaryString(currentMinutes);
            for(int i = binaryMinutes.length(); i<6; i++){
            binaryMinutes = "0" + binaryMinutes;
        }  
    }

    /**
     * Sets running
     * @param isRunning Is the timer currently running.
     */
    public void setRunning(boolean isRunning){
        this.isRunning = isRunning;
    }

    /**
     * Creates String using the current decimal seconds and returns it. Adds some zeros if it is only one number long.
     * @return The decimal seconds as a pretty String.
     */
    public String stringOfDecimalSeconds(){
        String string = Integer.toString(decimalSeconds);
        for(int i = string.length(); i<2; i++){
            string = "0" + string;
        }  
        return string;
    }
    /**
     * Creates String using the current decimal minutes and returns it. Adds some zeros if it is only one number long.
     * @return The decimal minutes as a pretty String.
     */
    public String stringOfDecimalMinutes(){
        String string = Integer.toString(decimalMinutes);
        for(int i = string.length(); i<2; i++){
            string = "0" + string;
        }  
        return string;
    }

    /**
     * Handles when the buttons are pressed. The start and stop button will update the isRunning variable according
     * to what it is currently set to as well as putting some info in the text area. The clear button will
     * set the decimal seconds and minutes to 0 and put some info in the text area.
     * @param src
     */
    public void handleButtonPress(Object src){
        //Start/Stop button
        if(src == button1 && isRunning){          
            setRunning(false);
            area.append(" Stopped! ");
        }else if(src == button1 && !isRunning){
            setRunning(true);
            area.append(" Started! ");
        }
        //Clear button
        if(src == button2){
            area.setText("Cleared");
            decimalSeconds = 0;
            decimalMinutes = 0;
        }
    }
}
