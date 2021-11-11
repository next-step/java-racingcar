package racingcar.gameinfo;

import racingcar.domain.Cars;
import racingcar.moverule.MoveRule;
import racingcar.view.result.ResultView;

public interface GameInfo {
    MoveRule getMoveRule();
    Cars getCars();
    int getTryCount();
    ResultView getResultView();
}