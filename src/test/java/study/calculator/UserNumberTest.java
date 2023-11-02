package study.calculator;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class UserNumberTest {

    @DisplayName("empty, null은 0")
    @NullAndEmptySource
    @ParameterizedTest (name = " \"{0}\" is return zero")
    void emptyAndNullMustReturnZero(String target){
        UserNumber userNumber = UserNumber.from(target);
        int number = userNumber.number();
        assertThat(number).isZero();
    }

    @DisplayName("한자리면 해당 숫자를 반환")
    @CsvSource(value = {"1,1", "10,10"})
    @ParameterizedTest
    void singleStringMustReturnSingleDigit(String target, String expected){
        UserNumber userNumber = UserNumber.from(target);
        int number = userNumber.number();
        assertThat(number).isEqualTo(Integer.parseInt(expected));
    }


}
