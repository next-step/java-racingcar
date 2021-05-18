package racing;

import racing.domain.Car;
import racing.domain.MoveConditionStrategy;
import racing.domain.OverFourStrategy;
import racing.domain.RacingGame;
import racing.view.Input;

import java.util.ArrayList;
import java.util.List;

import static racing.domain.RacingGame.SEPARATOR;
import static racing.view.Output.*;

public class RacingController {
    public static void main(String[] args) {
        String carNames = Input.makeCarNames();
        String[] carNameArray = carNames.split(SEPARATOR);

        List<Car> cars = makeCars(carNameArray);

        RacingGame racingGame = new RacingGame(cars);
        cars = racingGame.getCars();
        int count = Input.makeGameRepeatCount();
        repeatMoveCars(cars, count);

        printResultMessage();
        printWinMessage(racingGame.findWinner());
    }

    private static List<Car> makeCars(String[] carNameArray) {
        List<Car> cars = new ArrayList<>();
        MoveConditionStrategy moveConditionStrategy = new OverFourStrategy();
        for (String carName : carNameArray) {
            cars.add(new Car(carName, moveConditionStrategy));
        }
        return cars;
    }

    public static void repeatMoveCars(List<Car> cars, int count) {

        for (int i = 0; i < count; i++) {
            RacingGame.moveCars(cars);
            printNowDistance(cars);
        }
    }
}
