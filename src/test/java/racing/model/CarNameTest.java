package racing.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameTest {
    @DisplayName("자동차의 이름을 생성할 수 있다.")
    @Test
    void getTitleTest() {
        CarName sut = new CarName("Tesla");

        assertThat(sut.getTitle()).isEqualTo("Tesla");
    }

    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    @Test
    void carNameLengthTest() {
        assertThatThrownBy(() -> new Car("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("123456 is over 5 letters");
    }
}
