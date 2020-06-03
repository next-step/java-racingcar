package autoracing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RandomRacingRuleTest {
    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE, -3297392, -1, 0})
    public void boundMustBeGreaterThanZero(int bound) {
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
}
