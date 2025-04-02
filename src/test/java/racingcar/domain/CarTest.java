package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("random 값이 경계값 이상이면 전진한다.")
    void moveIfUpperMovableValue() {
        assertThat(new Car("car").move(new MoveStrategy(() -> 4))).isTrue();
        assertThat(new Car("car").move(new MoveStrategy(() -> 3))).isFalse();
    }

}