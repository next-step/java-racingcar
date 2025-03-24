package com.nextstep.camp.racing.infrastructure.view;

import com.nextstep.camp.racing.infrastructure.view.component.MaxPositionInput;
import com.nextstep.camp.racing.infrastructure.view.component.QuantityInput;
import com.nextstep.camp.racing.infrastructure.view.dto.InputData;

public class CreateRacingView {
    private final QuantityInput quantityInput;
    private final MaxPositionInput maxPositionInput;

    private CreateRacingView(QuantityInput quantityInput, MaxPositionInput maxPositionInput) {
        this.quantityInput = quantityInput;
        this.maxPositionInput = maxPositionInput;
    }

    public static CreateRacingView publish(QuantityInput quantityInput, MaxPositionInput maxPositionInput) {
        return new CreateRacingView(quantityInput, maxPositionInput);
    }

    public void render() {
        quantityInput.action();
        maxPositionInput.action();
    }

    public InputData toInputData() {
        return InputData.of(quantityInput.getValue(), maxPositionInput.getValue());
    }
}
