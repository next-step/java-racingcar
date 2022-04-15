package racing.main;

import racing.domain.Cars;
import racing.domain.Competition;
import racing.domain.RandomMovableCondition;
import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.List;

public class Controller {
    public static void main(String[] args) {
        String[] carNameArr = InputView.inputNumberOfCars().split(",");
        int round = InputView.inputNumberOfRounds();

        Competition competition = new Competition(carNameArr, round);
        List<Cars> snapshots = competition.progressEntireRoundAndRecordAllSnapshot(new RandomMovableCondition());
        ResultView.printEntireStatus(snapshots);
        String winners = competition.getWinner(snapshots.get(snapshots.size() - 1));
        ResultView.printWinners(winners);
    }
}
