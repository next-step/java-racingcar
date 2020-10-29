package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = Validator.getInstance();
    }
    @Test
    @DisplayName("validateInput 함수 테스트")
    void validateInput() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    validator.validateInput(null);
                }).withMessageMatching(Const.NULL_ERROR_MSG);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    validator.validateInput("");
                }).withMessageMatching(Const.EMPTY_ERROR_MSG);
    }

    @Test
    @DisplayName("validateArray 함수 테스트")
    void validateArray() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    String[] array = "2".split(" ");
                    validator.validateArray(array);
                }).withMessageMatching(Const.LESS_THAN_3_ERROR_MSG);
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    String[] array = "2 + 3 *".split(" ");
                    validator.validateArray(array);
                }).withMessageMatching(Const.ODD_ERROR_MSG);
    }
}