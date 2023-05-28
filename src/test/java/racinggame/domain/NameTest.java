package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.Name;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    void create() {
        Name name = new Name("붕붕이");
        assertThat(name).isEqualTo(new Name("붕붕이"));
    }

    @Test
    @DisplayName("입력받는 이름이 5자 이상이면 에러가 발생")
    void valid() {
        assertThatThrownBy(() -> {
            new Name("helloWorld");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
