package race.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {

    @Test
    void nameTest() {
        assertThat(new Name("임형준")).isEqualTo(new Name("임형준"));
    }

    @Test
    void nameLengthGreaterThanFive() {
        assertThatThrownBy(() -> {
            new Name("자바지기박재성");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5글자를 초과할 수 없습니다.");
    }
}
