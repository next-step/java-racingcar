package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest(name = "Name 조건을 만족하는 테스트: {0}")
    @ValueSource(strings = {"안녕", "hello", "hi"})
    void validName(String nameStr) {
        Name name = new Name(nameStr);
        assertThat(name.getName().length()).isEqualTo(nameStr.length());
    }

    @ParameterizedTest(name = "Name 조건을 만족하지 못하는 테스트: {0}")
    @ValueSource(strings = {"abcdedf", "6자초과이름"})
    void invalidName(String nameStr) {
        assertThatThrownBy(() -> new Name(nameStr))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("초과할 수 없습니다.");
    }

}
