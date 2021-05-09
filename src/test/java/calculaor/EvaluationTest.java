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
    void ConvertToNumberTest(String stringInput, int intInput) {
        // given
        Evaluation evaluation = new Evaluation();

        // when
        int actual = evaluation.convertToNumber(stringInput);

        // then
        assertThat(actual).isEqualTo(intInput);
    }

    // 사칙연산 부호 평가하기 테스트
    @ParameterizedTest
    @CsvSource(value = {"+,6","-,2","*,8","/,2"})
    void operatorEvaluationTest(String operatorValue, int expected) {
        // given
        Evaluation evaluation = new Evaluation();

        // when
        int actual = evaluation.operatorEvaluation(num1,operatorValue,num2);

        // then
        assertThat(actual).isEqualTo(expected);
    }
    
    // 사칙연산 부호 예외처리 테스트
    @ParameterizedTest
    @CsvSource(value = {"&","%","@"})
    void operatorExceptionTest(String exceptionValue) {
        // given
        Evaluation evaluation = new Evaluation();

        //then
        assertThatIllegalArgumentException().isThrownBy(()
                -> evaluation.operatorException(num1, exceptionValue, num2));
    }
}
