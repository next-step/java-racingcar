package step3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 전진(int input) {
        RacingCar racingCar = new RacingCar();
        RandomBounded randomBounded = new RandomBounded(input);
        boolean goAhead = racingCar.goingAheadOrNot(randomBounded);
        assertThat(goAhead).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 멈춤(int input) {
        RacingCar racingCar = new RacingCar();
        RandomBounded randomBounded = new RandomBounded(input);
        boolean goAhead = racingCar.goingAheadOrNot(randomBounded);
        assertThat(goAhead).isFalse();
    }

}
