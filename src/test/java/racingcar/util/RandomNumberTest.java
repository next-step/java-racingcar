package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberTest {

    @DisplayName("0 ~ 9 사이의 임의의 숫자를 생성한다.")
    @Test
    void generate() {
        int randomNumber = RandomNumber.pick();
        assertThat(randomNumber).isLessThan(10);
    }

}