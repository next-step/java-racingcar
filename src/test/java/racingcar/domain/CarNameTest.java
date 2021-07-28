package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarNameTest {

    @DisplayName("자동차 이름이 null 또는 공백일 경우 예외가 발생한다.")
    @ParameterizedTest(name = "자동차 이름 : {0}")
    @NullAndEmptySource
    void nullOrEmpty(String name) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new CarName(name));
    }

    @DisplayName("자동차 이름의 길이는 5를 초과할 수 없다.")
    @Test
    void maxLength() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new CarName("newcar"));
    }
}