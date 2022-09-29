package step4.domain;

import step4.strategy.MoveStrategy;

import java.util.List;

public class RacingGameHandler {

    private RacingGame racingGame;
    private MoveStrategy moveStrategy;

    public RacingGameHandler(RacingGame racingGame, MoveStrategy moveStrategy) {
        this.racingGame = racingGame;
        this.moveStrategy = moveStrategy;
    }

    public void playWithMoveStrategy(){
        while(!racingGame.isEnd()){
            racingGame.race(moveStrategy);
        }
    }

    public List<RacingRecords> getRacingRecords(){
        return racingGame.getRacingRecordsStorage();
    }

    public List<String> winners(){
        return racingGame.winners();
    }


}
