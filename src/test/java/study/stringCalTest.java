package study;

import Calculater.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

public class stringCalTest {
    Sum sum;
    Sub sub;
    Mul mul;
    Div div;
    CalculaterMain calMain;

    @BeforeEach
    void setUp(){
        sum = new Sum();
        sub = new Sub();
        mul = new Mul();
        div = new Div();
        calMain = new CalculaterMain();
    }

    @Test
    @DisplayName("빈 칸의 따라 문자나누기")
    void emptySplit(){
        String [] numberAndBuho = "2 + 3 * 4 / 2".split(" ");
        assertThat(numberAndBuho).contains("2");
        assertThat(numberAndBuho).contains("+");
        assertThat(numberAndBuho).contains("3");

    }

    @Test
    @DisplayName("빼기 테스트")
    void Sum(){
        assertThat(sum.cal(1,2)).isEqualTo(3);
    }
    @Test
    @DisplayName("마이너스 테스트")
    void Sub(){
        assertThat(sub.cal(3,2)).isEqualTo(1);
    }

    @Test
    @DisplayName("곱하기 테스트")
    void Mul(){
        assertThat(mul.cal(1,2)).isEqualTo(2);
    }

    @Test
    @DisplayName("나누기 테스트")
    void Div(){
        assertThat(div.cal(4,2)).isEqualTo(2);
    }

    @Test
    @DisplayName("계산기 메인 더하기  테스트")
    void sumFucTest(){
        assertThat(calMain.result("+",1,2)).isEqualTo(3);
    }

    @Test
    @DisplayName("문자열 반복문 계산")
    void repeatStringCal(){
        String [] numberAndBuho = "2 + 3 * 4 / 2".split(" ");
        int result =0;
        for(int i=0 ; i<=numberAndBuho.length/2+2; i+=2){
            if(result == 0){
                result = calMain.result(numberAndBuho[i+1] ,Integer.parseInt(numberAndBuho[i]),Integer.parseInt(numberAndBuho[i+2]));
            }else{
                result = calMain.result(numberAndBuho[i+1] ,result,Integer.parseInt(numberAndBuho[i+2]));
            }
        }
        assertThat(result).isEqualTo(10);
    }

}
