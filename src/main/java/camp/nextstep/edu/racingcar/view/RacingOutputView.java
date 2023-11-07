package camp.nextstep.edu.racingcar.view;

import camp.nextstep.edu.racingcar.domain.result.RacingGameResult;

public interface RacingOutputView {

    void printRequestCarAmount();
    void printRequestRoundAmount();
    void printGameResult(RacingGameResult gameResult);
}
