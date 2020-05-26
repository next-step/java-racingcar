package racing;

import racing.view.ResultView;

public class RacingGame {
    private RacingCars racingCars;

    public RacingGame(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public void race(int times) {
        for (int i = 0; i < times; i++) {
            racingCars.moveCars(new CarForwardBehavior());
            ResultView.printResult(racingCars.getCars());
        }
    }
}
