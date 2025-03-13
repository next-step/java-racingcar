package com.nextstep.camp.racing.infrastructure.view;

import java.util.List;

public class CreateRacingViewHandler {

    public ViewData handleUserInput() {
        List<Element> elements = List.of(QuantityInput.create(), MaxPositionInput.create());
        CreateRacingView createRacingView = CreateRacingView.publish(elements);
        createRacingView.render();
        return createRacingView.toViewData();
    }
}
