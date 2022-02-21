package racinggame.domain;

import static racinggame.util.Constants.MAX_NUMBER;
import static racinggame.util.Constants.MIN_NUMBER;
import static racinggame.util.Constants.QUIT_COMMAND;

import java.io.IOException;
import java.util.List;
import racinggame.util.Utils;
import racinggame.view.RacingGameView;

public class RacingGame {

    private List<RacingCar> racingCars;
    private int trial;

    public RacingGame() {
    }

    public RacingGame(List<RacingCar> racingCars, int trial) {
        this.racingCars = racingCars;
        this.trial = trial;
    }

    public void start() throws IOException {
        for (int i = 0; i < trial; i++) {
            RacingGameView.printQuitMessage();
            String input = Utils.getInput();

            if (isEnd(input)) {
                System.exit(0);
            }

            progress();
        }

        Winners winners = new Winners(racingCars);
        RacingGameView.printWinnerOfGame(winners.getWinners());
    }

    private void progress() {
        racingCars.forEach(car -> {
            int randomValue = getRandomValue();
            car.moveForward(randomValue);
            car.printCurrPosition();
        });
    }

    private boolean isEnd(String input) {
        return input.equals(QUIT_COMMAND);
    }

    public int getRandomValue() {
        return (int) Math.floor(Math.random() * (MAX_NUMBER - MIN_NUMBER + 1));
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }

    public int getTrial() {
        return this.trial;
    }
}
