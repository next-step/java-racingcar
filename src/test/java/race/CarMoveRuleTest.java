package race;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarMoveRuleTest {
    @Test
    void checkMove_랜덤값이_4이면_true를_반환한다() {
        IRandomValueGenerator fixedValueGenerator = MockRandomValueGenerator.createThatGenerate(4);
        assertThat(CarMoveRule.with(fixedValueGenerator).check()).isTrue();
    }

    @Test
    void checkMove_랜덤값이_4이상이면_true를_반환한다() {
        IRandomValueGenerator fixedValueGenerator = MockRandomValueGenerator.createThatGenerate(getRandomValue(4,
                Integer.MAX_VALUE));
        assertThat(CarMoveRule.with(fixedValueGenerator).check()).isTrue();
    }

    @Test
    void checkMove_랜덤값이_4미만이면_false를_반환한다() {
        IRandomValueGenerator fixedValueGenerator =
                MockRandomValueGenerator.createThatGenerate(getRandomValue(Integer.MIN_VALUE, 4));
        assertThat(CarMoveRule.with(fixedValueGenerator).check()).isFalse();
    }

    private static int getRandomValue(int min, int max) {
        return (int) (Math.random() * max - 1) + min;
    }
}