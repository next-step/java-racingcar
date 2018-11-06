package racingCar;

import java.util.Random;


//지금은
public class RacingCarInit {

    //
    private static final int INITPOSITION=0;


    public static Car[] initCar(String[] names){
        Car[] cars = new Car[names.length];
        int i=0;
        for(String name : names){
            cars[i] = new Car(name, INITPOSITION);
            i++;
        }
        return cars;
    }




}
