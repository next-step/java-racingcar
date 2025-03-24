package com.nextstep.camp.racing.infrastructure.view.handler;

import java.util.List;

import com.nextstep.camp.racing.application.dto.RacingResponse;
import com.nextstep.camp.racing.infrastructure.view.*;
import com.nextstep.camp.racing.infrastructure.view.component.RacingResult;

public class RacingResultViewHandler {

    public void handle(RacingResponse racing) {
        RacingResult racingResult = RacingResult.create(racing);
        RacingResultView racingResultView = RacingResultView.publish(racingResult);
        racingResultView.render();
    }
}
