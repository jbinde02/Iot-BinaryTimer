import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 * This is where the Pi interacts with the program. This class sets the required pins up and puts them in a array.
 * Every time the Intervaler class is run, this class will go through the array of pins and set their pinState them according to
 * the binary string it is given.
 *
 * @author Jacob Binder
 * @version 1.0
 */
public class PiControlGpio{
    private GpioPinDigitalOutput nullPin,sLed0,sLed1,sLed2,sLed3,sLed4,sLed5,mLed0,mLed1,mLed2,mLed3,mLed4,mLed5;
    final GpioController gpio = GpioFactory.getInstance();
    private GpioPinDigitalOutput[] sLedArray;
    private GpioPinDigitalOutput[] mLedArray;

    /**
     * Sets up the required gpio pins and puts them in a array.
     */
    PiControlGpio(){
        nullPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_19, "null", PinState.LOW);
        sLed0 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "seconds LED 0", PinState.LOW);
        sLed1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "seconds LED 1", PinState.LOW);
        sLed2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "seconds LED 2", PinState.LOW);
        sLed3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, "seconds LED 3", PinState.LOW);
        sLed4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09, "seconds LED 4", PinState.LOW);
        sLed5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, "seconds LED 5", PinState.LOW);
        sLedArray = new GpioPinDigitalOutput[]{sLed0, sLed1, sLed2, sLed3, sLed4, sLed5, nullPin}; //Seconds Pins
        mLed0 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12, "minutes LED 0", PinState.LOW);
        mLed1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13, "minutes LED 1", PinState.LOW);
        mLed2 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_14, "minutes LED 2", PinState.LOW);
        mLed3 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_30, "minutes LED 3", PinState.LOW);
        mLed4 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21, "minutes LED 4", PinState.LOW);
        mLed5 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, "minutes LED 5", PinState.LOW);
        mLedArray = new GpioPinDigitalOutput[]{mLed0, mLed1, mLed2, mLed3, mLed4, mLed5, nullPin}; //Minutes Pins
    }

    /**
     * Looks at the binarySeconds string it is given and goes through each character. If the character is a one, it sets
     * the corresponding pin's pinState to high. If the character is a zero, it sets the corresponding pin's pinState to
     * low. It also prints some info in the console to show whether a pins should be on or off.
     * @param binarySeconds The binary seconds string. Can't be longer than 6 characters.
     */
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
    /**
     * Looks at the binaryMinutes string it is given and goes through each character. If the character is a one, it sets
     * the corresponding pin's pinState to high. If the character is a zero, it sets the corresponding pin's pinState to
     * low. It also prints some info in the console to show whether a pins should be on or off.
     * @param binaryMinutes The binary minutes string. Can't be longer than 6 characters.
     */
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