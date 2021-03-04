package calculator.utils;

import calculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    @DisplayName("입력 값 Null일 경우 에러")
    public void validateNull() throws Exception {
        //given
        String[] splitExpression = null;

        //when
        StringCalculator stringCalculator = new StringCalculator();

        //then
        assertThatNullPointerException().isThrownBy(() -> stringCalculator.calculate(splitExpression));
    }
}