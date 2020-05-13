package me.daeho.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 테스트")
class CarTest {

    @DisplayName("전진 테스트")
    @Test
    public void forwardTest() {
        assertThat(Car.ready().forward()).isEqualTo(1);
    }

    @DisplayName("정지 테스트")
    @Test
    public void stopTest() {
        Car car = Car.ready();

        int currentPosition = car.forward();

        assertThat(car.stop()).isEqualTo(currentPosition);
    }
}