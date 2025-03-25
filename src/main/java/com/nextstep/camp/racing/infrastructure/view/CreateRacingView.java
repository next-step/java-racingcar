package com.nextstep.camp.racing.infrastructure.view;

import com.nextstep.camp.racing.infrastructure.view.component.CarNamesInput;
import com.nextstep.camp.racing.infrastructure.view.component.MaxPositionInput;
import com.nextstep.camp.racing.infrastructure.view.dto.InputData;

public class CreateRacingView {
    private final CarNamesInput carNamesInput;
    private final MaxPositionInput maxPositionInput;

    private CreateRacingView(CarNamesInput carNamesInput, MaxPositionInput maxPositionInput) {
        this.carNamesInput = carNamesInput;
        this.maxPositionInput = maxPositionInput;
    }

    public static CreateRacingView publish(CarNamesInput carNamesInput, MaxPositionInput maxPositionInput) {
        return new CreateRacingView(carNamesInput, maxPositionInput);
    }

    public void render() {
        carNamesInput.action();
        maxPositionInput.action();
    }

    public InputData toInputData() {
        return InputData.of(carNamesInput.getValue(), maxPositionInput.getValue());
    }
}
