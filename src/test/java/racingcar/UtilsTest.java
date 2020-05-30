package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UtilsTest {
    @Test
    @DisplayName("0에서 9사이의 랜덤값을 가져온다.")
    void random() {
        //given
        //when
        int random = Utils.generateRandomNum();

        //then
        assertThat(random).isBetween(0, 9);
    }
}