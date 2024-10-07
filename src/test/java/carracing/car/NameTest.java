package carracing.car;

import carracing.car.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @DisplayName("자동차 이름을 생성한다.")
    @Test
    void create_carName() {
        Name name = new Name("moon");

        assertThat(name).isEqualTo(new Name("moon"));
    }

    @DisplayName("자동차 이름이 5자를 초과하면 IllegalArgumentException을 발생시킨다.")
    @Test
    void throw_IllegalArgumentException_when_length_is_over_5() {
        assertThatThrownBy(() -> new Name("oooooo"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @DisplayName("String 타입의 value를 반환한다.")
    @Test
    void return_value() {
        Name name = new Name("moon");

        assertThat(name.getValue()).isEqualTo("moon");
    }
}