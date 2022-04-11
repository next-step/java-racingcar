package racing;

import java.util.List;
import racing.module.RacingGameEngine;

public class OutputView {

    private static final String GAME_RESULT = "실행 결과";
    private RacingGameEngine racingGameEngine;
    private int turnTime;


    public OutputView(List<Car> cars, int turnTime) {
        this.racingGameEngine =  new RacingGameEngine.Builder(cars).build();
        this.turnTime = turnTime;
    }

    public void printResult(){
        System.out.println(GAME_RESULT);

        for(int i = 0; i < turnTime; i++){
            racingGameEngine.executeTurn();
        }
    }


}
