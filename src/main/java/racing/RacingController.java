package racing;

import racing.domain.*;
import racing.view.Input;

import java.util.ArrayList;
import java.util.List;

import static racing.domain.RacingGame.SEPARATOR;
import static racing.view.Output.*;

public class RacingController {
    public static void main(String[] args) {
        String carName = Input.makeCarNames();
        String[] carNames = carName.split(SEPARATOR);

        MoveConditionStrategy moveConditionStrategy = new OverFourStrategy();
        List<Car> cars = makeCars(carNames, moveConditionStrategy);

        RacingGame racingGame = new RacingGame(cars);
        int repeatCount = Input.makeGameRepeatCount();
        racingGame.repeatMoveCars(repeatCount);

        printResultMessage();

        cars = racingGame.getCars();
        printResultByMovedLog(cars, repeatCount);

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
