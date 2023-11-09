package me.namuhuchutong.racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import me.namuhuchutong.racingcar.domain.Car;
import me.namuhuchutong.racingcar.domain.Cars;
import me.namuhuchutong.racingcar.domain.Winners;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnersTest {

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
        List<String> winners = Winners.from(cars).getNames();

        //then
        assertThat(winners).hasSize(expected);
    }

    @DisplayName("가장 큰 position 값을 가진 자동차가 우승자이다.")
    @Test
    void winner_has_the_biggest_position() {
        //given
        Car tester1 = new Car(1, "Tester1");
        Car tester2 = new Car(3, "Tester2");
        Car tester3 = new Car(4, "Tester3");
        Cars cars = new Cars(List.of(tester1, tester2, tester3));

        //when
        List<String> names = Winners.from(cars)
                                    .getNames();

        //then
        assertThat(names).contains("Tester3");
    }

}
