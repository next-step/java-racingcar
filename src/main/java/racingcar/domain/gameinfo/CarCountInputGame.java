package racingcar.domain.gameinfo;

import racingcar.domain.model.Cars;
import racingcar.domain.gameround.GameRound;
import racingcar.domain.model.CountInfo;
import racingcar.domain.moverule.MoveRule;

public class CarCountInputGame implements GameInfo {

    private final CountInfo carCount;
    private final CountInfo tryCount;
    private final MoveRule moveRule;
    private final GameRound gameRound;

    public CarCountInputGame(MoveRule moveRule, GameRound gameRound, CountInfo carCount, CountInfo tryCount){
        this.moveRule = moveRule;
        this.carCount = carCount;
        this.tryCount = tryCount;
        this.gameRound = gameRound;
    }

    @Override
    public int getTryCount() {
        return this.tryCount.get();
    }

    @Override
    public GameRound getGameRound() {
        return this.gameRound;
    }

    @Override
    public boolean printWinners() {
        return false;
    }

    @Override
    public Cars getCars() {
        return new Cars(this.carCount.get());
    }

    @Override
    public MoveRule getMoveRule() {
        return this.moveRule;
    }
}