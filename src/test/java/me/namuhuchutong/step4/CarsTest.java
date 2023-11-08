package me.namuhuchutong.step4;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import me.namuhuchutong.step4.domain.Car;
import me.namuhuchutong.step4.domain.CarNames;
import me.namuhuchutong.step4.domain.Cars;
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

    @DisplayName("position 값이 가장 큰 자동차가 우승자이고, position 값이 같다면 우승자도 1명 이상이다.")
    @Test
    void winner_should_be_several_people() {
        //given
        Car tester1 = new Car(1, "Tester1");
        Car tester2 = new Car(3, "Tester2");
        Car tester3 = new Car(3, "Tester3");
        int expected = 2;
        Cars cars = new Cars(List.of(tester1, tester2, tester3));

        //when
        List<String> winners = cars.getWinners();

        //then
        assertThat(winners).hasSize(expected);
    }
}
