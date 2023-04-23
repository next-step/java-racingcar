package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("전진또는스톱")
    void 전진또는스톱() {
        Car car = new Car("bmw");

        // 스톱 테스트
        car.moveForwardOrStop(3);
        Assertions.assertThat(car.getDistance()).isEqualTo(0);

        // 전진 테스트
        car.moveForwardOrStop(4);
        Assertions.assertThat(car.getDistance()).isEqualTo(1);

    }

    @Test
    @DisplayName("거리비교")
    void 거리비교() {
        Car car = new Car("bmw", 4);

        Assertions.assertThat(car.equalsDistance(4)).isTrue();
    }
}
