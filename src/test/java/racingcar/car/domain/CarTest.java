package racingcar.car.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.domain.Car;

public class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("a");
    }

    @Test
    @DisplayName("랜덤값이 4 이상일 경우 1칸 전진한다.")
    void test1() {
        car.move(4);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤값이 3 이하일 경우 움직이지 않는다.")
    void test2() {
        car.move(3);
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }
}
