package step4;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {

    private List<Car> cars;

    public CarRacingGame(String[] carNames) {
        cars = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i], new RandomMoveStrategy()));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public Car[] getWinners() {
        return Referee.getWinners(cars);
    }
}
