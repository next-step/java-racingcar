package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    void create() {
        String[] carNames = {"carA", "carB", "carC", "carD", "carE"};
        assertThat(new Cars(carNames).move(() -> true)).hasSize(5);
    }

    @Test
    void findMaxPositionCars() {
        Cars cars = new Cars(List.of(
                new Car(5, "carA"),
                new Car(5, "carB"),
                new Car(4, "carC"),
                new Car(3, "carD")));
        assertThat(cars.findMaxPositionCars().stream().map(Car::getName).toArray())
                .containsExactly(new Name("carA"), new Name("carB"));
    }

}
