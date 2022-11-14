package race.domian;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    void 정상적으로_이름_생성() {
        Name name = new Name("jihye");
        assertThat(name.getName()).isEqualTo("jihye");
    }

    @Test
    void 이름_공백_불가() {
        assertThatThrownBy(() -> {
            new Name("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 이름_5글자_초과_불가() {
        assertThatThrownBy(() -> {
            new Name("wisdom");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}