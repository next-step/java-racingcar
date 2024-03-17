package step3.controller;

import step3.model.CarsManager;
import step3.model.MovableStrategy;
import step3.service.RacingGameService;

import java.util.List;

public class RacingGameController {
    private final RacingGameService racingGameService;

    public RacingGameController(RacingGameService racingGameService) {
        this.racingGameService = racingGameService;
    }

    public List<Integer> play(CarsManager carsManager) {
        racingGameService.progressStage(carsManager);
        return racingGameService.getResult(carsManager);
    }
}
