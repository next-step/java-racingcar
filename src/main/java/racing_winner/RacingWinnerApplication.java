package racing_winner;

import racing_winner.domain.*;
import racing_winner.domain.RacingResult;
import racing_winner.strategy.RacingGameStrategy;
import racing_winner.strategy.RacingStrategy;
import racing_winner.ui.InputView;
import racing_winner.ui.ResultView;
import racing_winner.utils.CommonUtils;

public class RacingWinnerApplication {
    private static final RacingStrategy RACING_STRATEGY = new RacingGameStrategy();

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int totalRound = inputView.getRacingRound();
        String inputCars = inputView.getRacingCar();
        Participants participants = new Participants(CommonUtils.splitInput(inputCars));

        Round round = new Round(totalRound);
        Racing racing = new Racing(participants, round);

        for (int onRound = 0; onRound < totalRound; onRound++) {
            RacingResult result = racing.race(RACING_STRATEGY);
            resultView.result(result, onRound, totalRound);
        }
    }
}
