package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingSupporterTest {

    @ParameterizedTest
    @DisplayName("숫자에따라 자동차가 움직인다.")
    @CsvSource(value = {"3,1", "4,2", "0,1", "9,2"})
    void judgeRace(int number, int expectedPosition) {
        Car car = new Car();
        RacingSupporter.judgeRace(car, number);
        Assertions.assertThat(car.valueOfCurrentPosition()).isEqualTo(expectedPosition);
    }

}
