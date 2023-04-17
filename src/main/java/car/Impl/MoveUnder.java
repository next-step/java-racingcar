package car.Impl;

import car.Car;
import car.Move;

import java.util.Random;

public class MoveUnder implements Move {
    Car car = new Car();

    @Override
    public int MoveRandem() {
        Random random = new Random();
        return random.nextInt(4);
    }

    @Override
    public int[] moveState(int[] cars){
        for (int i = 0; i < cars.length; i++) {
           cars[i] += car.goStop(this.MoveRandem());
        }
        return cars;
    }
}
