/*
 * RacingCarGame
 *
 * version 1.0
 *
 * 2021-11-09
 *
 * 저작권 nextstep
 */

package racingcargame;

import racingcargame.domain.RacingCar;
import racingcargame.ui.InputView;
import racingcargame.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private final InputView inputView;
    private final ResultView resultView;

    public RacingCarGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        int carCount = inputView.readCarCount();
        int tryCount = inputView.readTryCount();
        List<RacingCar> racingCars = prepareRacingCars(carCount);
        prepareRacingCars(carCount);
        moveAndPrintResult(tryCount, racingCars);
    }

    protected List<RacingCar> prepareRacingCars(int carCount) {
        List<RacingCar> racingCars = new ArrayList<>();
        while (carCount-- > 0) {
            racingCars.add(new RacingCar());
        }
        return racingCars;
    }

    protected void moveAndPrintResult(int tryCount, List<RacingCar> racingCars) {
        resultView.printResultMessage();
        while (tryCount-- > 0) {
            moveAndPrintState(racingCars);
        }
    }

    private void moveAndPrintState(List<RacingCar> racingCars) {
        racingCars.stream().forEach(r -> {
            r.move();
            resultView.printCurrentStateOfRacingCar(r);
        });
        resultView.print("");
    }

}
