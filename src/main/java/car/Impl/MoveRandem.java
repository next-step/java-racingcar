package car.Impl;

import car.Car;
import car.Move;
import car.ResultView;

import java.util.Random;

public class MoveRandem implements Move {
    Car car = new Car();
    ResultView resultView = new ResultView();
   private static final Random random = new Random();


    @Override
    public int MoveRandem() {
        Random random = new Random();
        return random.nextInt(10);
    }

    @Override
    public int[] moveState(int[] cars){
        for (int i = 0; i < cars.length; i++) {
            cars[i] += car.goStop(this.MoveRandem());
            resultView.resultView(cars[i]);
        }
        return cars;
    }
}
