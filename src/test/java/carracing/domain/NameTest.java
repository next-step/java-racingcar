package carracing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    public void createName() {
        Name name = new Name("rami");
        assertThat(name).isEqualTo(new Name("rami"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "가나다라마바", " "})
    public void positionIllegalException(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
