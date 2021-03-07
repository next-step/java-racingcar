import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameConditionTest {

    @Test
    void randomNumber() {
        assertThat(GameCondition.randomNumber(10))
                .isBetween(0, 9);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:true", "2:false"}, delimiter = ':')
    void isAdvance(int input, boolean expected) {
        assertThat(GameCondition.isAdvance(input))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:true", "a:false"}, delimiter = ':')
    void isInteger(String input, boolean expected) {
        assertThat(GameCondition.isInteger(input))
                .isEqualTo(expected);
    }
}