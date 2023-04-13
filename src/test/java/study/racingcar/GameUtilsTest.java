package study.racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class GameUtilsTest {

    @DisplayName("올바른 랜덤 값을 생성하는지 테스트")
    @RepeatedTest(100)
    void range_is_between_zero_to_nine() {
        // given
        int randomNumber = GameUtils.randomNumber();

        // when, then
        Assertions.assertThat(randomNumber).isBetween(0, 9);
    }

}