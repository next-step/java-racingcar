package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("MAX_MOVE_VALUE 까지의 정수를 반환한다")
    void next() {
        //given
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        for (int i = 0; i < 50; i++) {
            //when
            int result = numberGenerator.next();

            //then
            assertThat(result).isBetween(0, 10);
        }
    }
}