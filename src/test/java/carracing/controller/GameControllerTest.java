package carracing.controller;

import org.junit.jupiter.api.Test;

import carracing.view.ConsoleGameDashBoard;
import carracing.view.RacingCondition;

public class GameControllerTest {
    @Test
    public void play_게임을시작한다() {
        RacingCondition racingCondition = createRacingCondition(3, 3);
        GameController gameController = new GameController(new ConsoleGameDashBoard());
        gameController.play(racingCondition);
    }

    private RacingCondition createRacingCondition(Integer carCount, Integer attemptCount) {
        return new RacingCondition(carCount, attemptCount);
    }
}
