package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Name;

public class NameTest {

    @Test
    @DisplayName("범위 내의 Name")
    public void name() {
        Assertions.assertThat(new Name("car")).isEqualTo(new Name("car"));
    }

    @ParameterizedTest
    @DisplayName("범위 외의 Name")
    @NullAndEmptySource
    @ValueSource(strings = {"longName"})
    public void nullAndEmptyName(String name) {
        Assertions.assertThatThrownBy(() -> {
            new Name(name);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
