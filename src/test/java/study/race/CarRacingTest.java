package study.race;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.calculator.Calculator;

import static org.assertj.core.api.Assertions.*;

public class CarRacingTest {

    @Test
    @DisplayName("자동차 배열 생성 확인")
    void sizeTest(){
        assertThat(CarRacing.carArray(3).length).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 전진, 멈춤 구현")
    void moveTest(){
        assertThat(CarRacing.condition(3)).isEqualTo(0);
        assertThat(CarRacing.condition(4)).isEqualTo(1);
    }

    @Test
    @DisplayName("경주 구현")
    void racingCount(){
        assertThat(CarRacing.condition(3)).isEqualTo(0);
    }


}
