package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.RacingGameException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarNameTest {

    @Test
    @DisplayName("생성자 테스트: 이름이 5자 이상이면 RacingGameException 발생")
    void crate() {
        RacingCarName underFive = new RacingCarName("four");

        assertThatThrownBy(() -> new RacingCarName("sixxxx"))
                .isInstanceOf(RacingGameException.class);
    }

}
