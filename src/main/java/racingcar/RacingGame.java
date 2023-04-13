package racingcar;

import java.util.ArrayList;

public class RacingGame {

    public static void main(String[] args) {
        Racing racing = new Racing(new Cars(Cars.registerCars(InputView.askCarNames())),
            InputView.askRaceCount(), new RaceResults(new ArrayList<>()), new RandomRacingRule());
        racing.playFullRace();
        OutputView.announceRaceResults(racing.raceResults());
    }

}
