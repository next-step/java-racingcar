package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("랜덤넘버 생성 테스트")
    void test() {
        final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        final int generate = randomNumberGenerator.generate();

        assertThat(generate).isBetween(0, 9);
    }
}