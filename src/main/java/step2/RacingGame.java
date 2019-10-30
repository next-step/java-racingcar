package step2;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int time;
    private List<Car> cars;

    public RacingGame(int carNum, int trialNum) {
        time = trialNum;
        cars = new ArrayList<>();

        for (int i = 0; i < carNum; i++) {
            cars.add(new Car());
        }
    }

    public List<Car> doGame() {
        for (int i = 0; i < time; i++) {
            moveWholeCar();
        }
        return cars;
    }

    private void moveWholeCar() {
        for (Car car : cars) {
            car.move();
        }
    }


}
