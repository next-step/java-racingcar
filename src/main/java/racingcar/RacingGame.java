package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public static List<Car> cars = new ArrayList<>();

    public static void main(String[] args) {
        String[] carNames = InputView.getCarName();
        int racingCount = InputView.getRacingCount();
        run(carNames, racingCount);
    }

    private static void run(String[] carNames, int racingCount) {
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }

        ResultView.printMessage();
        for (int i = 0; i < racingCount; i++) {
            for (Car car : cars) {
                Movement movement = new RandomMovement();
                car.move(movement.isMove());
            }
            ResultView.printResult();
        }
    }
}
