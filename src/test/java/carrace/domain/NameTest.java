package carrace.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class NameTest {

    @Test
    @DisplayName("이름 최대 입력 가능 길이 Exception")
    void maxLength() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                Name name = new Name("apollo");
        }).withMessage("자동차 이름은 최대 5자까지 허용됩니다.");
    }

    @Test
    @DisplayName("공백 이름 Exception")
    void minLength() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Name name = new Name("");
                }).withMessage("자동차 이름은 공백일 수 없습니다.");
    }
}
