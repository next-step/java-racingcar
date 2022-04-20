package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    private static final String CAR_NAME_MAXIMUM_LENGTH_EXCEEDED_ERR_MSG = "자동차의 이름은 5자를 초과할 수 없습니다.";

    @Test
    @DisplayName("자동차 이름 5자 이내로 생성")
    void createCarNameWithinFiveCharacters() {
        String name = "abc";

        CarName carName = new CarName(name);

        assertThat(carName.getValue()).isEqualTo(name);
    }

    @Test
    @DisplayName("자동차 이름 5자 초과로 생성할 경우, 예외처리")
    void exceptionCreateMoreThanFiveCharacters() {
        String name = "abcdef";

        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(CAR_NAME_MAXIMUM_LENGTH_EXCEEDED_ERR_MSG);
    }
}
