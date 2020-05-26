package racingCar.domain.moveStrategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMoveTest {

    @ParameterizedTest
    @CsvSource(value = {"4,4,true","2,9,false"})
    @DisplayName("Boolean 값이 잘 나오는지")
    void isMove(int random, int MOVABLE_MIN, boolean expected) {
        boolean result = random >= MOVABLE_MIN;
        assertThat(result).isEqualTo(expected);
    }
}
