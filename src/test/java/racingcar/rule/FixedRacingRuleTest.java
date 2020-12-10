package racingcar.rule;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.RacingCarDriver;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

public class FixedRacingRuleTest {

    @ParameterizedTest
    @CsvSource(value = {"-1", "10"})
    @DisplayName("범위 밖의 숫자가 주어졌을 때 오류가 발생하는지 테스트")
    public void moveOver(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new FixedRacingRule(Integer.parseInt(input));
        });
    }
}