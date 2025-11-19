package racingCar;


import org.junit.jupiter.api.Test;
import racingCar.domain.Name;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class NameTest {
    @Test
    void 생성() {
        Name name = new Name("name");

        assertThat(name.value()).isEqualTo( "name");
    }

    @Test
    void 이름의_글이는_5글자_초과되면_안됨() {
        assertThatThrownBy(() -> {
            new Name("namesss");
        }).isInstanceOf(RuntimeException.class);
    }
}
