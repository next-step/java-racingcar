package racingcar.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.strategy.condition.RaceCondition;
import racingcar.domain.car.strategy.raceStrategy.DoOneForward;

import static org.assertj.core.api.Assertions.assertThat;

public class StrategyTest {

    @DisplayName("1만큼 전진 전략 확인")
    @Test
    void OneForwardPosition() {
        Car car = new Car("pobi");
        RaceCondition alwaysOneForward = () -> true;
        car.move(alwaysOneForward, new DoOneForward());

        int expected = 1;

        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @DisplayName("0만큼 전진, 즉 멈춤 전략 확인")
    @Test
    void ZeroForwardPosition() {
        Car car = new Car("crong");
        RaceCondition alwaysZeroForward = () -> false;
        car.move(alwaysZeroForward, new DoOneForward());

        int expected = 0;

        assertThat(car.getPosition()).isEqualTo(expected);
    }
}
