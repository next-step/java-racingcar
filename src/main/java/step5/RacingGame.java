package step5;

import step5.View.InputView;
import step5.domain.Car;
import step5.domain.Cars;
import step5.domain.MovingPolicy;
import step5.domain.RandomGeneratePolicy;
import static step5.View.OutputView.*;

public class RacingGame {

    private final Cars cars;
    private int attempt;
    private MovingPolicy generateNumber = new RandomGeneratePolicy();

    public RacingGame(InputView inputView) {
        String carNames = inputView.inputCarNames();
        this.attempt = inputView.inputAttempt();
        this.cars = new Cars(carNames);
    }

    public void start() {
        int round = attempt;
        printStart();
        while (round-- != 0) {
            move();
            printCarMove(cars);

        }
        printWinner(cars.finalWinner());
    }

    public void move() {
        attemptRacing();
    }

    private void attemptRacing() {
        for (Car car : cars.getCars()) {
            car.move(generateNumber);
        }
        cars.eachRoundMove();
        System.out.println();
    }
}
