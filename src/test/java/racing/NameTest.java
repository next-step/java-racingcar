package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NameTest {
    @Test
    @DisplayName("이름 생성")
    void create() {
        Name name = new Name("하하");
        assertThat(name).isEqualTo(new Name("하하"));
    }

    @Test
    @DisplayName("빈값 입력시  테스트")
    void empty_name_then_Exception() {
        assertThatThrownBy(()-> {new Name("");})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름을 입력하세요.");
    }

    @Test
    @DisplayName("다섯자를 초과하는 이름을 입력한 경우 익셉션")
    void exceeding_5_characters_then_exception() {
        Assertions.assertThatThrownBy(()-> {new Name("하이머딩거다");})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름 다섯자 초과");
    }
}
