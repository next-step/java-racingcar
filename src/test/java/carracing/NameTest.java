package carracing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

/**
 * 1. 자동차 이름은 필수값이다.
 * 2. 자동차 이름은 5글자 이상을 넘을 수 없다.
 */
public class NameTest {
    @Test
    void create() {
        Name name = new Name("pobi");
        assertThat(name).isEqualTo(new Name("pobi"));
    }

    @Test
    void empty_name() {
        assertThatThrownBy(() -> {
            new Name();
        }).hasMessage("자동차 이름은 필수값입니다.");
    }

    @Test
    void nameLength_over6() {
        assertThatThrownBy(() -> {
            new Name("abcdef");
        }).hasMessage("5글자를 초과하였습니다.");
    }
}
