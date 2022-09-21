package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    @DisplayName("0 이상 9 이하의 랜덤한 숫자 생성")
    @RepeatedTest(100)
    void random() {
        int number = RandomNumberGenerator.generateLessThan(10);

        assertThat(number).isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }
}
