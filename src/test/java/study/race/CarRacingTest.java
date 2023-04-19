package study.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.calculator.Calculator;

import static org.assertj.core.api.Assertions.*;

public class CarRacingTest {

    @Test
    @DisplayName("자동차 배열 생성 확인")
    void setSize(){
        assertThat(CarRacing.carArray(3).size()).isEqualTo(3);
    }

}
