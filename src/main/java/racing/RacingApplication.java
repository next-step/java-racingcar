package racing;

import racing.domain.Racing;
import racing.service.RacingService;
import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingApplication {
    private static List<Racing> racingList = new ArrayList<>();

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int racingCar = inputView.getRacingCar();
        int racingRound = inputView.getRacingRound();

        racingList = RacingService.exec(racingRound, racingCar);
        resultView.result(racingList, racingCar);
    }
}
