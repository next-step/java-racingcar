package com.nextstep.camp.racing.application;

import com.nextstep.camp.racing.application.dto.RacingRequest;
import com.nextstep.camp.racing.application.dto.RacingResponse;
import com.nextstep.camp.racing.domain.entity.Racing;
import com.nextstep.camp.racing.domain.vo.Cars;

public class RacingService {

    public RacingResponse startRace(RacingRequest request) {
        Cars cars = Cars.of(request.getCarNames());
        Racing racing = Racing.initialize(cars, request.getMaxPosition());
        racing.start();
        return RacingResponse.of(racing);
    }
}
