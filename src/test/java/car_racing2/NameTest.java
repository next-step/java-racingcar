package car_racing2;

import car_racing2.model.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class NameTest {
    @Test
    @DisplayName("자동차 이름이 공백이면 예외가 발생해야 한다.")
    void nameCannotBeBlank() {
        assertThatThrownBy(() -> new Name(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("5글자를 초과하는 이름을 생성하면 예외를 던진다.")
    void shouldThrowWhenLengthOver5() {
        assertThatThrownBy(() -> new Name("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상적인 자동차 이름이면 객체가 정상적으로 생성되어야 한다.")
    void validNameShouldBeAccepted() {
        String normalName = "abcde";
        Name name = new Name(normalName);
        assertThat(name.getName()).isEqualTo(normalName);
    }

}
