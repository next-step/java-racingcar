package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @DisplayName("이동 시 랜덤한 값이 4 이상인 경우 전진한다.")
    @Test
    void test01() {
        // given
        MoveStrategy moveStrategy = () -> true;
        Car car = new Car(moveStrategy);

        // when
        car.move();

        // then
        assertThat(car.position()).isEqualTo(new Position(1));
    }

    @DisplayName("이동 시 랜덤한 값이 4 미만인 경우 멈춘다.")
    @Test
    void test02() {
        // given
        MoveStrategy moveStrategy = () -> false;
        Car car = new Car(moveStrategy);

        // when
        car.move();

        // then
        assertThat(car.position()).isEqualTo(new Position(0));
    }

    @DisplayName("자동차에 5자 이하의 길이를 가진 이름을 부여할 수 있다.")
    @Test
    void test03() {
        // given
        String name = "pobi";

        // when
        Car car = new Car(name, () -> true);

        // then
        assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("5자를 초과하는 이름인 경우 예외가 발생한다.")
    @Test
    void test04() {
        // given
        String name = "pobicon";

        // when / then
        Assertions.assertThatThrownBy(() -> new Car(name, () -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자를 초과할 수 없습니다.");
    }
}
