package racing.controller;

import racing.domain.ValidChecker;
import racing.service.RacingService;
import racing.view.InputView;

public class RacingController {
    private static String carNames;
    private static int tryCnt;

    public static void play() {
        gameSetting();
        new RacingService().playGame(carNames, tryCnt);
    }

    private static void gameSetting() {
        do {
            carNames = InputView.getCarNames();
        } while(!ValidChecker.checkInput(carNames));

        do {
            tryCnt = InputView.getTryCnt();
        } while (!ValidChecker.checkInput(tryCnt));
    }
}
