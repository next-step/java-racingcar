package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void setup() {
        car = new Car();
    }

    @Test
    @DisplayName("전진 조건이 만족하면 전진 테스트")
    void move() {
        car.increaseState(() -> true);
        assertThat(car.getState()).isEqualTo(1);
    }

    @Test
    @DisplayName("전진 조건이 만족하지 않으면 멈춤 테스트")
    void stop() {
        car.increaseState(() -> true);
        assertThat(car.getState()).isEqualTo(0);
    }

    @Test
    @DisplayName("이름있는 자동차 생성 테스트")
    void createCarWithName() {
        Car car = new Car("jeje");
        assertThat(car.getName()).isEqualTo("jeje");
    }
}
