package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @DisplayName("자동차를 생산한다.")
    @Test
    void test01() {
        Car car = new Car();

        assertThat(car.position()).isEqualTo(0);
    }

    @DisplayName("4 이상일 경우 전진한다.")
    @Test
    void test02() {
        Car car = new Car();

        car.move(4);

        assertThat(car.position()).isEqualTo(1);
    }

    @DisplayName("4 미만일 경우 움직이지 않는다.")
    @Test
    void test03() {
        Car car = new Car();

        car.move(3);

        assertThat(car.position()).isEqualTo(0);
    }
}
