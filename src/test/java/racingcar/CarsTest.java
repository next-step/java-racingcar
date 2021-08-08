package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarsTest {

    @DisplayName("Cars는")
    @ParameterizedTest(name = "전진규칙이 {0}이면 {1} 움직인다")
    @CsvSource(value = {"true:1:1", "false:0:0"}, delimiter = ':')
    void carMoveTest(boolean movable, int pos1, int pos2) {
        Cars cars = new Cars(2);
        assertThat(cars.move(() -> movable)).isEqualTo(new Cars(new Car(pos1), new Car(pos2)));
    }

    @DisplayName("Car의 수는 1이상의 정수이다.")
    @Test
    void numberOfCarHasToBeIntegerNotLessThanOne() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Cars(0)).withMessageMatching("자동차 수는 1 이상의 정수입니다.");
    }
}
