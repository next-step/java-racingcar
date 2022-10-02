package step5.domain;

import step5.strategy.MoveStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        return Collections.unmodifiableList(racingGame.winners());
    }


}
