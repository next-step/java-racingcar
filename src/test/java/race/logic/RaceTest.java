package race.logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @DisplayName("test for cars' initial position")
    @ValueSource(ints = {1, 3, 5, 7, 9})
    @ParameterizedTest
    void initialPosition(int numberCars) {
        List<Car> cars = new Race(EngineFactory.BROKEN_ENGINE_FACTORY, numberCars).getCars();
        cars.forEach(car -> assertThat(car.getCurrentPosition()).isEqualTo(0));
    }

    @DisplayName("test for each lap's position with perfect engine")
    @RepeatedTest(10)
    void lapWithPerfectEngine() {
        final int iterations = 20;
        Race race = new Race(EngineFactory.PERFECT_ENGINE_FACTORY, 5);
        IntStream.range(1, iterations).forEach(i -> {
            race.lap();
            race.getCars().forEach(car -> assertThat(car.getCurrentPosition()).isEqualTo(i));
        });
    }

    @DisplayName("test for each lap's position with random engine")
    @RepeatedTest(10)
    void lapWithRandomEngine() {
        final int iterations = 20;
        Race race = new Race(RandomEngine::new, 5);
        IntStream.range(1, iterations).forEach(i -> {
            race.lap();
            race.getCars().forEach(car -> assertThat(car.getCurrentPosition()).isBetween(0, i));
        });
    }

}
