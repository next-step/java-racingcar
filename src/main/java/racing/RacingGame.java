package racing;

import java.util.List;
import racing.module.OutputView;
import racing.module.UserInput;

public class RacingGame {

    public static void main(String[] args) {
        RacingGame.start();
    }

    public static void start(){
        UserInput userInput = new UserInput();
        List<Car> cars = userInput.settingCarsByUserInput();
        int turnTime = userInput.settingTurnCountByUserInput();

        OutputView outputView = new OutputView(cars, turnTime);
        outputView.printResult();
    }

}
