package racingcar.application;

import racingcar.domain.Car;
import racingcar.view.ResultView;

import java.util.List;


public class RacingSimulator {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    private final ResultView resultView = new ResultView();

    public List<Car> race(List<Car> cars, int countOfRacing) {
        for (int count = 0; count < countOfRacing; count++) {
            moveCars(cars);
            resultView.printDistanceOfCar(cars);
        }
        return cars;
    }

    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            Integer randomNumber = randomNumberGenerator.generatorNumber(10);
            car.move(randomNumber);
        }
    }
}
