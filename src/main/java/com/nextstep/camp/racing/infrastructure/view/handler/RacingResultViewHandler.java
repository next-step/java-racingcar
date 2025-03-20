package com.nextstep.camp.racing.infrastructure.view.handler;

import java.util.List;

import com.nextstep.camp.racing.infrastructure.view.*;
import com.nextstep.camp.racing.infrastructure.view.component.RacingResult;

public class RacingResultViewHandler {

    public void handleViewData(ViewData viewData) {
        List<Element> elements = List.of(RacingResult.create(viewData));
        RacingResultView racingResultView = RacingResultView.publish(elements);
        racingResultView.render(viewData);
    }
}
