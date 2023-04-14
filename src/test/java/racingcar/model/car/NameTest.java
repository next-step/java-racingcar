package racingcar.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {
    @Test
    @DisplayName("5글자 초과 이름의 경우 예외 발생")
    public void length() {
        String overFive = "123456";
        assertThatThrownBy(() -> new Name(overFive))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름은 비어있거나 `null`일 수 없음")
    public void nullOrEmpty(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("동등 판단이 가능해야 한다")
    public void equals() {
        Name name1 = new Name("hi");
        Name name2 = new Name("hi");

        assertThat(name1).isEqualTo(name2);
    }

    @Test
    @DisplayName("`toString`은 실제 문자열 값을 나타내야 함")
    public void string() {
        String raw = "hi";
        Name name = new Name(raw);

        assertThat(name.toString()).isEqualTo(raw);
    }
}