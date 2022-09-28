package racingcarGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private static final String POSITION_SHOW_MARK = "-";

    @ParameterizedTest
    @CsvSource(value = {"1:2", "2:3"}, delimiter = ':')
    @DisplayName("자동차 이동 검증")
    public void moveCar(int input, int expected) {

        Car car = new Car(input, getCarMovement(input));
        Car result = car.move();

        assertThat(result).isEqualTo(new Car(expected, getCarMovement(expected)));
    }

    private String getCarMovement(int position) {
        String result = "";

        for (int i = 0; i < position; i++) {
            result += POSITION_SHOW_MARK;
        }

        return result;
    }
}