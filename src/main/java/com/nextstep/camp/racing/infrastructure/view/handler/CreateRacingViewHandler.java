package com.nextstep.camp.racing.infrastructure.view.handler;

import java.util.List;

import com.nextstep.camp.racing.infrastructure.view.*;
import com.nextstep.camp.racing.infrastructure.view.component.MaxPositionInput;
import com.nextstep.camp.racing.infrastructure.view.component.QuantityInput;
import com.nextstep.camp.racing.infrastructure.view.dto.InputData;

public class CreateRacingViewHandler {

    public InputData handleUserInput() {
        QuantityInput quantityInput = QuantityInput.create();
        MaxPositionInput maxPositionInput = MaxPositionInput.create();
        CreateRacingView createRacingView = CreateRacingView.publish(quantityInput, maxPositionInput);
        createRacingView.render();
        return createRacingView.toInputData();
    }
}
