package racingcar.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class RandomNumberGeneratorTest {

    RandomNumberGenerator randomGenerator;

    @BeforeEach
    public void setUp() {
        randomGenerator = new RandomNumberGenerator();
    }

    @Test
    @DisplayName("0~9사이의 난수를 생성하여 반환한다")
    public void should_return_random_number_from_0_to_10() {
        assertThat(randomGenerator.generatorNumber(10)).isBetween(0, 9);
    }

}