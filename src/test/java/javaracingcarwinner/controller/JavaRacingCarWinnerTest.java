package javaracingcarwinner.controller;


import javaracingcarwinner.dto.RacingInfoDto;
import javaracingcarwinner.entity.RacingCar;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JavaRacingCarWinnerTest {
    @Test
    void split_리스트_사이즈_검증() {
        JavaRacingCar javaRacingCar = new JavaRacingCar(new RacingInfoDto("pobi,crong,honux", 5));
        List<RacingCar> cars = javaRacingCar.cars();
        assertThat(cars).hasSize(3);
    }

    @Test
    void 이름_5자_넘을_시_예외() {
        assertThatThrownBy(() -> new JavaRacingCar(new RacingInfoDto("pobi,crong,honux,jeonghyeonkwon", 5))).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 입력된_시도_횟수_검증() {
        JavaRacingCar javaRacingCar = new JavaRacingCar(new RacingInfoDto("pobi,crong,honux", 5));

        assertThat(javaRacingCar.tryCount()).isEqualTo(5);
    }

    @Test
    void 입력된_시도_횟수_negative_value() {
        assertThatThrownBy(() -> new JavaRacingCar(new RacingInfoDto("pobi,crong,honux", -4))).isInstanceOf(RuntimeException.class);
    }

}
