package com.nextstep.camp.racing.application.dto;

import com.nextstep.camp.racing.common.vo.PositiveInteger;

public class RacingRequest {
    private final PositiveInteger quantity;
    private final PositiveInteger maxPosition;

    private RacingRequest(PositiveInteger quantity, PositiveInteger maxPosition) {
        this.quantity = quantity;
        this.maxPosition = maxPosition;
    }

    public static RacingRequest of(PositiveInteger quantity, PositiveInteger maxPosition) {
        return new RacingRequest(quantity, maxPosition);
    }

    public PositiveInteger getQuantity() {
        return quantity;
    }

    public PositiveInteger getMaxPosition() {
        return maxPosition;
    }
}
