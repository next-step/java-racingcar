package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static step3.domain.Car.DEFAULT_POSITION;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    void createCarTest() {
        Car carCreated = new Car();

        assertThat(carCreated).isNotNull();
        assertThat(carCreated.getPosition()).isEqualTo(DEFAULT_POSITION);
    }

    @DisplayName("차량 전진 요청 시 위치 전진한다.")
    @Test
    void carProceedTest() {
        assertThat(car.getPosition()).isEqualTo(1);

        car.proceed();

        assertThat(car.getPosition()).isEqualTo(2);
    }

}