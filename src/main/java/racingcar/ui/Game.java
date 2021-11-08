package racingcar.game;

import racingcar.ui.inputview.InputView;
import racingcar.ui.resultview.ResultView;

public interface Game {
    void start(InputView iv, ResultView rv);
}
