package racing;

import java.util.List;
import java.util.stream.IntStream;
import racing.module.OutputView;
import racing.module.RacingGameEngine;
import racing.module.UserInput;

public class RacingGame {

    public static void main(String[] args) {
        RacingGame.start();
    }

    public static void start(){
        UserInput userInput = new UserInput();
        List<Car> cars = userInput.settingCarsByUserInput();
        int turnTime = userInput.settingTurnCountByUserInput();

        RacingGameEngine racingGameEngine = new RacingGameEngine.Builder(cars).build();
        IntStream.range(0, turnTime).forEach(turn -> racingGameEngine.executeTurn());

        OutputView outputView = new OutputView(racingGameEngine.getRacingMap());
        outputView.printResult();
    }

}
