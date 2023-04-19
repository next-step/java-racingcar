package car.Impl;

import car.Car;

import java.util.Random;

public class CarMove extends Car {
    Random random = new Random();
    @Override
    public int move(){
        return random.nextInt(10);
    }
}
