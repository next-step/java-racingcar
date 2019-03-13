package racingcar;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class RacingGameTest {

    @Test
    public void test_play() {
        // Given
        final List<String> carNames = Arrays.asList("pobi", "crong", "honux");
        RacingGame racingGame1 = new RacingGame(carNames);

        // When
        List<RacingCar> racingCars1 = racingGame1.play();
        List<RacingCar> racingCars2 = racingGame1.play();

        // Then
        assertThat(racingCars1).isEqualTo(racingCars2);
    }

    @Test
    public void test_determineWinners() {
        // TODO..
    }
}