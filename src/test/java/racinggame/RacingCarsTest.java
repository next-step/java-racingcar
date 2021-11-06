package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {
    private RacingCars racingCars;

    @BeforeEach
    void setUp() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());
        racingCars = new RacingCars(cars);
    }

    @DisplayName("경주용자동차 전진후 View 반환")
    @Test
    void advanceStatus() {
        racingCars.advance();
        racingCars.advance();
        racingCars.advance();
        assertThat(racingCars.advanceStatus()).isInstanceOf(ResultView.class);
    }
}