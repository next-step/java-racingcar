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
import racingcargame.domain.Result;
import racingcargame.domain.RacingCarFactory;
import racingcargame.ui.InputView;
import racingcargame.ui.ResultView;
import racingcargame.utils.RandomUtil;

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
        
        List<RacingCar> racingCars = RacingCarFactory.makeCars(carCount);

        List<Result> results = moveTryCountTimes(tryCount, racingCars);
        printResult(results);
    }

    private List<Result> moveTryCountTimes(int tryCount, List<RacingCar> racingCars) {
        List<Result> results = new ArrayList<>();
        while (tryCount-- > 0) {
            results.add(move(racingCars));
        }
        return results;
    }

    private Result move(List<RacingCar> racingCars) {
        racingCars.forEach(racingCar -> {
            racingCar.move(RandomUtil.nextInt(10));
        });
        return Result.of(racingCars);
    }

    private void printResult(List<Result> results) {
        resultView.printResultMessage();
        results.forEach(result -> {
            resultView.printCurrentStateOfRacingCar(result.getCurrentStates());
        });
    }

}
