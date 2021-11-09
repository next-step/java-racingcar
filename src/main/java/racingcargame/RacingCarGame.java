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

    private List<RacingCar> racingCars = new ArrayList<>();;

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

    protected void prepareRacingCars() {
        racingCars.clear();
        while (carCount-- > 0) {
            racingCars.add(new RacingCar());
        }
    }

    protected void moveAndPrintResult() {
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

    public int getCarCount() {
        return carCount;
    }

    public void setCarCount(int carCount) {
        this.carCount = carCount;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public void setRacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }
}
