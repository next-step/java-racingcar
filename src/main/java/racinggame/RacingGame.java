package racinggame;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public static void main(String[] args) {
        String[] carNames = InputView.getCarNames();
        int numOfTrial = InputView.getNumOfTrial();

        List <Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }

        Movement movement = new Movement(cars);
        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        ResultView.printResultMessage();

        for (int i = 0; i < numOfTrial; i++) {
            movement.moveCars(randomMoveStrategy);
            ResultView.printRaceResult(cars);
        }

        List<Car> winners = WinnerCalculator.getWinners(cars);
        ResultView.printWinner(winners);
    }
}
