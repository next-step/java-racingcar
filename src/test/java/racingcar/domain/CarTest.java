package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("toby");
    }

    @Test
    void maxPosition() {
        // given
        Car car1 = new Car("kim", 3);
        // then
        Assertions.assertThat(car1.maxPosition(0)).isEqualTo(3);
    }
    @Test
    @DisplayName("포지션 일치 하면 true 값을 리턴한다.")
    void matchPosition() {
        Assertions.assertThat(car.matchPosition(0)).isTrue();
    }
    @Test
    @DisplayName("자동차의 이름이 5자를 초과하면 예외가 발생한다.")
    void name() {
        // given
        // when
        Assertions.assertThatThrownBy(() -> new Car("kimbro", 0))
                .isInstanceOf(IllegalArgumentException.class);
        // then
    }

    @Test
    @DisplayName("자동차는 앞으로 이동할 수 있다.")
    void move() {
        car.move();
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }
}
