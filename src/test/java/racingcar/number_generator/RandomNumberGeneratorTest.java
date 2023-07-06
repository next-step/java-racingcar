package racingcar.number_generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {
    
    @Test
    @DisplayName("0에서 9 사이의 랜덤한 숫자를 반환한다")
    public void 영에서_9_사이의_랜덤한_숫자를_반환한다() throws Exception {
        RandomNumberGenerator randomGenerator = new RandomNumberGenerator();
        int number = randomGenerator.generate();
        assertThat(number).isBetween(0, 9);
    }
}
