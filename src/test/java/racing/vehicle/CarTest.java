package racing.vehicle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.testutil.DeterministicHighRandom;
import racing.testutil.DeterministicLowRandom;

import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    static Stream<Arguments> deterministicRandomEngine() {
        Random deterministicHighRandom = new DeterministicHighRandom();
        Random deterministicLowRandom = new DeterministicLowRandom();

        return Stream.of(
                Arguments.arguments(new RandomEngine(deterministicHighRandom), 2),
                Arguments.arguments(new RandomEngine(deterministicLowRandom), 1)
        );
    }

    @ParameterizedTest(name = "RandomEngine test {0} {1}")
    @MethodSource("deterministicRandomEngine")
    public void move(RandomEngine randomEngine, int result) {
        Car randomCar = new Car(new CarName("car"), randomEngine);
        randomCar.move();
        assertThat(randomCar.getCurrentPosition()).isEqualTo(result);
    }

    @Test
    public void initialPosition() {
        Car randomCar = new Car(new CarName("car"), new RandomEngine());
        assertThat(randomCar.getCurrentPosition()).isEqualTo(1);
    }
}
