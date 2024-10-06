package carracing;

import carracing.domain.car.Car;
import carracing.domain.move.MoveStrategy;
import carracing.domain.move.RandomNumberMoveStrategy;
import carracing.domain.race.Race;
import carracing.domain.record.RoundRecord;
import carracing.view.InputView;
import carracing.view.ResultView;

import java.util.List;

public class CarRacing {
    private final InputView inputView;
    private final ResultView resultView;
    private final MoveStrategy moveStrategy;

    public CarRacing(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.moveStrategy = new RandomNumberMoveStrategy();
    }

    public void run() {
        List<String> carNames = inputView.getCarNamesFromUser();
        int numberOfRounds = inputView.getRoundNumberFromUser();

        Race race = Race.of(carNames, numberOfRounds, moveStrategy);
        List<RoundRecord> result = race.start();
        List<Car> winners = race.getWinners();

        resultView.showCarRacingResult(result);
        resultView.showWinnerNames(winners);
    }


}
