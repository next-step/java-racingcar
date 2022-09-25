package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import step3.SimpleCarRacing.Car;
import step3.SimpleCarRacing.GameRule;

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

}
