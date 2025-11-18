package carracing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    @DisplayName("정상 생성된 이름")
    void name() {
        assertThat(new Name("kim")).isEqualTo(new Name("kim"));
    }

    @Test
    @DisplayName("자동차의 이름은 5글자를 초과할 수 없다")
    void nameSize() {
        assertThatThrownBy(() -> new Name("longKim")).isInstanceOf(RuntimeException.class);
    }
}