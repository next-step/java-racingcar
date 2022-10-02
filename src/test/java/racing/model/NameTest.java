package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameTest {

    private static final String OVER_FIVE_IN_LENGTH = "123456";
    private static final String BLANK = "";

    @Test
    @DisplayName("이름을 생성할 때 5자를 초과할 경우 에러를 발생한다.")
    void constructorTestOverFiveinLengthError() {
        assertThatThrownBy(() -> new Name(OVER_FIVE_IN_LENGTH)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름을 생성할 때 빈값을 넣을 경우 에러를 발생한다.")
    void constructorTestBlank() {
        assertThatThrownBy(() -> new Name(BLANK)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름을 생성할 때 Null을 넣을 경우 에러를 발생한다.")
    void constructorTestNull() {
        assertThatThrownBy(() -> new Name(null)).isInstanceOf(IllegalArgumentException.class);
    }
}