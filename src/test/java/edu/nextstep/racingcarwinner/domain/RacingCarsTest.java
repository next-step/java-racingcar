package edu.nextstep.racingcarwinner.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @Test
    void makeRacingCars() {
        // given
        String inputString = "hwan,hyun,kook";
        String[] inputStringArr = inputString.split(",");
        List<Car> carList = RacingCars.makeCarList(inputStringArr);

        // when
        RacingCars racingCars = RacingCars.makeRacingCars(carList);

        // then
        assertThat(racingCars.getCarList()).contains(new Car("hwan"),
                new Car("hyun"),
                new Car("kook"));
    }

    @Test
    void move() {
        // given
        List<Car> carList = RacingCars.makeCarList(new String[]{"hwan", "hyun", "kook"});
        RacingCars racingCars = RacingCars.makeRacingCars(carList);
        // when
        racingCars.move(() -> true);
        // then
        assertThat(racingCars.getCarList()).contains(new Car("hwan",1),
                new Car("hyun",1),
                new Car("kook",1));
    }

    @Test
    void getWinner() {
        // given
        RacingCars racingCars = RacingCars.makeRacingCars(Arrays.asList(new Car("hwan", 3),
                new Car("hyun", 2),
                new Car("kook", 3)));

        // when
        List<Car> winners = racingCars.getWinner();

        // then
        assertThat(winners).contains(new Car("hwan",3),
                new Car("kook",3));
    }
}