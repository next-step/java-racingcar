package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @DisplayName("생성된 숫자가 4이상이면 움직일 수 있다 ")
    @ParameterizedTest
    @ValueSource(ints = {4, 8})
    void carMove(int randomNumber) {
        Car expected = car.changeCarPosition(car, randomNumber);
        assertThat(expected.getPosition()).isEqualTo(1);
    }

    @DisplayName("생성된 숫자가 4보다 작으면 움직일 수 없다 ")
    @ParameterizedTest
    @ValueSource(ints = {1, 3})
    void carNotMove(int randomNumber) {
        Car expected = car.changeCarPosition(car, randomNumber);
        assertThat(expected.getPosition()).isEqualTo(0);
    }
}
