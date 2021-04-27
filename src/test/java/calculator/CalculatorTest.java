package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Set<String> numbers ;
    private static String[] array = {"+","-","*","/"};
    @Test
    @BeforeEach
    void test(){
        Calculator cal = new Calculator();
        String sentence = "2 + 3 * 4 / 2";
        final String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if(!isStringDouble(arr[i].toString())) {
               array
            }
        }
        String actualValue = test("+",1,2);

        System.out.println(actualValue);
    }

    private boolean isStringDouble(String toString) {
        try {
            Double.parseDouble(toString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }
    @DisplayName("사칙연산의 종류를 파악하는 함수")
    @ParameterizedTest
    String test(String input,int a, int b) {
        numbers = new HashSet<>();
        numbers.add(input);
        boolean actualValue = numbers.contains(input);
        org.assertj.core.api.Assertions.assertThatCode(() -> {
            assertEquals(false,actualValue);
        });

        if(actualValue) {
            int result = b;
            return String.valueOf(result);
        }
        return "F";

    }



}
