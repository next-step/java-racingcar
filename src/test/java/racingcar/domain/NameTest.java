package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    @DisplayName("이름이 1자 이상 5자 이하면 정상적으로 생성된다")
    void generateInstanceSuccessTest(String name) {
        assertDoesNotThrow(() -> Name.of(name));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef", "abcdefghijklmn"})
    @DisplayName("이름이 0자거나 5자 초과면 에러가 발생한다")
    void generateInstanceFailTest(String name) {
        Assertions.assertThatThrownBy(() -> Name.of(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Name 값이 같으면 같은 포지션이다.")
    void testEquals() {
        Name name1 = Name.of("a");
        Name name2 = Name.of("a");
        Assertions.assertThat(name1).isEqualTo(name2);
    }

    @Test
    @DisplayName("Name 값이 같으면 같은 hashCode를 가져야 한다.")
    void testHashCode() {
        Name name1 = Name.of("a");
        Name name2 = Name.of("a");
        Assertions.assertThat(name1.hashCode()).isEqualTo(name2.hashCode());
    }
}
