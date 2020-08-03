package com.hskim.nextstep.step02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

/*
    com.hskim.nextstep.step02 - ArithmeticOperator enum class 테스트
 */
public class ArithmeticOperatorTest {

    @BeforeEach
    void setUp() {

    }

    @DisplayName("ADDITION 연산자 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3,5:8", "4,-2:2", "8,-8:0", "12345,54321:66666"}, delimiter = ':')
    void additionTest(String args, int result) {

        String[] argArr = args.split(",");
        assertThat(ArithmeticOperator.ADDITION.calculate(argArr[0], argArr[1])).isEqualTo(result);
    }

    @DisplayName("SUBTRACT 연산자 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3,5:-2", "4,-2:6", "8,-8:16", "12345,54321:-41976"}, delimiter = ':')
    void subtractTest(String args, int result) {

        String[] argArr = args.split(",");
        assertThat(ArithmeticOperator.SUBTRACT.calculate(argArr[0], argArr[1])).isEqualTo(result);
    }

    @DisplayName("MULTIPLICATION 연산자 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3,5:15", "4,-2:-8", "8,-8:-64", "12,12:144"}, delimiter = ':')
    void multiplicationTest(String args, int result) {

        String[] argArr = args.split(",");
        assertThat(ArithmeticOperator.MULTIPLICATION.calculate(argArr[0], argArr[1])).isEqualTo(result);
    }

    @DisplayName("DIVISION 연산자 테스트")
    @ParameterizedTest
    @CsvSource(value = {"8,2:4", "256,16:16", "4096,128:32", "729,243:3"}, delimiter = ':')
    void divisionTest(String args, int result) {

        String[] argArr = args.split(",");
        assertThat(ArithmeticOperator.DIVISION.calculate(argArr[0], argArr[1])).isEqualTo(result);
    }

    @DisplayName("contains() 메소드 검증")
    @ParameterizedTest
    @CsvSource(value = {"+:true", "-:true", "*:true", "/:true", "&:false", "%:false", "):false"}, delimiter = ':')
    void containsTest(String sign, boolean expected) {

        assertThat(ArithmeticOperator.contains(sign)).isEqualTo(expected);
    }

    @DisplayName("getArithmeticOperatorBySign() 메소드 성공 검증")
    @ParameterizedTest
    @CsvSource(value = {"+:ADDITION", "-:SUBTRACT", "*:MULTIPLICATION", "/:DIVISION"}, delimiter = ':')
    void getArithmeticOperatorSuccessTest(String sign, String operatorName) {

        assertThat(ArithmeticOperator.getArithmeticOperatorBySign(sign).name()).isEqualTo(operatorName);
    }

    @DisplayName("getArithmeticOperatorBySign() 메소드 실패 검증")
    @ParameterizedTest
    @ValueSource(strings = {"^", "&", "(", ")", "@", "!"})
    void getArithmeticOperatorFailTest(String sign) {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            ArithmeticOperator.getArithmeticOperatorBySign(sign);
        });
    }
}
