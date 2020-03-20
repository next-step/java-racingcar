package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumGeneratorTest {
    @DisplayName("10 이하의 숫자만 발생된다.")
    @ParameterizedTest
    @CsvSource(value = {"10:10", "4:4", "5:5", "23:23"}, delimiter = ':')
    void generateNumberLessThanTest(int bound, int expectedMax) {
        //given
        RandomNumGenerator generator = new RandomNumGenerator();

        //when
        int random = generator.generateNumberLessThan(bound);

        //then
        assertThat(random).isLessThan(expectedMax);
    }
}