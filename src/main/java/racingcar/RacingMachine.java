package racingcar;

import racingcar.domain.Cars;
import racingcar.util.InputView;
import racingcar.util.ResultView;

public class RacingMachine {
    private static final int ROUND_END = 0;

    private static int numberOfCars;
    private static int numberOfRounds;
    private static Cars cars;

    public static void main(String[] args) {
        runMachine();
    }

    private static void runMachine() {
        numberOfCars = InputView.getNumberOfCar();
        numberOfRounds = InputView.getNumberOfRound();
        cars = new Cars(numberOfCars);
        ResultView.startGame();
        while (numberOfRounds-- > ROUND_END) {
            cars.move();
            cars.showResult();
        }
        ResultView.endGame();
    }
}
