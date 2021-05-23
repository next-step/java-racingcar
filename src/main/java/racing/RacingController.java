package racing;

import racing.domain.Car;
import racing.domain.MoveConditionStrategy;
import racing.domain.OverFourStrategy;
import racing.domain.RacingGame;
import racing.view.Input;

import java.util.ArrayList;
import java.util.List;

import static racing.domain.RacingGame.SEPARATOR;
import static racing.view.Output.printResultMessage;
import static racing.view.Output.printWinMessage;

public class RacingController {
    public static void main(String[] args) {
        String carName = Input.makeCarNames();
        String[] carNames = carName.split(SEPARATOR);

        MoveConditionStrategy moveConditionStrategy = new OverFourStrategy();
        List<Car> cars = makeCars(carNames, moveConditionStrategy);

        RacingGame racingGame = new RacingGame(cars);
        cars = racingGame.getCars();
        int count = Input.makeGameRepeatCount();
        racingGame.repeatMoveCars(cars, count);

        printResultMessage();
        printWinMessage(racingGame.findWinner());
    }

    private static List<Car> makeCars(String[] carNames, MoveConditionStrategy moveConditionStrategy) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, moveConditionStrategy));
        }
        return cars;
    }
}
