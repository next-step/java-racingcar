package strcalculator.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringProcessorTest {


    @Test
    @DisplayName("숫자와 사칙연산을 제외한 문자가 들어왔는지 확인")
    public void inputValidation() {
        StringProcessor stringProcessor = new StringProcessor("1+++2+3+++");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            stringProcessor.validation();
        });
    }
}
