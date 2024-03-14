package step3.view;

import step3.application.domain.Racing;
import step3.application.domain.model.RacingHistory;
import step3.view.model.RacingArguments;

public class ViewHandler {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingArguments racingArguments = inputView.receiveRacingArguments();

        Racing racing = new Racing(racingArguments.getCarCount());
        RacingHistory racingHistory = racing.startRace(racingArguments.getMoveCount());

        ResultView resultView = new ResultView();
        resultView.printRacingHistory(racingHistory);
    }
}
