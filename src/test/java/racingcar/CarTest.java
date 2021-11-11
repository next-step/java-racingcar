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
    @DisplayName("매개변수가 4 이상일 경우 state 1 증가 테스트")
    void increaseState() {
        car.increaseState(4);
        assertThat(car.getState()).isEqualTo(1);
    }

    @Test
    @DisplayName("이름있는 자동차 생성 테스트")
    void createCarWithName() {
        Car car = new Car("jeje");
        assertThat(car.getName()).isEqualTo("jeje");
    }
}
