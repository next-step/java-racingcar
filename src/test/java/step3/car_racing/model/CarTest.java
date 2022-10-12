package step3.car_racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("car 초기 거리 설정 테스트")
    void moveInit() {
        // given
        String name = "이상원";
        Car car = new Car().initCar(name);

        // expected
        assertThat(car.getDistance()).isEqualTo("-");
    }

    @Test
    @DisplayName("랜덤값 테스트 : move 가 true 이면 전진")
    void moveForward() {
        // given
        String name = "이상원";
        Car car = new Car().initCar(name);

        // when
        car.move(() -> true);

        // then
        assertThat(car.getDistance().length()).isGreaterThan(1);
    }

    @Test
    @DisplayName("랜덤값 테스트 : move 가 false 이면 제자리")
    void moveStay() {
        // given
        String name = "이상원";
        Car car = new Car().initCar(name);

        // when
        car.move(() -> false);

        // then
        assertThat(car.getDistance().length()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차를 생성하고 이름을 확인한다.")
    void getName() {
        // given
        String name = "이상원";

        // when
        Car car = new Car().initCar(name);

        // then
        assertThat(car.getName()).isEqualTo(name);
    }
}
