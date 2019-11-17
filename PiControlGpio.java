import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class PiControlGpio{
    GpioPinDigitalOutput sLed0,sLed1,sLed2,sLed3,sLed4,sLed5,mLed0,mLed1,mLed2,mLed3,mLed4,mLed5;
    final GpioController gpio = GpioFactory.getInstance();
    GpioPinDigitalOutput[] sLedArray;
    GpioPinDigitalOutput[] mLedArray;
    PiControlGpio(){
        sLed0 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "seconds LED 0", PinState.LOW);
        sLed1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "seconds LED 1", PinState.LOW);
        sLed2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, "seconds LED 2", PinState.LOW);
        sLed3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_11, "seconds LED 3", PinState.LOW);
        sLed4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13, "seconds LED 4", PinState.LOW);
        sLed5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_15, "seconds LED 5", PinState.LOW);
        sLedArray = new GpioPinDigitalOutput[]{sLed0, sLed1, sLed2, sLed3, sLed4, sLed5};
        mLed0 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_19, "mintues LED 0", PinState.LOW);
        mLed1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21, "mintues LED 1", PinState.LOW);
        mLed2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_23, "mintues LED 2", PinState.LOW);
        mLed3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, "mintues LED 3", PinState.LOW);
        mLed4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, "mintues LED 4", PinState.LOW);
        mLed5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_31, "mintues LED 5", PinState.LOW);
        mLedArray = new GpioPinDigitalOutput[]{sLed0, mLed1, mLed2, mLed3, mLed4, mLed5};
    }

    public void updateSecondsLeds(String binarySeconds){
        for(int i = 0; i<binarySeconds.length(); i++){
            if(binarySeconds.charAt(i) == '1'){
                sLedArray[i].setState(PinState.HIGH);
                System.out.print(" :sLight " + i + " (On): ");
            }
            if(binarySeconds.charAt(i) == '0'){
                sLedArray[i].setState(PinState.LOW);
                System.out.print(" :sLight " + i + " (Off): ");
            }
        }
    }
    public void updateMinutesLeds(String binaryMinutes){
        for(int i = 0; i<binaryMinutes.length(); i++){
            if(binaryMinutes.charAt(i) == '1'){
                mLedArray[i].setState(PinState.HIGH);
                System.out.print(" :mLight " + i + " (On): ");
            }
            if(binaryMinutes.charAt(i) == '0'){
                mLedArray[i].setState(PinState.LOW);
                System.out.print(" :mLight " + i + " (Off): ");
            }
        }
    }
}