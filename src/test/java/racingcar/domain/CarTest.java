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
    @DisplayName("자동차이름허용길이초과")
    void 자동차이름허용길이초과() {
        assertThatThrownBy(() -> {
            Car car = new Car("hyundai");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차이름조회")
    void 자동차이름조회() {
        Car car = new Car("bmw");

        Assertions.assertThat(car.getName()).isEqualTo("bmw");
    }

}
