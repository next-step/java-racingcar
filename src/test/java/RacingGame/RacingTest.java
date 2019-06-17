package RacingGame;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingTest {

    Racing racing;

    @BeforeEach
    void setUp() {
        racing = new Racing();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void setTime(int time) {
        racing.setTime(time);
        assertThat(racing.getTime()).isEqualTo(time);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void setCars(int carCount) {
        List<Car> cars = racing.arrayWithCar(carCount);
        assertThat(cars.size()).isEqualTo(carCount);
        assertThat(cars.get(0).getPosition()).isEqualTo(0);
    }
}