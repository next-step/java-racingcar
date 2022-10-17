package racing.controller;

import racing.domain.Cars;
import racing.domain.Moving;
import racing.domain.Winner;
import racing.utils.SplitUtil;
import racing.view.ResultView;

public class Racing {
    public static String raceResult(Cars cars, int cntOfTry) {
        race(cars, cntOfTry);
        return winners(cars);
    }
    private static void race(Cars cars, int cntOfTry) {
        ResultView resultView = new ResultView();
        for (int i = 0; i < cntOfTry; i++) {
            cars.moveCar(new Moving());
            resultView.printRacingResult(cars);
        }
    }

    private static String winners(Cars cars) {
        return SplitUtil.listToStr(new Winner(cars).compareWinner());
    }
}
