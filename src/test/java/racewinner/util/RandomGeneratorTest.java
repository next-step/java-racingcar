package racewinner.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGeneratorTest {
    @DisplayName("number()는 항상 0에서 10사이의 값을 반환 한다.")
    @RepeatedTest(5)
    void getNumberTest() {
        // given
        final RandomGenerator generator = new RandomGenerator();

        // when
        final int number = generator.number();

        //then
        assertThat(number >= 0 && number <= 10).isTrue();
    }
}