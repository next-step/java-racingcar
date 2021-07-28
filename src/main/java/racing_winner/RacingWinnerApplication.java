package racing_winner;

import racing_winner.domain.RacingCar;
import racing_winner.service.RacingService;
import racing_winner.ui.InputView;
import racing_winner.ui.ResultView;

import java.util.List;

public class RacingWinnerApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RacingService racingService = new RacingService();

        String racingCar = inputView.getRacingCar();
        int totalRound = inputView.getRacingRound();
        List<RacingCar> racingCarList = racingService.setInitialCarList(totalRound, racingCar);

        for (int round = 0; round < totalRound; round++) {
            racingCarList = racingService.exec(racingCarList);
            resultView.result(racingCarList, round);
        }

    }
}
