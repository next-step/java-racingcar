package racingcarGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"--:---", "-:--"}, delimiter = ':')
    @DisplayName("자동차 이동 검증")
    public void moveCar(String input, String expected) {
        Car car = new Car(input);
        Car result = car.move();

        assertThat(result).isEqualTo(new Car(expected));
    }
}