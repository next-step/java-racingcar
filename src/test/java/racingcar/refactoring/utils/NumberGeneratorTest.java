package racingcar.refactoring.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.refactoring.utils.NumberGenerator.generateRandomNumber;

class NumberGeneratorTest {

    @Test
    @DisplayName("랜덤값이 0에서 9 사이의 값인지 확인한다.")
    void 랜덤값_반환_검증() {
        int randomNumber = generateRandomNumber();
        assertThat(randomNumber).isGreaterThan(0)
                .isLessThan(9);
    }
}
