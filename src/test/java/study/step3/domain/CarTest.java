package study.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("차량 생성 테스트")
    public void createCar() {
        // given
        int startPosition = 0;
        Car car = new Car(startPosition);
        int expectedPosition = 0;

        // when

        // then
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }

    @Test
    @DisplayName("차량 전진 테스트")
    public void moveForward() {
        // given
        String carShape = "-";
        int startPosition = 0;
        Car car = new Car(startPosition);
        int expectedPosition = 1;

        // when
        car.moveForward();

        // then
        assertThat(car.getPosition()).isEqualTo(expectedPosition);
    }
}
