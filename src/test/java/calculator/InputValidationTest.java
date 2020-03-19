package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidationTest {
    InputValidator validator;

    @BeforeEach
    void setup() {
        validator = new InputValidator();
    }

    @DisplayName("입력값이 null 또는 빈 공백일 경우 체크")
    @Test
    void inputCheckTest() {
        String data = "1+2";
        assertThatThrownBy(() -> {
            validator.nullCheck(data);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException")
    @Test
    public void operatorCheckTest() {
        String data = "*";
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->{
            validator.operatorCheck(data);
        });
    }
}
