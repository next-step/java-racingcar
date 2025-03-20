package com.nextstep.camp.racing.infrastructure.view;

import java.util.List;

public class RacingResultView extends AbstractView {

    private RacingResultView(List<Element> elements) {
        super(elements);
    }

    public static RacingResultView publish(List<Element> elements) {
        return new RacingResultView(elements);
    }
}
