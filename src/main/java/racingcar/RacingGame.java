package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final int attempts;
    private final List<Car> carList;

    public RacingGame(int cars, int attempts) {
        this.attempts = attempts;
        this.carList = makeCars(cars);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> makeCars(int cars) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < cars ; i++) {
            Car car = new Car(attempts);
            car.generateMoves();;
            carList.add(car);
        }
        return carList;
    }
}
