package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberGeneratorTest {

    @Test
    void 움직임_조건은_숫자를_리턴한다() {
        NumberGenerator numberGenerator = new NumberGenerator(new RacingRandomNumber(1));
        int result = numberGenerator.moveCondition();
        assertEquals(1, result);
    }
}