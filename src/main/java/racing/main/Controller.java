package racing.main;

import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.Competition;
import racing.domain.RandomMovableCondition;
import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.List;

public class Controller {
    public static void main(String[] args) {
        String[] carNames = InputView.inputCarNames();
        int round = InputView.inputNumberOfRounds();

        Competition competition = new Competition(carNames, round);
        List<Cars> snapshots = competition.progressEntireRoundAndRecordAllSnapshot(new RandomMovableCondition());
        ResultView.printEntireStatus(snapshots);

        List<Car> winningCars = competition.getCarsWithMaxDistance(snapshots.get(snapshots.size() - 1));
        ResultView.printWinneringCars(winningCars);
    }
}
