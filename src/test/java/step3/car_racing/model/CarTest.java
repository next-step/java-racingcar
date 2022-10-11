package step3.car_racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.car_racing.util.RandomUtil;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("car 초기 거리 설정 테스트")
    void moveForward() {
        // given
        Car car = new Car();

        // expected
        assertThat(car.getDistance()).isEqualTo("-");
    }

    @Test
    @DisplayName("랜덤값 테스트 : isForword가 true 이면 전진, 아니면 그대로")
    void random() {
        // given
        Car car = new Car();
        Boolean forward = RandomUtil.isForward();

        // expected
        if (forward) {
            assertThat(car.getDistance().length()).isGreaterThan(1);
        }
        assertThat(car.getDistance().length()).isEqualTo(1);
    }
}