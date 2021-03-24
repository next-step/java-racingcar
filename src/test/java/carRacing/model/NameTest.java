package carRacing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    private Name name;

    @BeforeEach
    void initialNameTest() {
        name = new Name("test");
    }

    @Test
    @DisplayName("create name test")
    void createTest() {
        assertThat(name).isEqualTo(new Name("test"));
    }

    @Test
    @DisplayName("validation position test : noname")
    void validTest() {
        assertThatThrownBy(() -> new Name("")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("자동차 이름을 입력하세요.");
    }

    @Test
    @DisplayName("validation position test : long name")
    void validTest2() {
        assertThatThrownBy(() -> new Name("123456")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("자동차 이름은 5자 이하로 입력해주세요.");
    }
}