package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    @DisplayName("0-9 까지 생성한다.")
    @RepeatedTest(1000)
    void test01() {
        NumberGenerator numberGenerator = new DefaultNumberGenerator();
        assertThat(numberGenerator.generator()).isBetween(0, 9);
    }
}
