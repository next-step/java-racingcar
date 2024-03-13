package step3.Controller;

import step3.Service.RacingGameService;
import step3.View.InputView;
import step3.View.ResultView;

import java.util.List;

public class RacingGameController {
    private final RacingGameService racingGameService;

    public RacingGameController(RacingGameService racingGameService) {
        this.racingGameService = racingGameService;
    }

    public List<Integer> play() {
        racingGameService.progressStage();
        return racingGameService.getResult();
    }
}
