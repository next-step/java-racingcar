package carracing;

import carracing.domain.Race;
import carracing.domain.random.DefaultRandomNumberGenerator;
import carracing.domain.random.RandomNumberGenerator;
import carracing.view.InputView;
import carracing.view.ResultView;

import java.util.List;

public class CarRacing {
    private final InputView inputView;
    private final ResultView resultView;
    private final RandomNumberGenerator randomNumberGenerator;

    public CarRacing(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.randomNumberGenerator = new DefaultRandomNumberGenerator();
    }

    public void run() {
        List<String> carNames = inputView.getCarNamesFromUser();
        int numberOfRounds = inputView.getRoundNumberFromUser();

        Race race = initializeRace(carNames);
        startRace(numberOfRounds, race);
    }

    private Race initializeRace(List<String> carNames) {
        return Race.of(carNames, randomNumberGenerator);
    }

    private void startRace(int numberOfRounds, Race race) {
        resultView.showCarsInitState(race);
        for (int roundNumber = 1; roundNumber <= numberOfRounds; roundNumber++) {
            race.moveCars();
            resultView.showCarsState(race);
        }
        resultView.showWinnerNames(race);
    }
}
