package step3;

import java.util.List;

public class Printer {

    private final static String STATE = "-";

    public static void print(List<Car> cars){
        for(Car car : cars){
            System.out.println(STATE.repeat(car.getState()));
        }
        System.out.println();
    }
}
