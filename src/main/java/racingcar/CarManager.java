package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private final List<Car> cars;
    CarManager(String[] carNames) {
        this.cars = new ArrayList<>();
        for (String carName : carNames) {
            this.cars.add(new Car(carName));
        }
    }

    public void run(int racingCount) {
        ResultView.printMessage();
        for (int i = 0; i < racingCount; i++) {
            raceOnce();
            ResultView.printResult(cars);
        }
        ResultView.printWinners(cars);
    }

    private void raceOnce() {
        for (Car car : cars) {
            Movement movement = new RandomMovement();
            car.move(movement.isMove());
        }
    }
}
