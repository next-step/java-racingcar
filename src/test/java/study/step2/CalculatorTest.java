package study.step2;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import stringcalculator.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    private static double calculate(String operator, double operand1, double operand2){
        return Calculator.calculate(operator, operand1, operand2);
    }


    @BeforeEach
    void Calculator(){

    }

    @DisplayName("덧셈기능 테스트")
    @Test
    void add(){
        //String result = calculator.trimInputExpression("2 + 3");

    }

    @DisplayName("덧셈기능 테스트")
    @Test
    void calculateTest(){

        String input = "2 + 3 + 5";
        String[] split = input.split(" ");

        //  홀짝으로 분리. 그다음 calculate mapping은 어떻게 진행해야할까요?
        IntStream.range(0, split.length).filter(i -> i % 2 == 0).forEach(i -> System.out.println(split[i]));
        IntStream myIntStream = IntStream.range(0, split.length).filter(i -> i % 2 == 0);

        //List<Integer> intList = myIntStream.mapToObj(i->i).collect(Collectors.toList());


        IntStream.range(0, split.length).filter(i -> i % 2 != 0).forEach(i -> System.out.println(split[i]));
    }


    @DisplayName("뺄셈기능 테스트")
    @Test
    void sub(){
//        double result = calculator.trimInputExpression("5 - 4");
//        assertThat(result).isEqualTo(1.0);
    }

    @DisplayName("뺄셈기능 테스트")
    @Test
    void mutiple(){
//        double result = calculator.trimInputExpression("3 * 4");
//        assertThat(result).isEqualTo(12.0);
    }

    @DisplayName("나눗셈 기능 테스트")
    @Test
    void divide(){
//        double result = calculator.trimInputExpression("4 / 2");
//        assertThat(result).isEqualTo(20.0);
    }

    @DisplayName("입력값 null or 공백 테스트")
    @Test
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void IsEmptyOrNullString(String input){
        assertTrue(Strings.isNullOrEmpty(input));
    }

    @DisplayName("적절한 연산자가 들어왔는지 테스트")
    @Test
    void isNotOperator(){
        assertThatThrownBy(() -> calculator.isNotValidOperator("2 # 4"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("잘못된 연산자 입력");

    }

    @DisplayName("사칙연산을 모두 포함하는 기능 구현")
    @Test
    void calculatorTest(){
//        double result = calculator.trimInputExpression("2 + 3 * 4");
//        assertThat(result).isEqualTo(20.0);
    }




}
