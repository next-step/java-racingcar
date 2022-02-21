package racinggame.domain;

import static racinggame.util.Constants.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
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
            System.out.println("그만 하시려면 q, 계속하시려면 아무키나 입력해 주세요.");
            String input = Utils.getInput();

            if (isEnd(input)) {
                System.exit(0);
            }

            progress();
        }

        List<Integer> carPositions = getCarPositions();
        int max = Collections.max(carPositions);

        List<String> winners = getWinners(max);

        RacingGameView.printWinnerOfGame(winners);
    }

    private List<Integer> getCarPositions() {
        return racingCars.stream()
            .map(RacingCar::getPosition)
            .collect(Collectors.toList());
    }

    private List<String> getWinners(int max) {
        return racingCars.stream()
            .filter(car -> car.getPosition() == max)
            .map(RacingCar::getCarName)
            .collect(Collectors.toList());
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
