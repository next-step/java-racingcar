package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"2:0", "3:0", "4:1", "5:1"}, delimiter = ':')
    @DisplayName("숫자가 4 이상이 나오면 자동차는 움직일 수 있다")
    void moveTest(int number, int expectedPosition) {
        Car car = new Car();
        car.move(new RandomForTest(number));
        int actualPosition = car.getPosition();
        Assertions.assertThat(actualPosition).isEqualTo(expectedPosition);
    }
}
