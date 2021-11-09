package racing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("3단계 - 자동차 경주 - Car 단위 테스트")
class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    @DisplayName("자동차 전진 기능")
    void go() {
        car.go();
        car.go();
        car.go();

        assertThat(car.getMovingDistance())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 정지 기능")
    void stopCar() {
        Car car = new Car();

        // 아무것도 하지않으면 정지

        assertThat(car.getMovingDistance())
                .isEqualTo(0);
    }
}