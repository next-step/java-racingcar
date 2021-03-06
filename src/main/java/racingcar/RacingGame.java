package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private static ResultView resultView = new ResultView();
    private static Random random = new Random();

    public List<Car> initRacing(int countCar) {
        List<Car> cars = new ArrayList();

        for (int i = 0; i < countCar; i++) {
             cars.add(new Car(0));
        }

        return cars;
    }

    public int getNumber() {
        return random.nextInt(10);
    }

    public void playRacing(List<Car> cars) {
        for (Car car : cars) {
            car.updateByCondition(getNumber());
        }
    }

    public void startRacing(int countCar, int countTry) {
        List<Car> cars = initRacing(countCar);

        for (int i = 0; i < countTry; i++) {
            playRacing(cars);

            resultView.printResult(cars);
        }
    }
}
