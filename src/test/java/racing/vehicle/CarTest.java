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
                Arguments.arguments(new RandomEngine(deterministicHighRandom), "--"),
                Arguments.arguments(new RandomEngine(deterministicLowRandom), "-")
        );
    }

    @Test
    public void initialPosition() {
        Car randomCar = new Car(new RandomEngine());
        assertThat(randomCar.convertPositionToDisplay()).isEqualTo("-");
    }

    @ParameterizedTest
    @MethodSource("deterministicRandomEngine")
    public void convertPositionToDisplay(RandomEngine randomEngine, String result) {
        Car randomCar = new Car(randomEngine);
        randomCar.move();
        assertThat(randomCar.convertPositionToDisplay()).isEqualTo(result);
    }
}
