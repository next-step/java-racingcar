package carracing;

import carracing.domain.race.Race;
import carracing.domain.car.Car;
import carracing.domain.random.DefaultRandomNumberGenerator;
import carracing.domain.random.RandomNumberGenerator;
import carracing.domain.record.RoundRecord;
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

        Race race = Race.of(carNames, numberOfRounds, randomNumberGenerator);
        List<RoundRecord> result = race.start();
        List<Car> winners = race.getWinners();

        resultView.showCarRacingResult(result);
        resultView.showWinnerNames(winners);
    }


}
