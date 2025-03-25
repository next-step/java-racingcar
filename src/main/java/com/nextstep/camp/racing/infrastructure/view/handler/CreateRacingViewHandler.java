package com.nextstep.camp.racing.infrastructure.view.handler;

import com.nextstep.camp.racing.infrastructure.view.CreateRacingView;
import com.nextstep.camp.racing.infrastructure.view.component.CarNamesInput;
import com.nextstep.camp.racing.infrastructure.view.component.MaxPositionInput;
import com.nextstep.camp.racing.infrastructure.view.dto.InputData;

public class CreateRacingViewHandler {

    public InputData handleUserInput() {
        CarNamesInput carNamesInput = CarNamesInput.create();
        MaxPositionInput maxPositionInput = MaxPositionInput.create();
        CreateRacingView createRacingView = CreateRacingView.publish(carNamesInput, maxPositionInput);
        createRacingView.render();
        return createRacingView.toInputData();
    }
}
