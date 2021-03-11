package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @ParameterizedTest(name = "입력 숫자 {0}은 {1}을 반환한다.")
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    public void moveForward_ShouldReturnZero(int inputValue, int expectedValue) {
        Car car = new Car();
        car.moveForward(inputValue);

        assertThat(car.getCurrentPosition()).isEqualTo(expectedValue);
    }

}
