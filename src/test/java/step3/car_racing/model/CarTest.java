package step3.car_racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("car 초기 거리 설정 테스트")
    void moveInit() {
        // given
        Car car = new Car();

        // expected
        assertThat(car.getDistance()).isEqualTo("-");
    }

    @Test
    @DisplayName("랜덤값 테스트 : isForword 가 true 이면 전진")
    void moveForward() {
        // given
        Car car = new Car();

        // when
        car.move(Boolean.TRUE);

        // then
        assertThat(car.getDistance().length()).isGreaterThan(1);
    }

    @Test
    @DisplayName("랜덤값 테스트 : isForword 가 false 이면 제자리")
    void moveStay() {
        // given
        Car car = new Car();

        // when
        car.move(Boolean.FALSE);

        // then
        assertThat(car.getDistance().length()).isEqualTo(1);
    }
}