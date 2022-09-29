package car_racing;

import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void play_게임을시작한다() {
        RacingCondition racingCondition = createRacingCondition(3, 3);

        Cars cars = new Cars(racingCondition.carCount(), new MovableStrategy<Integer>() {
            @Override
            public Integer getCondition() {
                return 1;
            }

            @Override
            public boolean predicate(Integer condition) {
                return true;
            }
        });

        Game game = new Game(racingCondition.attemptCount(), cars, new ConsoleGameDashBoard());

        game.play();
    }

    private RacingCondition createRacingCondition(Integer carCount, Integer attemptCount) {
        return new RacingCondition(carCount, attemptCount);
    }
}
