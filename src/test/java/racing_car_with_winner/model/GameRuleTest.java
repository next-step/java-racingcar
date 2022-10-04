package racing_car_with_winner.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameRuleTest {

    @ParameterizedTest
    @CsvSource(value = {"1: false", "4: true"}, delimiter = ':')
    void canMove(int value, boolean expected) {
        Assertions.assertThat(GameRule.canMove(value)).isEqualTo(expected);
    }

}