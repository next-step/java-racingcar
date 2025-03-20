package com.nextstep.camp.racing.infrastructure.view.handler;

import java.util.List;

import com.nextstep.camp.racing.infrastructure.view.*;
import com.nextstep.camp.racing.infrastructure.view.component.MaxPositionInput;
import com.nextstep.camp.racing.infrastructure.view.component.QuantityInput;

public class CreateRacingViewHandler {

    public ViewData handleUserInput() {
        List<Element> elements = List.of(QuantityInput.create(), MaxPositionInput.create());
        CreateRacingView createRacingView = CreateRacingView.publish(elements);
        createRacingView.render();
        return createRacingView.toViewData();
    }
}
