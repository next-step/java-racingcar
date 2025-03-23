package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {
    @DisplayName("자동차의 이름을 가지는 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        Name car = new Name("Tesla");

        Name sut = new Name("Tesla");

        assertThat(sut).isEqualTo(car);
    }

    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    @Test
    void validateTest() {
        assertThatThrownBy(() -> new Car("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("123456 is over 5 letters");
    }
}
