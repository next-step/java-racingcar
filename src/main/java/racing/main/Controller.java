package racing.main;

import racing.domain.Cars;
import racing.domain.Competition;
import racing.domain.RandomMovableCondition;
import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.List;

public class Controller {
    public static void main(String[] args) {
        int unit = InputView.inputNumberOfCars();
        int round = InputView.inputNumberOfRounds();

        Competition competition = new Competition(unit, round);
        List<Cars> snapshots = competition.progressEntireRoundAndRecordAllSnapshot(new RandomMovableCondition());
        ResultView.printEntireStatus(snapshots);

//        Cars snapshot = competition.progressEntireRoundAndRecordLastSnapshot(new RandomMovableCondition());
//        ResultView.printRoundStatus(snapshot);
    }
}
