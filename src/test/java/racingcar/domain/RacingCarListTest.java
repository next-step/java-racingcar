package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarListTest {

    @Test
    public void findMaxPosition() {
        Car car1 = new Car("bus", 5);
        Car car2 = new Car("car", 4);

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        RacingCarList racingCarList = new RacingCarList(carList);
        assertThat(racingCarList.findMaxPosition()).isEqualTo(5);
    }

    @Test
    public void findWinners() {
        Car car1 = new Car("bus",3);
        Car car2 = new Car("car",4);

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        RacingCarList racingCarList = new RacingCarList(carList);
        List<CarDTO> winners = racingCarList.findWinners();

        assertThat(winners.size()).isEqualTo(1);

        for (CarDTO dto : winners) {
            assertThat(dto.getName()).isEqualTo("car");
        }

    }

}