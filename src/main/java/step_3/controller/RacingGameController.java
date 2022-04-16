package step_3.controller;

import step_3.domain.RacingCar;
import step_3.domain.RacingCars;
import step_3.model.FinalResult;
import step_3.model.GameCondition;
import step_3.service.GameConditionService;
import step_3.service.RacingCarService;

import java.util.List;
import java.util.stream.Stream;

public class RacingGameController {

    private final RacingCarService racingCarService;
    private final GameConditionService gameConditionService;

    public RacingGameController(RacingCarService racingCarService, GameConditionService gameConditionService) {
        this.racingCarService = racingCarService;
        this.gameConditionService = gameConditionService;
    }

    public FinalResult gameStart() {
        GameCondition gameCondition = gameConditionService.createGameCondition();
        List<RacingCar> racingCars = racingCarService.createRacingCars(gameCondition.getTotalRacingCarCount());
        RacingCars players = racingCarService.composedRacingCars(racingCars);

        return Stream.generate(players::roundFight)
                .limit(gameCondition.getTotalRounds())
                .collect(FinalResult::new, FinalResult::record, FinalResult::record);
    }
}
