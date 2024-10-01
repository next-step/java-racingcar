package race;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class CarRaceGameRuleTest {
    @Test
    void checkMove_랜덤값이_4이면_true를_반환한다() {
        assertThat(CarRaceGameRule.checkMove(createRandom(4))).isTrue();
    }

    @Test
    void checkMove_랜덤값이_4이상이면_true를_반환한다() {
        int returnValue = getRandomValue(4, Integer.MAX_VALUE);
        assertThat(CarRaceGameRule.checkMove(createRandom(returnValue))).isTrue();
    }

    @Test
    void checkMove_랜덤값이_4미만이면_true를_반환한다() {
        int returnValue = getRandomValue(Integer.MIN_VALUE, 3);
        assertThat(CarRaceGameRule.checkMove(createRandom(returnValue))).isFalse();
    }

    private Random createRandom(int returnValue) {
        return new Random() {
            public int nextInt(int bound) {
                return returnValue;
            }
        };
    }

    private static int getRandomValue(int min, int max) {
        return (int) (Math.random() * max) + min;
    }
}
