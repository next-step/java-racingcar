package racing;

import java.util.List;
import racing.module.RacingGameDriver;
import racing.module.UserInput;

public class RacingGame {

    private static final String GAME_RESULT = "실행 결과";

    public static void main(String[] args) {
        RacingGame.start();
    }

    public static void start(){
        UserInput userInput = new UserInput();
        List<Car> cars = userInput.settingCarsByUserInput();
        int turnTime = userInput.settingTurnCountByUserInput();

        System.out.println(GAME_RESULT);

        RacingGameDriver racingGameDriver = new RacingGameDriver.Builder(cars).build();
        for(int i = 0; i < turnTime; i ++){
            racingGameDriver.nextTurn();
        }
    }

}
