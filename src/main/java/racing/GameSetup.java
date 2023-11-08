package racing;

import java.util.ArrayList;
import java.util.List;

public class GameSetup {
    List<Car> cars = new ArrayList<>();
    int round;

    public GameSetup(int numCar, int round) {
        this.round = round;
        for (int i = 0; i < numCar ; i++) {
            Car car = new Car();
            cars.add(car);
        }
    }

    public void moveCar() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).validateForMove(RandomUtil.returnRandomNumber());
        }
    }
}