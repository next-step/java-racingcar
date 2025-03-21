package step4.racingcar2.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.racingcar2.exception.RacingCarNameException;

public class RacingCarNameTest {

    @Test
    @DisplayName("5글자 초과 자동차 이름")
    void givenCarNameGreaterThan5_whenCreateRacingCarName_thenThrowException() {
        // given
        String overLengthCarName = "abcdef";

        // when
        assertThatThrownBy(() -> new RacingCarName(overLengthCarName))

            //then
            .isExactlyInstanceOf(RacingCarNameException.class);
    }

    @Test
    @DisplayName("5글자 이하 자동차 이름")
    void givenCarNameLessThan5_whenCreateRacingCarName_thenNotThrowException() {
        // given
        String underLengthCarName = "abcde";

        // when
        // then
        assertDoesNotThrow(() -> new RacingCarName(underLengthCarName));
    }
}
