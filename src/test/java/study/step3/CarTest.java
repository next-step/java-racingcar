package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 테스트")
public class CarTest {

    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 7, 10})
    @DisplayName("파워(엔진출력)를 구한다.")
    public void getPower(int max) {
        assertThat(car.getPower(max)).isGreaterThan(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 6, 9, 10})
    @DisplayName("주행할 거리를 구한다.")
    public void getForwardDistance(int power) {
        assertThat(car.getForwardDistance(power)).isGreaterThan(0);
    }

}
