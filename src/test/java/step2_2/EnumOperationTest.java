package step2_2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EnumOperationTest {

    @DisplayName("사칙연산 enum 테스트")
    @Test
    public void operationEnumTest(){
        assertThat(Operation.PLUS.getOperationName()).isEqualTo("더하기");
        assertThat(Operation.MINUS.getOperationName()).isEqualTo("빼기");
        assertThat(Operation.MULTI.getOperationName()).isEqualTo("곱하기");
        assertThat(Operation.DIV.getOperationName()).isEqualTo("나누기");
    }

    @DisplayName("연산 테스트")
    @Test
    public void calculateTest(){
        int valueOne = 3;
        int valueTwo= 5;

        int plusValue = Operation.PLUS.calculate(valueOne,valueTwo);
        assertThat(plusValue).isEqualTo(8);

        int minusValue = Operation.MINUS.calculate(valueOne,valueTwo);
        assertThat(minusValue).isEqualTo(-2);

        int multiValue = Operation.MULTI.calculate(valueOne,valueTwo);
        assertThat(multiValue).isEqualTo(15);

        int divValue = Operation.DIV.calculate(valueOne,valueTwo);
        assertThat(divValue).isEqualTo(0);
    }
}
