package carracing;

import carracing.domain.Name;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {
    @Test
    @DisplayName("자동차이름이 5글자가 초과할 경우 익셉션 테스트")
    void checkNameNumberOverFive() {
        Assertions.assertThatThrownBy(() -> {
                    new Name("kimwoo");
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5글자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차이름이 비어있는경우 익셉션 테스트")
    void checkNameEmpty() {
        Assertions.assertThatThrownBy(() -> {
                    new Name("");
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 값이 존재해야 합니다.");
    }
}
