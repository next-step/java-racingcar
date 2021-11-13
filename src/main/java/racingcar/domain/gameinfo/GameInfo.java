package racingcar.domain.gameinfo;

import racingcar.domain.model.Cars;
import racingcar.domain.gameround.GameRound;
import racingcar.domain.moverule.MoveRule;

public interface GameInfo {
    MoveRule getMoveRule();
    Cars getCars();
    int getTryCount();
    GameRound getGameRound();
    boolean printWinners();
}