package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ConditionTest {
    @ParameterizedTest
    @CsvSource(value = {"true:4", "false:1", "true:8", "true:5", "false:1", "false:3"}, delimiter = ':')
    public void checkMove(boolean result, int iNumber) {
        Assertions.assertThat(Condition.checkMove(iNumber)).isEqualTo(result);
    }
}
