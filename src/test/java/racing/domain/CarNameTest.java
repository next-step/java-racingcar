package racing.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import racing.exception.GameException;

class CarNameTest {
    @DisplayName("자동차이름은 5글자를 초과할 수 없다.")
    @Test
    void name_length() {
        assertThatThrownBy(() -> new CarName("solari"))
                .isInstanceOf(GameException.class)
                .hasMessageContaining("car name length can't exceed 5");
    }

    @NullAndEmptySource
    @DisplayName("자동차이름은 비워둘 수 없다.")
    @ParameterizedTest
    void name_can_not_be_empty(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(GameException.class)
                .hasMessageContaining("car name can't be empty");
    }
}
