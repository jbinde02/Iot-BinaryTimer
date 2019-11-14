import javax.swing.*;
import java.awt.event.*;

public class TimerWindow implements ActionListener{
    JFrame frame;
    JPanel panel;
    JButton button1, button2;
    JTextArea area;
    public TimerWindow(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setVisible(true);
        panel = new JPanel();
        frame.add(panel);

        button1 = new JButton("Start/Stop");
        panel.add(button1);
        button1.addActionListener(this);

        button2 = new JButton("Clear");       
        panel.add(button2);
        button1.addActionListener(this);
        
        area = new JTextArea(5, 20);
        panel.add(area);
    }
    public void actionPerformed(ActionEvent e) {
        area.append("Hello");
    }
}