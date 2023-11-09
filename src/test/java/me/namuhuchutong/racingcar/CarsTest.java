package me.namuhuchutong.racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import me.namuhuchutong.racingcar.domain.CarNames;
import me.namuhuchutong.racingcar.domain.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("자동차 수는 0일 수 없다.")
    @Test
    void number_of_cars_should_not_be_negative() {
        //given
        CarNames from = CarNames.from(Collections.emptyList());

        //when, then
        assertThatThrownBy(() -> Cars.createCars(from))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
