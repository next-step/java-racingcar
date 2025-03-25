package com.nextstep.camp.racing.infrastructure.view.dto;

import com.nextstep.camp.racing.common.vo.PositiveInteger;
import com.nextstep.camp.racing.domain.vo.CarNames;

public class InputData {
    private final CarNames names;
    private final PositiveInteger maxPosition;

    private InputData(CarNames names, PositiveInteger maxPosition) {
        this.names = names;
        this.maxPosition = maxPosition;
    }

    public static InputData of(CarNames carNames, PositiveInteger maxPosition) {
        return new InputData(carNames, maxPosition);
    }

    public CarNames getCarNames() {
        return names;
    }

    public PositiveInteger getMaxPosition() {
        return maxPosition;
    }
}
