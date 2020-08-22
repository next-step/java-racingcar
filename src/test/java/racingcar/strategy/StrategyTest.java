package racingcar.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;

public class StrategyTest {

    @DisplayName("1만큼 전진 전략 확인")
    @Test
    void OneForwardPosition() {
        Car car1 = new Car(new Position(3));
        RaceCondition alwaysOneForward = () -> true;
        car1.move(alwaysOneForward, new DoOneForward());
        int actual = car1.getPosition();
        assertThat(actual).isEqualTo(4);
    }

    @DisplayName("0만큼 전진, 즉 멈춤 전략 확인")
    @Test
    void ZeroForwardPosition() {
        Car car2 = new Car(new Position(3));
        RaceCondition alwaysZeroForward = () -> false;
        car2.move(alwaysZeroForward, new DoOneForward());
        int actual = car2.getPosition();
        assertThat(actual).isEqualTo(3);
    }
}
