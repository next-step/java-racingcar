package race;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class CarMoveRuleTest {
    @Test
    void checkMove_랜덤값이_4이면_true를_반환한다() {
        Random mockRandom = createRandom(4);

        assertThat(CarRandomMoveRule.create(mockRandom).check()).isTrue();
    }

    @Test
    void checkMove_랜덤값이_4이상이면_true를_반환한다() {
        int randomValue = createRandomValue(4, Integer.MAX_VALUE);
        Random mockRandom = createRandom(randomValue);

        assertThat(CarRandomMoveRule.create(mockRandom).check()).isTrue();
    }

    @Test
    void checkMove_랜덤값이_4미만이면_false를_반환한다() {
        int randomValue = createRandomValue(Integer.MIN_VALUE, 4);
        Random mockRandom = createRandom(randomValue);

        assertThat(CarRandomMoveRule.create(mockRandom).check()).isFalse();
    }

    private static Random createRandom(int returnValue) {
        return new Random() {
            public int nextInt(int bound) {
                return returnValue;
            }
        };
    }

    private static int createRandomValue(int inclusiveStart, int exclusiveEnd) {
        return (int) (Math.random() * exclusiveEnd - 1) + inclusiveStart;
    }
}