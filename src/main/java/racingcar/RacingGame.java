package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.Arrays;

public class RacingGame {

    Cars cars;
    InputView inputView;
    ResultView resultView;

    public RacingGame() {
        cars = new Cars();
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void initCars(String names) {
        Arrays.stream(names.split(",")).forEach(name -> cars.add(new Car(name)));
    }

    public void move(int numberOfTry) {
        resultView.printExecuteResult();
        for (int i = 0; i < numberOfTry; i++) {
            cars.move();
            resultView.printRaceStep(cars);
        }
    }

    public Cars getCars() {
        return cars;
    }

    public void start() {
        initCars(inputView.enterNameOfCars());
        move(inputView.enterNumberOfTry());
        resultView.printWinner(cars);
    }
}
