package racing.controller;

import racing.service.response.RacingDto;
import racing.service.RacingService;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingController {

    public static void play() {
        RacingDto racingDto = RacingService.playGame(InputView.getCarNames(), InputView.getTryCnt());

        ResultView.printRacingResult(racingDto);
    }
}
