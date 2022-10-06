package carracing;

import carracing.controller.GameController;
import carracing.view.ConsoleGameDashBoard;
import carracing.view.ConsoleInput;
import carracing.view.RacingCondition;

public class SimpleCarRacing {

    public static void main(String[] args) {
        RacingCondition racingCondition = new ConsoleInput().getInputs();

        GameController gameController = new GameController(new ConsoleGameDashBoard());

        gameController.play(racingCondition);
    }
}
