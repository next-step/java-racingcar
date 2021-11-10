package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    void 이름_생성_성공() {
        Name name = new Name("chang");
        assertThat(name).isEqualTo(new Name("chang"));
    }

    @Test
    void 이름_생성_실패() {
        assertThatThrownBy(() -> {
            new Name("HelloWorld");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
