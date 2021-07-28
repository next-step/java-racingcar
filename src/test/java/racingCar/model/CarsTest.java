package racingCar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(new String[]{"pobi", "crong", "honux"}, 5);
        List<Car> racingCars = cars.getCars();
        racingCars.get(2).move(6);
    }

    @Test
    void findWinner() {
        assertThat(cars.findWinners())
                .isEqualTo(Arrays.asList(cars.getCars().get(2)));
    }

}