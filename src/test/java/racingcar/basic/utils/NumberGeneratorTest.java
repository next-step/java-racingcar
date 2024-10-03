package racingcar.basic.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.basic.utils.NumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    @Test
    @DisplayName("랜덤값이 0에서 9 사이의 값인지 확인한다.")
    void 랜덤값_반환() {
        int randomNumber = NumberGenerator.randomNumber();
        assertThat(randomNumber).isGreaterThan(0)
                .isLessThan(9);
    }
}
