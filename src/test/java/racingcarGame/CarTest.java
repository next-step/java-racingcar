package racingcarGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcarGame.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"3:0", "4:1", "5:1"}, delimiter = ':')
    @DisplayName("자동차 이동 검증")
    public void moveCar(int chosenNumber, int expected) {
        Car result = new Car(0);
        result.move(chosenNumber);

        assertThat(result).isEqualTo(new Car(expected));
    }
}