package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private static ResultView resultView = new ResultView();

    public List<Car> initRacing(int countCar) {
        List<Car> cars = new ArrayList();

        for (int i = 0; i < countCar; i++) {
             cars.add(new Car(""));
        }

        return cars;
    }

    public int getRandomNumber() {
        Random random = new Random();

        return random.nextInt(10);
    }

    public void playRacing(List<Car> cars) {
        for (Car car : cars) {
            int randomNum = getRandomNumber();
            car.updateByRandom(randomNum);
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
