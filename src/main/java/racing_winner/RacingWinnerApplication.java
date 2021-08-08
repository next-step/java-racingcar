package racing_winner;

import racing_winner.domain.Racing;
import racing_winner.strategy.RacingGameStrategy;
import racing_winner.strategy.RacingStrategy;
import racing_winner.ui.InputView;
import racing_winner.ui.ResultView;
import racing_winner.utils.CommonUtils;

public class RacingWinnerApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RacingStrategy racingStrategy = new RacingGameStrategy();

        int totalRound = inputView.getRacingRound();
        String inputCars = inputView.getRacingCar();

        String[] racingCars = CommonUtils.splitInput(inputCars);
        Racing racing = Racing.setRacingCars(racingCars);

        for (int i = 0; i < totalRound ; i++) {
            racing.move(racingStrategy);
            resultView.result(i, totalRound, racing);
        }
    }
}
