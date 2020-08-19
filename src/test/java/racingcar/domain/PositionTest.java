package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.strategy.DoOneForward;
import racingcar.strategy.RaceCondition;

import static org.assertj.core.api.Assertions.assertThat;


public class PositionTest {

    @Test
    void OneForwardPosition() {
        Car car1 = new Car(new Position(3));
        RaceCondition alwaysOneForward = () -> true;
        car1.move(alwaysOneForward, new DoOneForward());
        assertThat(car1.getPosition().getPosition()).isEqualTo(4);
    }

    @Test
    void ZeroForwardPosition() {
        Car car2 = new Car(new Position(3));
        RaceCondition alwaysZeroForward = () -> false;
        car2.move(alwaysZeroForward, new DoOneForward());
        assertThat(car2.getPosition().getPosition()).isEqualTo(3);
    }
}
