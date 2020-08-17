package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.strategy.DoOneForward;
import racingcar.strategy.OneForwardCondition;
import racingcar.strategy.RaceCondition;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.Constants.*;

public class PositionTest {

    @Test
    void OneForwardPosition() {
        Car car1 = new Car(new Position(3));
        RaceCondition alwaysOneForward = () -> true;
        assertThat(car1.move(alwaysOneForward, new DoOneForward( )).getPosition( ))
                .isEqualTo(4);
    }

    @Test
    void ZeroForwardPosition() {
        Car car2 = new Car(new Position(3));
        RaceCondition alwaysZeroForward = () -> false;
        assertThat(car2.move(alwaysZeroForward, new DoOneForward()).getPosition())
                .isEqualTo(3);
    }
}
