package autoracing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RandomRacingRuleTest {
    @ParameterizedTest
    @ValueSource(ints = {Integer.MAX_VALUE, 1})
    public void boundMustBeGreaterThanZero(int bound) {
        assertThatCode(() -> {
            new RandomRacingRule(bound, 0);
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -1, 0})
    public void throwIllegalArgumentExceptionWhenBoundIsLessThanOrEqualToZero(int bound) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RandomRacingRule(bound, 0);
        }).withMessage("bound must be greater than zero.");
    }

    @Test
    public void drivingThresholdMustBeLessThanOrEqualToBound() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RandomRacingRule(10, 11);
        }).withMessage("drivingThreshold must be less than, or equal to bound.");
    }

    @ParameterizedTest
    @CsvSource({"0,false", "1,false", "2,false", "3,false", "4,true", "5,true", "6,true", "7,true", "8,true", "9,true"})
    public void shouldGoForward(int generatingNumber, boolean expectedGoForward) {
        RandomRacingRule rule = new RandomRacingRule(10, 4, (bound) -> generatingNumber);
        assertThat(rule.canGoForward()).isEqualTo(expectedGoForward);
    }
}
