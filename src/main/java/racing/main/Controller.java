package racing.main;

import racing.domain.*;
import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.List;

public class Controller {
    public static void main(String[] args) {
        String[] carNames = InputView.inputCarNames();
        int round = InputView.inputNumberOfRounds();

        Competition competition = new Competition(carNames, round);
        RoundRecords records = competition.progressCompetitionAndGetEntireRecords(new RandomMovableCondition());
        ResultView.printEntireStatus(records.getEntireRecords());

        List<Car> winningCars = records.getWinningCars();
        ResultView.printWinneringCars(winningCars);
    }
}
