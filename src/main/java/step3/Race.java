package step3;

import java.util.ArrayList;

public class Race {

    public static void start(ArrayList<Car> cars) {
        for(Car car: cars){
            int speed = Engine.getSpeed();
            car.move(speed);
        }
    }

}
