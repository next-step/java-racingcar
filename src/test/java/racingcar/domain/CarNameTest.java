package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @Test
    void equals() {
        assertThat(new CarName("pobi")).isEqualTo(new CarName("pobi"));
    }

    @DisplayName("이름 유효성 검사")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"long name"})
    void validation(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }


}