package racing;

import racing.domain.Car;
import racing.domain.MoveConditionStrategy;
import racing.domain.NumberIsBiggerStrategy;
import racing.domain.RacingGame;
import racing.view.Input;
import racing.view.Output;

import java.util.ArrayList;
import java.util.List;

import static racing.domain.RacingGame.SEPARATOR;

public class RacingController {
    public static void main(String[] args) {
        String carName = Input.makeCarNames();
        String[] carNames = carName.split(SEPARATOR);

        MoveConditionStrategy moveConditionStrategy = new NumberIsBiggerStrategy();
        List<Car> cars = makeCars(carNames, moveConditionStrategy);

        RacingGame racingGame = new RacingGame(cars);
        int repeatCount = Input.makeGameRepeatCount();
        racingGame.repeatMoveCars(repeatCount);

        Output.printResultMessage();
        cars = racingGame.getCars();
        Output.printResultByMovedLog(cars, repeatCount);

        Output.printWinMessage(racingGame.findWinner());
    }

    private static List<Car> makeCars(String[] carNames, MoveConditionStrategy moveConditionStrategy) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName, moveConditionStrategy));
        }

        return cars;
    }
}
