package race.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    @DisplayName("생성 테스트")
    void create() {
        final String testName = "test";
        final Name name = new Name(testName);

        assertThat(name)
                .isEqualTo(new Name(testName));
    }

    @Test
    @DisplayName("이름이 5글자를 초과하면 IllegalArgumentException 발생")
    void nameMoreThan5() {
        assertThatThrownBy(() -> new Name("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
