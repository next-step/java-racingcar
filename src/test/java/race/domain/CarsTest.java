package race.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private List<String> carNames;

    @BeforeEach
    void setCarNames() {
        carNames = Arrays.asList("petty", "loopy", "crong", "poby", "harry");
    }

    @DisplayName("test for cars' initial position")
    @Test
    void initialPosition() {
        LapScores scores = new Cars(EngineFactory.BROKEN_ENGINE_FACTORY, carNames).lap();
        scores.forEach(score -> assertThat(score.getPosition()).isEqualTo(0));
    }

    @DisplayName("test for each lap's position with perfect engine")
    @RepeatedTest(10)
    void lapWithPerfectEngine() {
        final int iterations = 20;
        Cars cars = new Cars(EngineFactory.PERFECT_ENGINE_FACTORY, carNames);
        IntStream.range(1, iterations).forEach(i -> {
            cars.lap().forEach(score -> assertThat(score.getPosition()).isEqualTo(i));
        });
    }

    @DisplayName("test for each lap's position with random engine")
    @RepeatedTest(10)
    void lapWithRandomEngine() {
        final int iterations = 20;
        Cars cars = new Cars(RandomEngine::new, carNames);
        IntStream.range(1, iterations).forEach(i -> {
            cars.lap().forEach(score -> assertThat(score.getPosition()).isBetween(0, i));
        });
    }

    @DisplayName("test for perfect engine winner")
    @Test
    void frontLineWithPerfectEngine() {
        final int iterations = 10;
        Cars cars = new Cars(EngineFactory.PERFECT_ENGINE_FACTORY, carNames);
        IntStream.range(0, iterations)
                .mapToObj(i -> cars.lap())
                .forEach(score -> assertThat(score.getFrontLine()).isEqualTo(score));
    }

    @DisplayName("test for broken engine winner")
    @Test
    void frontLineWithBrokenEngine() {
        final int iterations = 10;
        Cars cars = new Cars(EngineFactory.BROKEN_ENGINE_FACTORY, carNames);
        IntStream.range(0, iterations)
                .mapToObj(i -> cars.lap())
                .forEach(score -> assertThat(score.getFrontLine()).isEqualTo(score));
    }
}
