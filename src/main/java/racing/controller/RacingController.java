package racing.controller;

import racing.service.RacingService;
import racing.view.InputView;

public class RacingController {

    public static void play() {
        String carNames = InputView.getCarNames();
        int tryCnt = InputView.getTryCnt();

        new RacingService().playGame(carNames, tryCnt);
    }
}
