package step2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    /**
     * 구현해야 할 단위 테스트
     * 1. 덧셈 ,뺄셈, 곱셈, 나눗셈
     * 2. 입력값이 null이거나 빈 문자일 경우
     * 3. 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
     * 4. 사칙 연산을 모두 포함하는 기능 구현
     */
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    // 사칙연산 테스트
    @ParameterizedTest
    @CsvSource({"1 + 2, 3", "2 + 5 + 7, 14", "1 * 5 - 2 + 6, 9", "1 + 2 * 10 - 5 / 5, 5"})
    @DisplayName("사칙연산 테스트")
    void plusTest(String input, int expectedValue) {

        //when
        int result = stringCalculator.calculateToStringInput(input);

        //then
        assertThat(result).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력값이 null이거나 빈 문자일 경우")
    void inputValitionTest (String input){

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    stringCalculator.calculateToStringInput(input);
                }).withMessageMatching("입력값이 없거나 공백입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 X 2 + 4 ! 5", "2 w 5"})
    @DisplayName("사칙연산이 아닐경우")
    void typeValidationTest (String input){
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    stringCalculator.calculateToStringInput(input);
                }).withMessageMatching("사칙연산이 아닙니다.");
    }

}
