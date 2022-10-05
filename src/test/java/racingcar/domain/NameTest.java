package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @ParameterizedTest
    @DisplayName("자동차 이름은 null 이거나 비어있을 수 없다.")
    @NullSource
    @EmptySource
    void null_or_empty_car_name(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1글자 보다 작을 수 없다.");
    }

    @Test
    @DisplayName("자동차 이름은 5글자를 초과할 수 없다.")
    void car_name_length_over_5() {
        assertThatThrownBy(() -> new Name("over5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5글자를 초과할 수 없다.");
    }
}
