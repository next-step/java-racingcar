package racingcar;

import java.util.List;

public class RacingCarGame {
    private final InputHandler inputHandler;
    private final ResultView resultView;

    public RacingCarGame(InputHandler inputHandler, ResultView resultView) {
        this.inputHandler = inputHandler;
        this.resultView = resultView;
    }

    public void game() {
        Input input = inputHandler.getInput();
        List<RacingCar> racingCars = input.toRacingCars();

        for (int i = 0; i < input.numberOfCountToTry; i++) {
            for (RacingCar racingCar : racingCars) {
                racingCar.tryToMove();
            }
            resultView.print(racingCars);
        }
    }
}
