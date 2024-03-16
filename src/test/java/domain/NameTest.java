package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class NameTest {

    @DisplayName("5글자 이하의 이름을 생성할 수 있다.")
    @Test
    void test01() {
        assertThatCode(() -> {
            // given
            String name = "forbi";

            // when / then
            Assertions.assertThat(new Name(name)).isEqualTo(new Name(name));
        }).doesNotThrowAnyException();
    }

    @DisplayName("5글자를 초과하는 이름은 생성할 수 없다.")
    @Test
    void test02() {
        // given
        String name = "Oliver";

        // when / then
        Assertions.assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자를 초과할 수 없습니다.");
    }
}
