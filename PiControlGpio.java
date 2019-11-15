//import com.pi4j.io.gpio.GpioController;
//import com.pi4j.io.gpio.GpioFactory;
//import com.pi4j.io.gpio.GpioPin;
//import com.pi4j.io.gpio.GpioPinDigitalInput;
//import com.pi4j.io.gpio.GpioPinDigitalOutput;
//import com.pi4j.io.gpio.PinDirection;
//import com.pi4j.io.gpio.PinMode;
//import com.pi4j.io.gpio.PinPullResistance;
//import com.pi4j.io.gpio.PinState;
//import com.pi4j.io.gpio.RaspiPin;
//import com.pi4j.io.gpio.trigger.GpioCallbackTrigger;
//import com.pi4j.io.gpio.trigger.GpioPulseStateTrigger;
//import com.pi4j.io.gpio.trigger.GpioSetStateTrigger;
//import com.pi4j.io.gpio.trigger.GpioSyncStateTrigger;
//import com.pi4j.io.gpio.event.GpioPinListener;
//import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
//import com.pi4j.io.gpio.event.GpioPinEvent;
//import com.pi4j.io.gpio.event.GpioPinListenerDigital;
//import com.pi4j.io.gpio.event.PinEventType;
public class PiControlGpio{
    String binarySeconds;
    String binaryMinutes;
    PiControlGpio(){
        binarySeconds = "";
        binaryMinutes = "";
    }
    public void setBinaryTime(int currentSeconds, int currentMintues){
        binarySeconds = Integer.toBinaryString(currentSeconds);
        binaryMinutes = Integer.toBinaryString(currentMintues);
        System.out.println(binarySeconds);
        System.out.println(binaryMinutes);
    }
    public String getBinaryMinutes() {
        return binaryMinutes;
    }
    public String getBinarySeconds() {
        return binarySeconds;
    }
}