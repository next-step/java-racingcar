package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class StringCalculatorTest {

    //각각의 단위테스트로 만들어서 pass 하게 만든다
    //그 다음에 다 합치는 방식으로 진행

    @Test
    public void 덧셈() {
        //작은 단위의 테스트 부터 진행
        int result = StringCalculator.calculate("1 + 2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void 곱셈() {
        //작은 단위의 테스트 부터 진행
        int result = StringCalculator.calculate("1 * 2");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 뺄셈() {
        //작은 단위의 테스트 부터 진행
        int result = StringCalculator.calculate("1 - 2");
        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void 나눗셈() {
        //작은 단위의 테스트 부터 진행
        int result = StringCalculator.calculate("1 / 2");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void 계산기() {
        //작은 단위의 테스트 부터 진행
        int result = StringCalculator.calculate("1 / 2 + 3 - 2");
        assertThat(result).isEqualTo(1);
    }
}