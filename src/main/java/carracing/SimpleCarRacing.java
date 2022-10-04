package carracing;

import carracing.model.Cars;
import carracing.controller.Game;
import carracing.view.ConsoleGameDashBoard;
import carracing.view.ConsoleInput;
import carracing.view.RacingCondition;

public class SimpleCarRacing {

    public static void main(String[] args) {
        RacingCondition racingCondition = new ConsoleInput().getInputs();

        Cars cars = new Cars(racingCondition.carCount());

        Game game = new Game(racingCondition.attemptCount(), cars, new ConsoleGameDashBoard());

        game.play();
    }
}
