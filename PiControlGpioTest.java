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
public class PiControlGpioTest{

    PiControlGpioTest(){

    }

    public void updateSecondsLeds(String binarySeconds){
        for(int i = 0; i<binarySeconds.length(); i++){
            if(binarySeconds.charAt(i) == '1'){
                System.out.print(" :sLight " + i + " (On): ");
            }
            if(binarySeconds.charAt(i) == '0'){
                System.out.print(" :sLight " + i + " (Off): ");
            }
        }
    }
    public void updateMinutesLeds(String binaryMinutes){
        for(int i = 0; i<binaryMinutes.length(); i++){
            if(binaryMinutes.charAt(i) == '1'){
                System.out.print(" :mLight " + i + " (On): ");
            }
            if(binaryMinutes.charAt(i) == '0'){
                System.out.print(" :mLight " + i + " (Off): ");
            }
        }
    }
}