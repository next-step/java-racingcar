package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    void 랜덤_넘버를_생성한다() {
        // given
        final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // when
        final int randomNumber = randomNumberGenerator.generate();

        // then
        assertThat(randomNumber).isBetween(0, 9);
    }
}
