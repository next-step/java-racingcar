package com.nextstep.camp.racing.infrastructure.view;

import java.util.*;

public class CreateRacingView extends AbstractView {

    private CreateRacingView(List<Element> elements) {
        super(elements);
    }

    public static CreateRacingView publish(List<Element> elements) {
        return new CreateRacingView(elements);
    }
}
