package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.code.ErrorCodes;
import study.code.LiteralCodes;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    StringCalculator stringCalculator;

    @BeforeEach
    void setUp(){
        stringCalculator = new StringCalculator();
    }

    @Test
    void calculateTest() throws Exception {
        assertThat(stringCalculator.calculate("1 + 2 - 3")).isEqualTo(0);
    }

    @Test
    void calculateTest_ShouldReturnCustomizedException(){
        assertThatExceptionOfType(Exception.class).isThrownBy(() -> {
            stringCalculator.calculate("4 / 3 + 3");
        }).withMessage(ErrorCodes.E00);
    }

    @Test
    void calculateTest_WhenOperatorIsNullThenIllegalArgumentException(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            assertThat(stringCalculator.calculate("1  2 + 3"));
        });
    }

    @Test
    void calculateTest_WhenOperatorNotExistsThenIllegalArgumentException(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            assertThat(stringCalculator.calculate("1 ^ 2 + 3"));
        });
    }

    @Test
    void calculateTest_WhenOperatorIsBlankThenIllegalArgumentException(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            assertThat(stringCalculator.calculate("1  2 + 3"));
        });
    }
}
