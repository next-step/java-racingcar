package racingcar.domain.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    void Name_생성_테스트() {
        Name name = new Name("panda");
        assertThat(name.getName()).isEqualTo("panda");
    }

    @Test
    void Name_생성_예외_테스트() {
        assertThatThrownBy(() -> new Name(""))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Name("hyeonho"))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Name(null))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
