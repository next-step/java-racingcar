package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static racingcar.Constants.*;
import racingcar.strategy.DoOneForward;
import racingcar.strategy.RaceCondition;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    Car car = new Car(0);

    //핵심로직/UI로직 테스트와 무관한 테스트 꼭 확인
    @DisplayName("Car 초기 position 0에서 시작")
    @Test
    public void assertCarInitPositionIsZero() {
        assertThat(car.getPosition()).isEqualTo(INIT_POSITION);
    }

    /**
     * Mocking Test (random 추상화)
     */

    @DisplayName("Car 전진 1 가능")
    @Test
    public void assertCarCanOneForward() {
        RaceCondition alwaysOneForwardCond = () -> true;
        assertThat(car.move(alwaysOneForwardCond, new DoOneForward()))
                .isEqualTo(ONE_FORWARD);
    }

    @DisplayName("Car 전진 0 가능")
    @Test
    public void assertCarCanZeroForward() {
        RaceCondition alwaysZeroForwardCond = () -> false;
        assertThat(car.move(alwaysZeroForwardCond, new DoOneForward()))
                .isEqualTo(ZERO_FORWARD);  }
}
