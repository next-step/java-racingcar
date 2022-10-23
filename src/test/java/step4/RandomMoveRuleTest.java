package step4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomMoveRuleTest {
    @Test
    void Random_값은_0_9_사이() {
        RandomMoveRule rule = new RandomMoveRule();

        assertThat(rule.getRandomNum()).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }
}
