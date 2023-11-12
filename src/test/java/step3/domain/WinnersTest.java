package step3.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @Test
    void getWinnerTest() {
        RacingCar one = new RacingCar("one", 1);
        RacingCar two = new RacingCar("two", 2);
        RacingCar three = new RacingCar("three", 3);
        RacingCar[] racingCars = new RacingCar[]{one, two, three};

        List<RacingCar> winners = Winners.getWinners(racingCars);
        assertThat(winners.contains(one)).isFalse();
        assertThat(winners.contains(two)).isFalse();
        assertThat(winners.contains(three)).isTrue();

    }

    @Test
    void getWinnersTest_공동우승() {
        RacingCar one = new RacingCar("one", 3);
        RacingCar two = new RacingCar("two", 3);
        RacingCar three = new RacingCar("three", 1);
        RacingCar[] racingCars = new RacingCar[]{one, two, three};

        List<RacingCar> winners = Winners.getWinners(racingCars);
        assertThat(winners.contains(one)).isTrue();
        assertThat(winners.contains(two)).isTrue();
        assertThat(winners.contains(three)).isFalse();
    }

    @Test
    void getWinnerNamesTest() {
        RacingCar one = new RacingCar("one", 3);
        RacingCar two = new RacingCar("two", 3);
        RacingCar three = new RacingCar("three", 1);
        RacingCar[] racingCars = new RacingCar[]{one, two, three};

        String winners = Winners.getWinnerNames(racingCars);
        assertThat(winners).isEqualTo("one, two");
    }

}
