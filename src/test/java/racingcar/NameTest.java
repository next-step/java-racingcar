package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    @DisplayName("name")
    public void name() {
        Assertions.assertThat(new Name("car")).isEqualTo(new Name("car"));
        Assertions.assertThatThrownBy(() -> {
            new Name("");
        }).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> {
            new Name("longName");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
