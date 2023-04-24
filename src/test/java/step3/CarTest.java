package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void car_init_location() {
        assertThat(new Car("name").getLocation()).isZero();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("자동차 이동 요청 거리가 4미만일 때는 이동을 안함")
    void go1(int distance) {
        Car car = new Car("abc");
        car.go(distance);

        assertThat(car.isLocated(0)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    @DisplayName("자동차 이동 요청 거리가 4이상일 때 정상 적으로 이동")
    void go2(int distance) {
        Car car = new Car("abc");
        car.go(distance);

        assertThat(car.isLocated(distance)).isTrue();
    }

    @Test
    void isLocated() {
        Car car = new Car("abc");
        int goDistance = 4;
        car.go(goDistance);

        assertThat(car.isLocated(goDistance)).isTrue();
    }
}
