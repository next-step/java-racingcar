package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class NameTest {

    @Test
    @DisplayName("자동차 이름 빈값 체크")
    void validateIsBlank() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Name("");
        });
    }

    @Test
    @DisplayName("자동차 이름 길이 체크")
    void validateLength() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           new Name("justhis");
        });
    }
}
