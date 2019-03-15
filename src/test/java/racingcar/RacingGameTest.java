package racingcar;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

import org.junit.Test;

public class RacingGameTest {

    @Test
    public void test_play() throws CloneNotSupportedException {
        // Given
        final List<RacingCar> racingCars = Arrays.asList(
                new RacingCar("pobi", 2),
                new RacingCar("honux", 1),
                new RacingCar("crong", 5));

        RacingGame racingGame = new RacingGame(racingCars);

        // When
        final List<RacingCar> racingCarsAfterPlay = racingGame.play();

        // Then
        for (int i = 0; i < racingCars.size(); i++) {
            assertThat(racingCars.get(i).compareTo(racingCarsAfterPlay.get(i))).isNotEqualTo(1);
        }
    }

    @Test
    public void test_determineWinners() {
        // Given
        final RacingCar expectedRacingCarWinner = new RacingCar("crong", 5);
        final List<RacingCar> racingCars = Arrays.asList(
                new RacingCar("pobi", 2),
                new RacingCar("honux", 1),
                expectedRacingCarWinner);

        RacingGame racingGame = new RacingGame(racingCars);

        // When
        List<RacingCar> racingCarWinners = racingGame.determineWinners();

        // Then
        RacingCar racingCarWinner = racingCarWinners.stream()
                .max(Comparator.naturalOrder())
                .get();

        assertThat(racingCarWinner).isEqualTo(expectedRacingCarWinner);

    }
}