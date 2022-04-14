package racingcar.racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class NumberGeneratorTest {

    @Test
    void generateNumber() {
        NumberGenerator numberGenerator = new NumberGenerator(10);

        int result = numberGenerator.generateNumber();

        assertThat(result).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
    }
}