package racingcar.winner.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameRuleTest {

    @ParameterizedTest
    @CsvSource(value = {"1: false", "4: true"}, delimiter = ':')
    void canMove(int value, boolean expected) {
        assertThat(GameRule.canMove(value)).isEqualTo(expected);
    }

}