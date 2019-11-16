import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Intervaler extends TimerTask{
    int decimalSeconds;
    int decimalMintues;
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
    public Intervaler(){
        decimalSeconds = 0;
        decimalMintues = 0;
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
    public void run(){
        if(isRunning){
            if(decimalSeconds<60){
                decimalSeconds++;
            }else{
                decimalSeconds = 0;
                decimalMintues++;
            }
        }
        //This sets the text area with the decimal mintues and seconds.
        area.setText(stringOfDecimalMintues() + " : " + stringOfDecimalSeconds()); 
        //This sets the binary time in PiControlGpio equal to the current time and also puts it in the text area.
        setBinaryTime(decimalSeconds, decimalMintues);
        area.append("\n" + getBinaryMinutes() + " : " + getBinarySeconds());   
    }
    public void setBinaryTime(int currentSeconds, int currentMintues){
        binarySeconds = Integer.toBinaryString(currentSeconds);
            for(int i = binarySeconds.length(); i<6; i++){
                binarySeconds = "0" + binarySeconds;
            }  
        binaryMinutes = Integer.toBinaryString(currentMintues);
            for(int i = binaryMinutes.length(); i<6; i++){
            binaryMinutes = "0" + binaryMinutes;
        }  
    }
    public void setRunning(boolean isRunning){
        this.isRunning = isRunning;
    }
    public void setDecimalSeconds(int decimalSeconds){
        this.decimalSeconds = decimalSeconds;
    }
    public void setDecimalMintues(int decimalMintues){
        this.decimalMintues = decimalMintues;
    }
    public int getDecimalSeconds(){
        return decimalSeconds;
    }
    public int getDecimalMintues(){
        return decimalSeconds;
    }
    public String getBinaryMinutes() {
        return binaryMinutes;
    }
    public String getBinarySeconds() {
        return binarySeconds;
    }
    public String stringOfDecimalSeconds(){
        String string = Integer.toString(decimalSeconds);
        for(int i = string.length(); i<2; i++){
            string = "0" + string;
        }  
        return string;
    }
    public String stringOfDecimalMintues(){
        String string = Integer.toString(decimalMintues);
        for(int i = string.length(); i<2; i++){
            string = "0" + string;
        }  
        return string;
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
        //Clear button
        if(src == button2){
            area.setText("Cleared");
            decimalSeconds = 0;
            decimalMintues = 0;
        }
    }
}
