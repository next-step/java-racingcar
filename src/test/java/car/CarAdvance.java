package car;

import car.Car;

import java.util.Random;

public class CarAdvance extends Car {
    Random random = new Random();
    @Override
    public int move(){
        return random.nextInt(6)+4;
    }
}
