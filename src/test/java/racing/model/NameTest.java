package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.*;

class NameTest {

    private static final String OVER_FIVE_IN_LENGTH = "123456";
    private static final String NORMAL_NAME = "mojh";

    @Test
    @DisplayName("이름을 생성할 때 5자를 초과할 경우 에러를 발생한다.")
    void constructorTestOverFiveinLengthError() {
        assertThatThrownBy(() -> new Name(OVER_FIVE_IN_LENGTH)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName("이름을 생성할 때 Null을 넣을 경우 에러를 발생한다.")
    void constructorTestNullOrBlank(String text) {
        assertThatThrownBy(() -> new Name(text)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름을 생성할 때 Null을 넣을 경우 에러를 발생한다.")
    void constructorTestNormal() {
        Name name = new Name(NORMAL_NAME);
        assertThat(name.getName()).isEqualTo(NORMAL_NAME);
    }
}