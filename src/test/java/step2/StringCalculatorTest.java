package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    @DisplayName("add() 메소드는 쉼표 또는 콜론을 구분자를 기준으로 분리한 각 수자의 합을 반환한다.")
    public void split_and_add(){
        StringCalculator calculator = new StringCalculator();
        Integer sum =  calculator.splitAndAdd("1:2,3");
        Assertions.assertThat(sum).isEqualTo(6);
    }
}
