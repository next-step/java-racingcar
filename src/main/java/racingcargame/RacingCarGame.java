package racingcargame;

import racingcargame.domain.RacingCar;
import racingcargame.ui.InputView;
import racingcargame.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private final InputView inputView;
    private final ResultView resultView;

    private int carCount;
    private int tryCount;

    private List<RacingCar> racingCars;

    public RacingCarGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        readInput();
        prepareRacingCars();
        moveAndPrintResult();
    }

    private void readInput() {
        carCount = inputView.readCarCount();
        tryCount = inputView.readTryCount();
    }

    private void prepareRacingCars() {
        racingCars = new ArrayList<>();
        while (carCount-- > 0) {
            racingCars.add(new RacingCar());
        }
    }

    private void moveAndPrintResult() {
        resultView.printResultMessage();
        while (tryCount-- > 0) {
            moveAndPrintState();
        }
    }

    private void moveAndPrintState() {
        racingCars.stream().forEach(r -> {
            r.move();
            resultView.printCurrentStateOfRacingCar(r);
        });
        resultView.print("");
    }
}
