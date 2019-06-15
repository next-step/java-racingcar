
import com.google.common.base.Strings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculator {

    // 각 연산의 결과값을 저장하는 변수
    public static int addResult, subtractResult, multiplyResult, divideResult;

    /*
    add() 함수 기능 및 단위 테스트 구현
    */
    @ParameterizedTest
    @ValueSource(strings = {"1+2","2+3","0+6"})
    void add(String input){
        int plusIndex = input.indexOf("+");
        int num1 = Character.getNumericValue(input.charAt(plusIndex-1));
        int num2 = Character.getNumericValue(input.charAt(plusIndex+1));
        addResult = num1 +num2;
        assertThat(addResult).isEqualTo(6);

    }

    /*
    Subtract() 함수 기능 및 단위 테스트 구현
    */
    @ParameterizedTest
    @ValueSource(strings = {"2-1","5-2","6-4"})
    void Subtract(String input){
        int plusIndex = input.indexOf("-");
        int num1 = Character.getNumericValue(input.charAt(plusIndex-1));
        int num2 = Character.getNumericValue(input.charAt(plusIndex+1));
        subtractResult = num1 -num2;
        assertThat(subtractResult).isEqualTo(3);

    }

    /*
    Multiply() 함수 기능 및 단위 테스트 구현
    */
    @ParameterizedTest
    @ValueSource(strings = {"2*8","5*2","6*4"})
    void Multiply(String input){
        int plusIndex = input.indexOf("*");
        int num1 = Character.getNumericValue(input.charAt(plusIndex-1));
        int num2 = Character.getNumericValue(input.charAt(plusIndex+1));
        multiplyResult = num1 * num2;
        assertThat(multiplyResult).isEqualTo(10);

    }

    /*
    Divide() 함수 기능 및 단위 테스트 구현
    */
    @ParameterizedTest
    @ValueSource(strings = {"8/2","6/3","5/5"})
    void Divide(String input){
        int plusIndex = input.indexOf("/");
        int num1 = Character.getNumericValue(input.charAt(plusIndex-1));
        int num2 = Character.getNumericValue(input.charAt(plusIndex+1));
        divideResult = num1 / num2;
        assertThat(divideResult).isEqualTo(4);

    }


}
