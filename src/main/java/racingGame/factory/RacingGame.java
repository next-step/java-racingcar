package racingGame;

import racingGame.domain.Car;
import racingGame.domain.Cars;
import racingGame.domain.InputValue;
import racingGame.racingRule.RacingRule;
import racingGame.view.InputView;
import racingGame.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class RacingGame {
    private final InputView inputView;
    private final ResultView resultView;
    private final List<Car> cars = new ArrayList<>();

    public RacingGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void play(RacingRule racingRule) {
        InputValue inputValue = inputView.askInput(new Scanner(System.in));
        Cars cars = createCars(inputValue);
        resultView.printRacingResult(cars, racingRule, inputValue.getTryNum());
    }

    private Cars createCars(InputValue inputValue) {
        addNewCars(inputValue);
        return new Cars(cars);
    }

    private void addNewCars(InputValue inputValue) {
        for (int i = 0; i < inputValue.getCarsSize(); i++) {
            cars.add(new Car(inputValue.getCarName().get(i)));
        }
    }

    public abstract void play();
}
