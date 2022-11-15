package race.domian;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

class NameTest {

    @Test
    void 정상적으로_이름_생성() {
        Name name = new Name("jihye");
        assertThat(name.getName()).isEqualTo("jihye");
    }

    @DisplayName("이름이 비어있을 경우 예외 발생")
    @NullAndEmptySource
    @ParameterizedTest
    void emptyName(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(name));
    }

    @Test
    void 이름_5글자_초과_불가() {
        assertThatThrownBy(() -> {
            new Name("wisdom");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}