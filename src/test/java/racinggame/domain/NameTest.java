package racinggame.domain;

import calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @DisplayName("Name 객체 생성 테스트")
    @Test
    void createName() throws Exception {
        String excepted = "jae";
        Name name = new Name(excepted);

        assertThat(name).isNotNull();
        assertThat(name.getName()).isEqualTo(excepted);
    }

    @DisplayName("이름이 5글자를 초과하면 객체가 예외가 발생한다.")
    @Test
    void createNameFail() throws Exception {
        String name = "jaehan";

        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 자동차의 이름은 5글자 이하여야 합니다.");
    }
}
