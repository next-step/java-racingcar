package racingcar.step4.controller;

import racingcar.step4.domain.move.RandomMoveStrategy;
import racingcar.step4.service.RacingService;
import racingcar.step4.service.dto.RacingResultDto;

import java.util.List;

public class RacingController {

    private final RacingService racingService;

    public RacingController(int roundCount, List<String> names) {
        this.racingService = new RacingService(new RandomMoveStrategy(), roundCount, names);
    }

    public RacingResultDto startRacingContest() {
        return racingService.startRacingContest();
    }
}
