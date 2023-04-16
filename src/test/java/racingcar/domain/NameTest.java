package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @DisplayName("이름을 생성한다.")
    @Test
    void test01() {
        Name name = new Name("rang");

        assertThat(name).isEqualTo(new Name("rang"));
    }

    @DisplayName("자동차의 이름은 5글자를 넘길 수 없다.")
    @Test
    void test02() {
        assertThatThrownBy(() -> new Name("saerang"))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
