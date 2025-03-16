package edu.nextstep.camp.carracing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void generateRandomNumber(int bound) {
        assertThat(RandomNumberGenerator.generateRandomNumber(bound)).isBetween(0, bound - 1);
    }
}
