package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberGeneratorTest {

    @Test
    void 움직임_조건은_숫자를_리턴한다() {
        NumberGenerator numberGenerator = new NumberGenerator(new RacingRandomNumber(1));
        int result = numberGenerator.moveCondition();
        assertEquals(1, result);
    }

    @Test
    void 움직임_조건은_반드시_10_이내여_한다() {
        NumberGenerator numberGenerator = new NumberGenerator(new RacingRandomNumber(10));
        assertThatIllegalArgumentException().isThrownBy(() -> {
            numberGenerator.moveCondition();
        });

    }
}