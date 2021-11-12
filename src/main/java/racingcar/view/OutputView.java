package racingcar.view;

import racingcar.domain.Cars;
import racingcar.domain.Winners;

public interface OutputView {
    void showOutputMessage();
    void showStartOfRound(int round);
    void showEndOfRound(int round);
    void showRacing(Cars cars);
    void showWinners(Winners winners);
}
