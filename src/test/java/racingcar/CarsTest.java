package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarsTest {

    @DisplayName("Cars는")
    @ParameterizedTest(name="전진규칙이 {0}이면 {1} 움직인다")
    @CsvSource(value = {"true:1:1", "false:0:0"}, delimiter = ':')
    void carsMove테스트(boolean movable, int car1Pos, int car2Pos) {
        Cars cars = new Cars(2);
        assertThat(cars.move(new MoveRuleByRandomValue(movable))).isEqualTo(new Cars(new Car(car1Pos), new Car(car2Pos)));
    }

    @DisplayName("Car의 수는 1이상의 정수이다.")
    @Test
    void numberOfCarHasToBeIntegerNotLessThanOne() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Cars(0)).withMessageMatching("자동차 수는 1 이상의 정수입니다.");
    }
}
