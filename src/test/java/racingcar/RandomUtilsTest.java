package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.RandomUtils;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("랜덤숫자 생성하는 유틸")
class RandomUtilsTest {
    @Test
    @DisplayName("0에서 9사이의 랜덤값을 가져온다.")
    void random() {
        //given
        //when
        int random = RandomUtils.generateRandomNum();

        //then
        assertThat(random).isBetween(0, 9);
    }
}