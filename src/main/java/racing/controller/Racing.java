package racing.controller;

import racing.domain.Cars;
import racing.domain.Moving;
import racing.view.ResultView;

public class Racing {
    private int cntOfTry;

    public Racing(int cntOfTry) {
        this.cntOfTry = cntOfTry;
    }

    public void race(Cars cars) {
        ResultView resultView = new ResultView();
        for (int i = 0; i < cntOfTry; i++) {
            cars.moveCar(new Moving());
            resultView.printRacingResult(cars);
        }
    }
}
