package racingcar;

import java.util.ArrayList;
import racingcar.domain.Cars;
import racingcar.domain.RaceResults;
import racingcar.domain.RandomRacingRule;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {
        while (!isEnd()) {
            continue;
        }
    }

    private static Boolean isEnd() {
        try {
            racing();
            return true;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void racing() {
        Racing racing = new Racing(new Cars(Cars.registerCars(InputView.askCarNames())),
            InputView.askRaceCount(), new RaceResults(new ArrayList<>()), new RandomRacingRule());
        racing.playFullRace();
        OutputView.announceRaceResults(racing.raceResults());
    }

}
