package racingcar.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void init() {
        this.car = new Car();
    }

    @Test
    @DisplayName("Car 처음 위치 0 테스트")
    void car_처음_위치_0() {
        assertThat(car.getPosition().getPosition()).isEqualTo(0);
    }
}
