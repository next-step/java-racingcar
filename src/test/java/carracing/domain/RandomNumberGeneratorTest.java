package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @DisplayName("Random 객체가 생성한 값을 생성한다.")
    @Test
    public void randomNumberGenerateTest() {
        int fixedIntValue = 5;
        RandomNumberGenerator generator = RandomNumberGenerator.of(new MockRandom(fixedIntValue));
        assertThat(generator.generateRandomNumber())
                .isEqualTo(RandomNumber.of(fixedIntValue));
    }

    private static class MockRandom extends Random {

        private final int fixedIntValue;

        public MockRandom(int fixedIntValue) {
            this.fixedIntValue = fixedIntValue;
        }

        @Override
        public int nextInt(int bound) {
            return fixedIntValue;
        }
    }

}