package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingGameHandler {

    private RacingGame racingGame;
    private MoveStrategy moveStrategy;

    public RacingGameHandler(RacingGame racingGame, MoveStrategy moveStrategy){
        this.racingGame = racingGame;
        this.moveStrategy = moveStrategy;
    }

    public List<List<Integer>> playWithMoveStrategy(){
        List<List<Integer>> racingResult = new ArrayList<>();

        while(!racingGame.isEnd()){
            racingGame.race(moveStrategy);
            racingResult.add(racingGame.currentPositions());
        }

        return racingResult;
    }



}
