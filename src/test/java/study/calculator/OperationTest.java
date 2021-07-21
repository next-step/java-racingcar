package study.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperationTest {
    
    @DisplayName("값 두개를 enum 클래스에 넘기면 해당 enum 값별로 연산이 되는지 테스트.")
    @Test
    void calculateNumbersTest() {

        System.out.println("value = " + Operation.PLUS.calculateNumbers(1, 2));
        System.out.println("value = " + Operation.MINUS.calculateNumbers(1, 2));
        System.out.println("value = " + Operation.MULTIPLY.calculateNumbers(1, 3));
        System.out.println("value = " + Operation.DIVISION.calculateNumbers(2, 2));
    }

    @DisplayName("enum 클래스에서 해당하는 연산자를 찾아 연산 결과를 출력하는 테스트.")
    @ParameterizedTest
    @CsvSource(value = {
            "1| +| 2| 3",
            "1| -| 2| -1",
            "1| *| 2| 2",
            "2| /| 2| 1"
    },delimiter = '|')
    void chooseOperationTest(String inputNum1,String mark, String inputNum2, String expected) {

        int num1 = Integer.parseInt(inputNum1);
        int num2 = Integer.parseInt(inputNum2);
        int result = Integer.parseInt(expected);

        Operation operation = Operation.chooseOperation(mark);
        assertThat(operation.calculateNumbers(num1, num2)).isEqualTo(result);
    }
}