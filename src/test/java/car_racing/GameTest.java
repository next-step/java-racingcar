package car_racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void play_게임을시작한다() {

        RacingCondition racingCondition = createRacingCondition(3, 3);
        Cars cars = new Cars(racingCondition.carCount());
        Game game = Game.prepare(racingCondition.attemptCount(), cars);

        Assertions.assertThat(game.isEnded()).isFalse();

        game.play();

        Assertions.assertThat(game.isEnded()).isTrue();
    }

    private RacingCondition createRacingCondition(Integer carCount, Integer attemptCount) {
        return new RacingCondition(carCount, attemptCount);
    }
}
