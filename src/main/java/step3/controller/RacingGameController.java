package step3.controller;

import step3.service.RacingGameService;

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
