package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private final InputHandler inputHandler;
    private final ResultView resultView;

    public RacingCarGame(InputHandler inputHandler, ResultView resultView) {
        this.inputHandler = inputHandler;
        this.resultView = resultView;
    }

    public void game() {
        Input racingCarInputResult = inputHandler.getInput();
        List<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < racingCarInputResult.numberOfCar; i++) {
            racingCars.add(new RacingCar(racingCarInputResult.numberOfCountToTry));
        }

        for (int i = 0; i < racingCarInputResult.numberOfCountToTry; i++) {
            for (RacingCar racingCar : racingCars) {
                racingCar.tryToMove();
            }
            resultView.print(racingCars);
        }
    }
}
