package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @ParameterizedTest(name = "입력 숫자 {0}은 0을 반환한다.")
    @ValueSource(ints = {0, 1, 2, 3})
    public void moveForward_ShouldReturnZero(int inputValue) {
        int expectedValue = 0;

        Car car = new Car();
        car.moveForward(inputValue);

        assertThat(car.getCurrentPosition()).isEqualTo(expectedValue);
    }

    @ParameterizedTest(name = "입력 숫자 {0}은 1을 반환한다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void moveForward_ShouldReturnOne(int inputValue) {
        int expectedValue = 1;

        Car car = new Car();
        car.moveForward(inputValue);

        assertThat(car.getCurrentPosition()).isEqualTo(expectedValue);
    }
}
