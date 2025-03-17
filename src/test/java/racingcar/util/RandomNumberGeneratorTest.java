package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @DisplayName("랜덤 값의 생성 결과는 0부터 9 사이이다.")
    @RepeatedTest(100)
    void generateNumber() {
        assertThat(RandomNumberGenerator.generateNumber())
                .isBetween(0, 9);
    }
}
