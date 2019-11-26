import java.awt.event.*;

/**
 * Buttons listener.
 */
public class ButtonListener implements ActionListener{
    Intervaler master;
    public ButtonListener (Intervaler master) {
        this.master = master;
    }

    public void actionPerformed (ActionEvent e) {
        Object src = e.getSource();
        master.handleButtonPress (src);
    }
}