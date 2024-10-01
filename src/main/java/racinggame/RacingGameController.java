package racinggame;

import racinggame.racingcar.*;
import java.util.List;

public class RacingGameController {
    private final InputView inputView;
    private final ResultView resultView;
    private final Race race;

    public RacingGameController(InputView inputView, ResultView resultView, Race race) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.race = race;
    }

    public void run() {
        int numberOfCars = inputView.readNumberOfCars();
        int numberOfRounds = inputView.readNumberOfRounds();

        initializeRace(numberOfCars);
        conductRace(numberOfRounds);
    }

    private void initializeRace(int numberOfCars) {
        race.createRacingCars(numberOfCars);
        resultView.printResultMessage();
    }

    private void conductRace(int numberOfRounds) {
        for (int i = 0; i < numberOfRounds; i++) {
            List<Integer> roundResult = race.proceedRounds();
            resultView.printRaceResults(roundResult);
        }
    }
}
