package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameSetup {
    List<Car> cars = new ArrayList<>();
    int round;
    Random random;

    public GameSetup(int numCar, int round, Random random) {
        this.round = round;
        for (int i = 0; i < numCar ; i++) {
            Car car = new Car();
            cars.add(car);
        }
        this.random = random;
    }

    public void moveCar(Random random) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).validateForMove(random);
        }
    }
}