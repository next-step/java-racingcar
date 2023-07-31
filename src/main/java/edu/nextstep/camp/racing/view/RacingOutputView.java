package edu.nextstep.camp.racing.view;

import edu.nextstep.camp.racing.domain.RacingResult;

import java.util.List;

public interface RacingOutputView {

    void racingResultView(List<RacingResult> racingResults, List<String> winners);
}
