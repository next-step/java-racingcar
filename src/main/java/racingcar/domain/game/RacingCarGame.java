package racingcar.domain.game;

import racingcar.domain.model.Cars;
import racingcar.domain.gameinfo.GameInfo;
import racingcar.domain.gameround.GameRound;
import racingcar.domain.moverule.MoveRule;

public class RacingCarGame {

    private final int tryCount;
    private final GameRound gameRound;
    private final MoveRule moveRule;
    private final Cars cars;

    public RacingCarGame(GameInfo info) {
        this.tryCount = info.getTryCount();
        this.gameRound = info.getGameRound();
        this.moveRule = info.getMoveRule();
        this.cars = info.getCars();
    }

    public GameResult start() {
        GameResult result = new GameResult();
        for(int count = 0; count < this.tryCount ; count++){
            cars.playGame(this.moveRule);
            result.addRoundResult(this.gameRound.getResult(cars));
        }
        result.addWinnersResult(this.cars);
        return result;
    }
}