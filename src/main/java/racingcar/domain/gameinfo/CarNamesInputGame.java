package racingcar.domain.gameinfo;

import racingcar.domain.model.Cars;
import racingcar.domain.gameround.GameRound;
import racingcar.domain.model.CarNameInfo;
import racingcar.domain.model.CountInfo;
import racingcar.domain.moverule.MoveRule;

import java.util.*;

public class CarNamesInputGame implements GameInfo {

    private final List<CarNameInfo> carNames;
    private final MoveRule moveRule;
    private final CountInfo tryCount;
    private final GameRound gameRound;

    public CarNamesInputGame(MoveRule moveRule, GameRound gameRound, CountInfo tryCount, List<CarNameInfo> carNames){
        this.moveRule = moveRule;
        this.carNames = carNames;
        this.tryCount = tryCount;
        this.gameRound = gameRound;
    }

    @Override
    public MoveRule getMoveRule() {
        return this.moveRule;
    }

    @Override
    public Cars getCars() {
        return new Cars(carNames);
    }

    @Override
    public int getTryCount() {
        return this.tryCount.get();
    }

    @Override
    public GameRound getGameRound() {
        return gameRound;
    }

    @Override
    public boolean printWinners() {
        return true;
    }
}