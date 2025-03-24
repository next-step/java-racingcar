package com.nextstep.camp.racing.infrastructure.view.dto;

import com.nextstep.camp.racing.common.vo.PositiveInteger;

public class InputData {
    private final PositiveInteger quantity;
    private final PositiveInteger maxPosition;

    private InputData(PositiveInteger quantity, PositiveInteger maxPosition) {
        this.quantity = quantity;
        this.maxPosition = maxPosition;
    }

    public static InputData of(PositiveInteger quantity, PositiveInteger maxPosition) {
        return new InputData(quantity, maxPosition);
    }

    public PositiveInteger getQuantity() {
        return quantity;
    }

    public PositiveInteger getMaxPosition() {
        return maxPosition;
    }
}
