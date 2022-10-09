import domain.racingcar.RacingCars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarsTest {
    private final String[] NAMES = {"test1", "test2", "test3"};
    private RacingCars racingCarsWithOneWinner;
    private RacingCars racingCarsWithTwoWinner;
    private RacingCars racingCarsWithZeroWinner;

    @BeforeEach
    public void init() {
        int[] distancesForOneWinner = {1, 2, 3};
        racingCarsWithOneWinner = new RacingCars(3, distancesForOneWinner, NAMES);

        int[] distancesForTwoWinners = {1, 2, 2};
        racingCarsWithTwoWinner = new RacingCars(3, distancesForTwoWinners, NAMES);

        int[] zeroDistances = {0, 0, 0};
        racingCarsWithZeroWinner = new RacingCars(3, zeroDistances, NAMES);
    }

    @Test
    public void 자동차_경주_우승자_1명_테스트() {
        List<String> expected = new ArrayList<>();
        expected.add("test3");

        assertThat(racingCarsWithOneWinner.findRaceWinners()).isEqualTo(expected);
    }

    @Test
    public void 자동차_경주_우승자_2명이상_테스트() {
        List<String> expected = new ArrayList<>();
        expected.add("test2");
        expected.add("test3");

        assertThat(racingCarsWithTwoWinner.findRaceWinners()).isEqualTo(expected);
    }

    @Test
    public void 자동차_경주_우승자_0명_테스트() {
        assertThatThrownBy(() -> racingCarsWithZeroWinner.findRaceWinners())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("우승자가 존재하지 않습니다.");
    }
}
