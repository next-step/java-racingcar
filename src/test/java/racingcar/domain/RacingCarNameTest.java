package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingCarNameTest {

    @Test
    @DisplayName("5글자 넘는 문자열로 이름 설정시 validate 테스트")
    void validateNameLongerThenFive() {
        assertThrows(IllegalArgumentException.class, () -> new RacingCarName("5글자넘어요"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 값으로 이름 설정시 validate 테스트")
    void validateNameIsEmpty(String name) {
        assertThrows(IllegalArgumentException.class, () -> new RacingCarName(name));
    }
}
