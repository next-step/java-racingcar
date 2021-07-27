package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    void name_null_또는_blank() {
        assertThatThrownBy(() -> new Name(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Name(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Name("   "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void name_5자_이하() {
        Name pobi = new Name("pobi");
        assertThat(pobi).isEqualTo(new Name("pobi"));
    }

    @Test
    void name_5자_초과() {
        assertThatThrownBy(() -> new Name("aavegotchi"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
