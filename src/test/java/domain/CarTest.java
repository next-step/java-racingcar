package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @DisplayName("이동 시 랜덤한 값이 4 이상인 경우 전진한다.")
    @Test
    void test01() {
        // given
        int moveCount = 1;
        Car car = new Car(moveCount, () -> true);

        // when
        Position position = car.move();

        // then
        Assertions.assertThat(position.getPosition()).isEqualTo(1);
    }

    @DisplayName("이동 시 랜덤한 값이 4 미만인 경우 멈춘다.")
    @Test
    void test02() {
        // given
        int moveCount = 1;
        Car car = new Car(moveCount, () -> false);

        // when
        Position position = car.move();

        // then
        Assertions.assertThat(position.getPosition()).isEqualTo(0);
    }
}
