package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CarNameTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null이나 빈 값이 들어오는 경우 CarName 생성에 실패한다.")
    void failToCreate_withNullOrEmpty(String name) {
        assertThatThrownBy(() -> {
            new CarName(name);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력 값이 누락되었습니다.");
    }

    @Test
    @DisplayName("5자 이상의 문자열이 들어오는 경우 CarName 생성에 실패한다.")
    void failToCreate_withOverLengthString() {
        assertThatThrownBy(() -> {
            new CarName("ppanya");
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("5자 이하의 이름만 입력 가능합니다.");
    }
}