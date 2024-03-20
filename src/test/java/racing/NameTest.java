package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Name;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @Test
    @DisplayName("설정한 이름으로 Name 객체 생성")
    public void nameCreationTest() {
        Name name = new Name("테스트");
        assertThat(name.getName()).isEqualTo("테스트");
    }

    @Test
    @DisplayName("정해진 규칙 이상의 길이일 경우 에러 발생")
    public void nameValidationTest() {
        assertThatThrownBy(() -> new Name("다섯글자이상자동차")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 다섯 글자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("이름으로 빈 값이 들어올 때 에러 발생")
    public void emptyNameValidation() {
        assertThatThrownBy(() -> new Name("")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 빈 값일 수 없습니다.");
    }
}
