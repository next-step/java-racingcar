package javaracingcarwinner.controller;


import javaracingcarwinner.entity.RacingCar;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaRacingCarWinner {
    @Test
    void split_리스트_사이즈_검증(){
        JavaRacingCar javaRacingCar = new JavaRacingCar("pobi,crong,honux");
        List<RacingCar> cars = javaRacingCar.cars();
        assertThat(cars).hasSize(3);
    }
}
