



package calculator;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


public class CalculateTest {


    Calculator calculator = new Calculator();


    @Test
    @DisplayName("연산자에 따라 계산하기")
    void switchOperationTest(){
        int result = calculator.switchOperation("+", 2,3);
        assertThat(result).isEqualTo(5);


        result = calculator.switchOperation("-", 5,3);
        assertThat(result).isEqualTo(2);


        result = calculator.switchOperation("*", 2,3);
        assertThat(result).isEqualTo(6);


        result = calculator.switchOperation("/", 6,3);
        assertThat(result).isEqualTo(2);
    }


    @Test
    @DisplayName("input값을 String 배열로 변환  하기")
    void convertStringToArrayTest(){
        String[] result = calculator.convertStringToArray("2 + 3");
        assertThat(result).isEqualTo(new String[]{"2","+","3"});

        assertThatThrownBy(()->{calculator.convertStringToArray("");})
                .isInstanceOf(IllegalArgumentException.class)
                .isNotInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("계산하기")
    void caculateTest(){
        int result = calculator.calculate("2 + 10");
        assertThat(result).isEqualTo(12);

        result = calculator.calculate("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);

        assertThatThrownBy(()->{calculator.calculate("2 & 10");})
                .isInstanceOf(IllegalArgumentException.class)
                .isNotInstanceOf(NullPointerException.class);

    }

    @ParameterizedTest
    @DisplayName("나눗셈의 결과값이 정수일 때 테스트하기")
    @CsvSource({"4,2,2", "6,3,2"})
    void divisionResultIsIntegerTest(int num1, int num2, int excpected){
        assertThat(calculator.division(num1, num2)).isEqualTo(excpected);
    }

    @Test
    @DisplayName("나눗셈의 결과값이 정수가 아닐 때 테스트하기")
    void divisionResultIsNotIntegerTest(){
        assertThatThrownBy(()->{calculator.division(5,4);})
            .isInstanceOf(IllegalArgumentException.class);
    }
}
