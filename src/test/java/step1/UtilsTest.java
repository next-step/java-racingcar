package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UtilsTest {

    static Stream <String> exceptionString() {
        return Stream.of(" ", "    ", null);
    }

    @ParameterizedTest
    @MethodSource("exceptionString")
    @DisplayName("입력 값이 null 이거나 빈 공백 문자 포함 경우 IllegalArgumentException")
    void stringEmptyValidationTest(final String inValiedString){
        assertThatThrownBy(() -> Utils.stringEmptyValidation(inValiedString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(chars = {'+','-','*','/'})
    @DisplayName("정상 사칙연산기호 확인")
    void valiedCalculationSymbolTest(char valiedChar){
        boolean isSymbol = Utils.isOperator(valiedChar);
        assertThat(isSymbol).isTrue();
        String[] tt = "  1".split(" ");
        System.out.println(tt);
    }

    @ParameterizedTest
    @ValueSource(chars = {'(','@','$','#'})
    @DisplayName("비정상 사칙연산기호 확인")
    void inValiedCalculationSymbolTest(char valiedChar){
        boolean isSymbol = Utils.isOperator(valiedChar);
        assertThat(isSymbol).isFalse();
    }

    @Test
    @DisplayName("char에 숫자가 있는지 확인")
    void isNumberTest(){
        boolean isNumber = Utils.isNumber('5');
        assertThat(isNumber).isTrue();
    }

    @Test
    @DisplayName("char를 string으로 변환")
    void charToStringConvertTest(){
        char inputChar = 'a';
        assertThat(Utils.charToStringConvert(inputChar)).isInstanceOf(String.class);
        assertThat(Utils.charToStringConvert(inputChar)).isEqualTo("a");
    }
}
