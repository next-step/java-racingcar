package com.nextstep.camp.racing.application.dto;

import com.nextstep.camp.racing.common.vo.PositiveInteger;
import com.nextstep.camp.racing.domain.entity.Racing;

public class RacingRequest {
    public final PositiveInteger quantity;
    public final PositiveInteger maxPosition;

    private RacingRequest(PositiveInteger quantity, PositiveInteger maxPosition) {
        this.quantity = quantity;
        this.maxPosition = maxPosition;
    }

    public static RacingRequest of(PositiveInteger quantity, PositiveInteger maxPosition) {
        return new RacingRequest(quantity, maxPosition);
    }

    public Racing toRacing() {
        return Racing.initialize(quantity, maxPosition);
    }
}
