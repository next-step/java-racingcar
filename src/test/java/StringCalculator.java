import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculator {

//    @ParameterizedTest
//    @ValueSource(strings = {"1+2"})
//    void add(){
//        System.out.println("add");
//        int plusIndex =input.indexOf("+");
//
//    }

    /*
    add() 함수 단위 테스트 구현
    해당 함수는 단순 더하기 기능만 구현해봤습니다.
    입력받은 값을 어떻게 함수에 전달해야할지 아직 감이 안와서 고민중입니다.
     */
    @Test
    void add(){
        String input ="1+2";
        int plusIndex = input.indexOf("+");
        int num1 = input.charAt(plusIndex-1);
        int num2 = input.charAt(plusIndex+1);
        assertThat(num1 + num2).toString().contains("3");

    }

}
