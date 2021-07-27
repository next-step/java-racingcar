package racingCar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(new String[]{"pobi", "crong", "honux"}, 5);
        cars.play();
    }

    @DisplayName("우승자는 1명 이상")
    @Test
    void findMaxLocation() {
        assertThat(cars.findWinners().length()).isGreaterThan(0);
    }
}