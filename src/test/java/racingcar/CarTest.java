package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {

    private Car car;

    @BeforeEach
    void setup(){
        car = new Car();
    }

    @Test
    @DisplayName("매개변수가 4 이상일 경우 state 1 증가 테스트")
    void increaseState() {
        car.increaseState(4);
        Assertions.assertThat(car.getState()).isEqualTo(1);
    }
}
