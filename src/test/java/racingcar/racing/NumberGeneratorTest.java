package racingcar.racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.generator.Generator;
import racingcar.generator.NumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;


class NumberGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {5})
    void generateNumber(int tryNumber) {
        Generator<Integer,Integer> numberGenerator = new NumberGenerator();

        for(int i = 0; i < tryNumber; i++ ) {
            int result = numberGenerator.generate(10);

            assertThat(result).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
        }

    }
}