package step3.logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @DisplayName("test for cars' initial position")
    @ValueSource(ints = {1, 3, 5, 7, 9})
    @ParameterizedTest
    void initialPosition(int numberCars) {
        List<Car> cars = new Race(numberCars).getCars();
        testPositions(cars, 0);
    }

    @DisplayName("test for each lap's position range")
    @RepeatedTest(10)
    void lap() {
        final int iterations = 20;
        Race race = new Race(5);
        IntStream.range(1, iterations).forEach(i -> {
            race.lap();
            testPositions(race.getCars(), i);
        });
    }

    private void testPositions(Collection<Car> cars, int max) {
        cars.forEach(car -> assertThat(car.getCurrentPosition()).isBetween(0, max));
    }
}
