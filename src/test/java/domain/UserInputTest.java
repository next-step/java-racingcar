package domain;

import static domain.UserInput.isOverOne;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserInputTest {


    @ParameterizedTest(name = "User 의 입력값이 0 이거나 음수이면 에러표시 : {0} 일 때")
    @ValueSource(ints = {0, -1, -2, -3})
    void isNotOverOne(int element) {
        assertThatThrownBy(() -> isOverOne(element))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0 이상의 정수만 입력 가능합니다.");

    }
}
