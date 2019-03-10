package calculator;

import calculator.type.CalculationOfEachType;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StringCalculatorTest {

    //각각의 단위테스트로 만들어서 pass 하게 만든다
    //그 다음에 다 합치는 방식으로 진행
    //TODO 입력값이 비정상적인 case 생각해보기 (요구사항 없음, 숫자만, 연산자-숫자 순서 오류 등)

    @Test
    public void 문자열입력_비정상_케이스_테스트() {
        boolean isOk = false;
        String text = "1 + 2 - 3 * 4 / 5";

        isOk = StringExpressionValidator.validateExpression(text);
        assertThat(isOk).isEqualTo(true);

        text = "1 + + 2 - 3 * 4 / 5";
        isOk = StringExpressionValidator.validateExpression(text);
        assertThat(isOk).isEqualTo(false);
    }

    @Test
    public void 두자리_이상_숫자_입력값_확인() {
        boolean isOk = false;
        String text = "10 + 2 - 3 * 4 / 5";

        isOk = StringExpressionValidator.validateExpression(text);
        assertThat(isOk).isEqualTo(true);

        text = "100 + 20 - 33 * 4 / 51";
        isOk = StringExpressionValidator.validateExpression(text);
        assertThat(isOk).isEqualTo(true);
    }

    @Test
    public void enum테스트() {
        CalculationOfEachType test = CalculationOfEachType.valueOf("ADD");
        System.out.println(test.getValue());
        System.out.println(test.calculrate(1, 2));
    }

    @Test
    public void 입력값이_null이거나_공백인경우() {
        int result = StringCalculator.calculate(null);
        assertThat(result).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    public void 덧셈() {
        int result = StringCalculator.calculate("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 곱셈() {
        int result = StringCalculator.calculate("1 * 2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 뺄셈() {
        int result = StringCalculator.calculate("1 - 2");
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void 나눗셈() {
        int result = StringCalculator.calculate("1 / 2");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 계산기() {
        int result = StringCalculator.calculate("1 / 2 + 3 - 2 * 100 - 1");
        assertThat(result).isEqualTo(99);
    }
}