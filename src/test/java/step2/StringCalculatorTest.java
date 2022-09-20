package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    @DisplayName("add() 메소드는 쉼표 또는 콜론을 구분자를 기준으로 분리한 각 수자의 합을 반환한다.")
    void split_and_add(){
        StringCalculator calculator = new StringCalculator();
        Integer sum =  calculator.splitAndSum("1:2,3");
        assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 지정해서 문자열을 자른 후 더할 수 있다")
    void split_and_add_by_custom_delimiter(){
        StringCalculator calculator = new StringCalculator();
        Integer sum = calculator.splitAndSum("//;\n1;2;3;");
        assertThat(sum).isEqualTo(6);
    }
}
