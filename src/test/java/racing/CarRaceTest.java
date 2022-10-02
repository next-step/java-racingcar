package racing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRaceTest {
    @Test
    void test_race_with_empty_cars() {
        assertThatThrownBy(() -> {
            CarRace carRace = new CarRace(List.of());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "test_race_when_stop {0}")
    @ValueSource(ints = {0, 1, 2, 3})
    void test_race_when_stop(int randomNumber) {
        Car car = new Car();
        CarRace carRace = new CarRace(List.of(car), getStaticRandomGenerator(randomNumber));
        carRace.race();
        assertThat(car.getMoves()).isEqualTo(0);
    }

    @ParameterizedTest(name = "test_race_when_move {0}")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void test_race_when_move(int randomNumber) {
        Car car = new Car();
        CarRace carRace = new CarRace(List.of(car), getStaticRandomGenerator(randomNumber));
        carRace.race();
        assertThat(car.getMoves()).isEqualTo(1);
    }

    @Test
    void test_race_with_multiple_cars() {
        List<Car> cars = List.of(new Car(), new Car());
        CarRace carRace = new CarRace(cars, getStaticRandomGenerator(4));
        carRace.race();
        for (Car car : cars) {
            assertThat(car.getMoves()).isEqualTo(1);
        }
    }

    private Random getStaticRandomGenerator(int number) {
        return new Random() {
            @Override
            public int nextInt(int bound) {
                return number;
            }
        };
    }
}
