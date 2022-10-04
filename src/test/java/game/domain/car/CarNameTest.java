package game.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @Test
    void create() {
        CarName carName = new CarName("car");

        assertThat(carName).isEqualTo(new CarName("car"));
    }

    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    @Test
    void valid() {
        org.junit.jupiter.api.Assertions.assertAll(
                () -> assertThat(new CarName("name")).isEqualTo(new CarName("name")),
                () -> assertThatThrownBy(() -> new CarName("overLength")).isInstanceOf(IllegalArgumentException.class)
        );
    }
}
