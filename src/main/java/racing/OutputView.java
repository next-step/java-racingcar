package racing;

import java.util.List;
import racing.module.RacingGameDriver;

public class OutputView {

    private static final String GAME_RESULT = "실행 결과";
    private RacingGameDriver racingGameDriver;
    private int turnTime;


    public OutputView(List<Car> cars, int turnTime) {
        this.racingGameDriver =  new RacingGameDriver.Builder(cars).build();
        this.turnTime = turnTime;
    }

    public void printResult(){
        System.out.println(GAME_RESULT);

        for(int i = 0; i < turnTime; i++){
            racingGameDriver.nextTurn();
        }
    }


}
