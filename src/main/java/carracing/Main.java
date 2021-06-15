package carracing;

import carracing.controller.RacingGame;
import carracing.model.Car;
import carracing.view.Input;
import carracing.view.Output;

public class Main {
    private static final int RACING_COUNT_FIRST_INDEX = 0;

    public static void main(String[] args) {
        Output.showInputCarName();
        String carNameInput = Input.insertCarName();

        Output.showInputRacingCount();
        int gameCount = Input.insertGameCount();

        RacingGame racingGame = new RacingGame(carNameInput);
        for (int i = RACING_COUNT_FIRST_INDEX; i < gameCount; i++) {
            for (Car car : racingGame.getCars()) {
                racingGame.race(car);
                Output.showCarStatus(car);
            }
            Output.breakNewLine();
        }
        Output.showWinners(racingGame);
    }
}
