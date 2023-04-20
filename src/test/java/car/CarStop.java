package car;

import car.Car;

import java.util.Random;

public class CarStop extends Car {

    Random random = new Random();
    @Override
    public int move(){
        return random.nextInt(4);
    }


}
