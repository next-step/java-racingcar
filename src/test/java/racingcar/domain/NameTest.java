package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    @DisplayName("이름 생성 테스트")
    public void create() throws Exception {
        Name name = new Name("sean");
        assertThat(name).isEqualTo(new Name("sean"));
    }

    @Test
    @DisplayName("null 검증 테스트")
    public void checkNull() throws Exception {
        assertThatThrownBy(() -> new Name(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    @DisplayName("빈 값 검증 테스트")
    public void checkEmpty(String name) throws Exception {
        assertThatThrownBy(() -> new Name(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"seongbeen", "is so tired", "it's 4:07am"})
    @DisplayName("5자 초과 검증 테스트")
    public void checkLength(String name) throws Exception {
        assertThatThrownBy(() -> new Name(name)).isInstanceOf(IllegalArgumentException.class);
    }
}