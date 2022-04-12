package racing.main;

import racing.domain.Cars;
import racing.domain.Competition;
import racing.domain.RandomCondition;
import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.List;

public class Controller {
    public static void main(String[] args) {
        int unit = InputView.inputNumberOfCars();
        int round = InputView.inputNumberOfRounds();

        Competition competition = new Competition(unit, round, new RandomCondition());
//        List<Cars> snapshots = competition.progressEntireRoundAndRecordAllSnapshot();
//        ResultView.print(snapshots);

        Cars snapshot = competition.progressEntireRoundAndRecordLastSnapshot();
        ResultView.print(snapshot);
    }
}
