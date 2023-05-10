package carracing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    void create() {
        String name = "hello";
        Name carName = new Name(name);
        assertThat(name).isEqualTo(carName.get());
    }

    @Test
    void createNameWithInvalidLength() {
        String name = "tooLongName";
        assertThatThrownBy(() -> new Name(name)).isInstanceOf(IllegalArgumentException.class).hasMessage("자동차 이름은 5글자를 초과할 수 없습니다. 입력받은 이름: " + name);
    }
}
