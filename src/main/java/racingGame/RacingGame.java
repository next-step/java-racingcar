package racingGame;

import racingGame.domain.Car;
import racingGame.domain.Cars;
import racingGame.domain.InputValue;
import racingGame.racingRule.RacingRuleDefault;
import racingGame.view.InputView;
import racingGame.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class RacingGame {

    public void play() {
        InputValue inputValue1 = InputView.askInput(new Scanner(System.in));
        moveCars(inputValue1);
        ResultView.printRacingResult(moveCars(inputValue1));
    }

    private Cars moveCars(InputValue inputValue) {
        List<Car> cars1 = createCars(inputValue);
        moveEachRound(inputValue, cars1);
        return new Cars(cars1);
    }

    private static void moveEachRound(InputValue inputValue, List<Car> cars1) {
        IntStream.range(0, inputValue.getTryNum())
                .forEach(tryNum -> cars1.forEach(Car::move));
    }

    private List<Car> createCars(InputValue inputValue) {
        List<Car> mocCars = new ArrayList<>();
        addNewCars(mocCars, inputValue);
        return mocCars;
    }

    private void addNewCars(List<Car> mocCars, InputValue inputValue) {
        RacingRuleDefault racingRuleDefault = new RacingRuleDefault();
        for (int i = 0; i < inputValue.getCarsSize(); i++) {
            mocCars.add(new Car(inputValue.getCarName().get(i), racingRuleDefault));
        }
    }

}
