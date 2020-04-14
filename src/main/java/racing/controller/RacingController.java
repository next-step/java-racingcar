package racing.controller;

import racing.service.response.RacingDto;
import racing.service.RacingService;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingController {

    public static void play() {
        String carNames = InputView.getCarNames();
        int tryCnt = InputView.getTryCnt();

        RacingDto racingDTO = new RacingService().playGame(carNames, tryCnt);
        ResultView.printRacingResult(racingDTO);
    }
}
