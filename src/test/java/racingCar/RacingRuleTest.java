package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingRuleTest {


    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("0부터 3까지의 숫자가 들어오면 false 반환")
    void isMovable_Return_False(int input) {
        Assertions.assertThat(RacingRule.isMovable(input)).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 6, 7, 8, 9})
    @DisplayName("5부터 9까지의 숫자가 들어오면 true 반환")
    void isMovable_Return_True(int input) {
        Assertions.assertThat(RacingRule.isMovable(input)).isEqualTo(true);
    }

}
