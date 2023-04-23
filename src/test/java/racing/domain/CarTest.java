package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {

    @Test
    @DisplayName(value = "자동차 이름은 5자를 초과할 수 없다")
    void test1() {
        assertThatIllegalArgumentException()
                .isThrownBy(()->new Car("abcdef"));
    }

    @Test
    @DisplayName(value = "이동")
    void test2() {
        Car car = new Car("abc");
        car.move(6);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName(value = "정지")
    void test3() {
        Car car = new Car("abc");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
