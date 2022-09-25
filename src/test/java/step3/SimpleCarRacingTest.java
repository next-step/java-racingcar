package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleCarRacingTest {

    @Test
    public void isGoStraight_4이상은직진이다() {
        Assertions.assertThat(GameRule.isGoStraight(1)).isFalse();
        Assertions.assertThat(GameRule.isGoStraight(5)).isTrue();
    }

    @Test
    public void tryMove_직진한다() {
        Car car = new Car(1);

        car.tryMove(1);

        Assertions.assertThat(car.getStraightCount()).isEqualTo(0);
    }

    private RacingCondition createRacingCondition(Integer carCount, Integer attemptCount) {
        return new RacingCondition(carCount, attemptCount);
    }

    @Test
    public void play_게임을시작한다() {
        RacingCondition racingCondition = createRacingCondition(3, 3);
        Game game = Game.prepare(racingCondition);

        Assertions.assertThat(game.isEnded()).isFalse();

        game.play();

        Assertions.assertThat(game.isEnded()).isTrue();
    }

}
