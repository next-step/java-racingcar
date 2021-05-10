package calculaor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class EvaluationTest {
    private int num1;
    private int num2;

    @BeforeEach
    void SetUP() {
        num1 = 4;
        num2 = 2;
    }

    // 문자형을 숫자형으로 변환 테스트
    @ParameterizedTest
    @CsvSource(value = {"1,1","2,2","3,3"})
    void convertToNumberTest(String stringInput, int intInput) {
        // given
        Evaluation evaluation = new Evaluation();

        // when
        int actual = evaluation.convertToNumber(stringInput);

        // then
        assertThat(actual).isEqualTo(intInput);
    }

    // 사칙연산 부호 평가기능 테스트
    @Test
    void checkOperatorTest() {
        // given
        Evaluation evaluation = new Evaluation();

        // when
        int expected = 6;
        int actual = evaluation.checkOperator(num1,"+",num2);

        // then
        assertThat(actual).isEqualTo(expected);
    }


    // 정상 케이스: 사칙연산 부호 평가
    @ParameterizedTest
    @CsvSource(value = {"+,6","-,2","*,8","/,2"})
    void isOperatorTest(String operatorValue, int expected) {
        // given
        Evaluation evaluation = new Evaluation();

        // when
        int actual = evaluation.isOperator(num1,operatorValue,num2);

        // then
        assertThat(actual).isEqualTo(expected);
    }
    
    // 예외 케이스 : 사칙연산 부호 아닌 경우
    @ParameterizedTest
    @CsvSource(value = {"&","%","@"})
    void isOperatorExceptionTest(String exceptionValue) {
        // given
        Evaluation evaluation = new Evaluation();

        //then
        assertThatIllegalArgumentException().isThrownBy(()
                -> evaluation.isOperator(num1, exceptionValue, num2));
    }
}
