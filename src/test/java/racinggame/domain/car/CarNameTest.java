package racinggame.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @DisplayName("5글자 초과할 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"apeach", "frodo2"})
    void validate1(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("5글자를 초과하였습니다.");
    }

    @DisplayName("이름이 null 또는 빈값일 경우 예외 발생")
    @NullAndEmptySource
    @ParameterizedTest
    @ValueSource(strings = {"     ", " "})
    void validate2(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름을 입력해주세요.");
    }
}