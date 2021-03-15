package step5;

import step5.View.InputView;
import step5.domain.Cars;
import step5.domain.RandomGenerate;
import static step5.View.OutputView.*;

public class RacingGame {

    private final Cars cars;
    private int attempt;

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
        printWinner();

    }

    public void move() {
        attemptRacing();
    }

    private void attemptRacing() {
        cars.getCars().forEach(
                i -> i.move(new RandomGenerate())
        );

        System.out.println();
    }
}
