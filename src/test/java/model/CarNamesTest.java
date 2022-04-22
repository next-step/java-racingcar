package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNamesTest {

    @ParameterizedTest
    @ValueSource(strings = {"chopa", "nami", "sang", "a", "bc"})
    void 정상적인_이름_입력할때(String name) {
        assertThat(new CarName(name).getName()).isEqualTo(name);
    }

    @Test
    void 공백의_이름일때_에러_발생() {
        final String ERROR_MESSAGE = "자동차의 이름은 공백일 수 없습니다.";

        assertThatThrownBy(() -> new CarName(""))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"sanghyuk", "minsuo", "gorrrg"})
    void 자동차의_이름이_5글자_초과할때_에러_발생(String name) {
        final String ERROR_MESSAGE = "자동차의 이름은 5글자를 초과할 수 없습니다.";

        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage(ERROR_MESSAGE);
    }
}
