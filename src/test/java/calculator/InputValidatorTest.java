package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputValidatorTest {

    @ParameterizedTest
    @DisplayName("알맞는 위치에 숫자인지 확인")
    @CsvSource(value = {"2,true", "+,false"})
    void isNumberFormat(String value, boolean flag) {
        Pattern numeric = Pattern.compile("^[0-9]+$");

        assertThat(numeric.matcher(value).find()).isEqualTo(flag);
    }

    @Test
    @DisplayName("홀수길이만큼 입력했는지 확인")
    void isEvenLengthInput() {
        String input = "2 * 3 / 5";
        assertThat(input.length()%2 == 1 && input.length() > 2).isTrue();
    }

    @ParameterizedTest
    @DisplayName("입력값이 공백인지 확인")
    @ValueSource(strings = {""})
    void isEmpty(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            if(input.isEmpty())
                throw new IllegalArgumentException("값을 입력하세요");
        }).withMessage("값을 입력하세요");
    }
}
