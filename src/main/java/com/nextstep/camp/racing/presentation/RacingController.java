package com.nextstep.camp.racing.presentation;

import com.nextstep.camp.racing.application.RacingService;
import com.nextstep.camp.racing.application.dto.RacingRequest;
import com.nextstep.camp.racing.application.dto.RacingResponse;

public class RacingController {

    private final RacingService racingService;

    public RacingController(RacingService racingService) {
        this.racingService = racingService;
    }

    public RacingResponse startRace(RacingRequest request) {
        return racingService.startRace(request);
    }
}
