package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    void setCars() {
        cars = new Cars(Arrays.asList(
                new Car("CarA", 3),
                new Car("CarB", 5),
                new Car("CarC", 5)));
    }

    @Test
    void 차이름_중복시_예외발생() {
        assertThatThrownBy(() -> new Cars(Arrays.asList(new Car("CarA"), new Car("CarA"))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 우승차_조회() {
        Cars winnerCars = cars.getWinnerCars();
        assertThat(winnerCars).isEqualTo(new Cars(Arrays.asList(new Car("CarB", 5), new Car("CarC", 5))));
    }

    @Test
    void 차이름_String_List_반환() {
        assertThat(cars.getCarNames()).contains("CarA", "CarB", "CarC");
    }

}
