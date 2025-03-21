package step5.racingcar3.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.racingcar3.exception.CarNameException;

public class CarNameTest {

    @Test
    @DisplayName("5글자 이하의 자동차 이름은 통과")
    void given5MoreLengthCarName_whenCreateCarName_thenSuccess() {
        // given
        String name = "abcde";

        // when
        // then
        assertDoesNotThrow(() -> new CarName(name));
    }

    @Test
    @DisplayName("5글자 초과의 자동차 이름은 실패")
    void given5LessLengthCarName_whenCreateCarName_thenFail() {
        // given
        String name = "abcdef";

        // when
        assertThatThrownBy(() -> new CarName(name)).

            // then
            isExactlyInstanceOf(CarNameException.class);
    }

    @Test
    @DisplayName("앞/뒤 공백을 제외하고 5글자 이하의 자동차 이름은 통과")
    void given5MoreLengthCarNameWithoutBlank_whenCreateCarName_thenSuccess() {
        // given
        String name = " a b c ";

        // when
        // then
        assertDoesNotThrow(() -> new CarName(name));
    }

    @Test
    @DisplayName("앞/뒤 공백을 제외하고 5글자 초과의 자동차 이름은 실패")
    void given5LessLengthCarNameWithoutBlank_whenCreateCarName_thenFail() {
        // given
        String name = " q w e r ";

        // when
        assertThatThrownBy(() -> new CarName(name)).

            // then
            isExactlyInstanceOf(CarNameException.class);
    }

}
