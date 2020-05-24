package racingCar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingGameInfoTest {

    @Test
    @DisplayName("빈 문자열 예외처리")
    void RacingGameInfoException1() {
        String[] names = {" ", "", "abc"};
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingGameInfo(names, 3));
    }

    @Test
    @DisplayName("차 대수 or 경기 수 예외처리")
    void RacingGameInfoException2() {
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingGameInfo(new String[]{"abc"}, 0));
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingGameInfo(new String[]{"", " "}, 2));
    }
}
