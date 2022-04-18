package racingcar.domain;

import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private static final List<Car> carList = new ArrayList<>();

    public List<Car> createCar(int number) {
        for (int i = 0; i < number; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    public void startGame(int value, RacingStrategy strategy, OutputView outputView) {
        for (int i = 0; i < value; i++) {
            carList.get(i).moveOrStop(strategy.createNumber());
            outputView.printResult(carList.get(i));
        }
        outputView.printVacuum();
    }
}
