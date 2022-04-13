package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @Test
    void equals() {
        assertThat(new CarName("pobi")).isEqualTo(new CarName("pobi"));
    }

    @DisplayName("이름 유효성 검사")
    @Test
    void validation() {
        assertThatThrownBy(() -> new CarName("longer than 5 characters"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new CarName(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new CarName(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

}