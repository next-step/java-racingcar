package com.nextstep.camp.racing.application.dto;

import com.nextstep.camp.racing.common.vo.PositiveInteger;
import com.nextstep.camp.racing.domain.vo.CarNames;

public class RacingRequest {
    private final CarNames carNames;
    private final PositiveInteger maxPosition;

    private RacingRequest(CarNames carNames, PositiveInteger maxPosition) {
        this.carNames = carNames;
        this.maxPosition = maxPosition;
    }

    public static RacingRequest of(CarNames carNames, PositiveInteger maxPosition) {
        return new RacingRequest(carNames, maxPosition);
    }

    public CarNames getCarNames() {
        return carNames;
    }

    public PositiveInteger getMaxPosition() {
        return maxPosition;
    }
}
