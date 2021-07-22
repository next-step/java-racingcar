package study;

import Calculator.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class stringCalTest {
    Plus plus;
    Subtract substract;
    Multiply multiply;
    Division division;
    StringCalculationExecutor stringCalculationExecutor;


    @BeforeEach
    void setUp(){
        plus = new Plus();
        substract = new Subtract();
        multiply = new Multiply();
        division = new Division();
        stringCalculationExecutor = new StringCalculationExecutor();
    }

    @Test
    @DisplayName("빈 칸의 따라 문자나눈후 잘나뉘어져있는지 요소 찾기.")
    void emptySplit(){
        String [] numberAndOperator = "2 + 3 * 4 / 2".split(" ");
        assertThat(numberAndOperator).contains("2");
        assertThat(numberAndOperator).contains("+");
        assertThat(numberAndOperator).contains("3");

    }

    @Test
    @DisplayName("더하기 테스트")
    void plusTest(){
        assertThat(plus.resultCalculator(1,2)).isEqualTo(3);
    }
    @Test
    @DisplayName("마이너스 테스트")
    void subTest(){
        assertThat(substract.resultCalculator(3,2)).isEqualTo(1);
    }

    @Test
    @DisplayName("곱하기 테스트")
    void mulTest(){
        assertThat(multiply.resultCalculator(1,2)).isEqualTo(2);
    }

    @Test
    @DisplayName("나누기 테스트")
    void divTest(){
        assertThat(division.resultCalculator(10,5)).isEqualTo(2);
    }

    @Test
    @DisplayName("계산기 메인 더하기  테스트")
    void plusMainTest(){
       // assertThat(stringCalculationExecutor.result("+",1,2)).isEqualTo(3);
    }

    @Test
    @DisplayName("문자열 반복문 계산")
    void repeatStringCal(){
        String [] numberAndOperator = "2 + 3 * 4 / 2".split(" ");
        int result =0;
        for(int i=0 ; i<=numberAndOperator.length/2+2; i+=2){
            if(result == 0){
               // result = stringCalculationExecutor.result(numberAndOperator[i+1] , Integer.parseInt(numberAndOperator[i]), Integer.parseInt(numberAndOperator[i+2]));
            }else{
               // result = stringCalculationExecutor.result(numberAndOperator[i+1] ,result, Integer.parseInt(numberAndOperator[i+2]));
            }
        }
        assertThat(result).isEqualTo(10);
    }

}
