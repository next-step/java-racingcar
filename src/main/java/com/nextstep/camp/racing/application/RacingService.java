package com.nextstep.camp.racing.application;

import com.nextstep.camp.racing.application.dto.RacingRequest;
import com.nextstep.camp.racing.application.dto.RacingResponse;
import com.nextstep.camp.racing.domain.entity.Racing;

public class RacingService {

    public RacingResponse startRace(RacingRequest request) {
        Racing racing = request.toRacing();
        racing.start();
        return RacingResponse.of(racing);
    }
}
