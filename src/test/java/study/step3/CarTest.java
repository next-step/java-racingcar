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
        assertThat(car.getPower()).isGreaterThanOrEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 4, 6, 9, 10})
    @DisplayName("주행할 거리를 구한다.")
    public void getForwardDistance(int power) {
        assertThat(car.getForwardDistance(power)).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("현재 위치를 가져온다.")
    public void getPosition() {
        assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("이동한다.")
    public void move() {
        int beforePosition = car.getPosition();
        car.move();
        int afterPosition = car.getPosition();
        assertThat(afterPosition).isGreaterThanOrEqualTo(beforePosition);
    }

}
