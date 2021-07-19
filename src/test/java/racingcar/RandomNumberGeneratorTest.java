package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    void 랜덤번호_0_9_테스트() throws Exception {
        for (int i = 0; i < 1_000; i++) {
            int randomNumber = RandomNumberGenerator.generate();
            boolean actual = isNumberLessThanTen(randomNumber);
            Assertions.assertThat(actual).isTrue();
        }
    }

    private boolean isNumberLessThanTen(int number) {
        return ((number >= 0) && (number < 10));
    }
}