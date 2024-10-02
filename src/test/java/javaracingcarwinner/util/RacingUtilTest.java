package javaracingcarwinner.util;

import javaracingcarwinner.entity.RacingCar;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingUtilTest {

    @Test
    void random_작동_검증() {
        int result = RacingUtil.random();

        assertThat(result).isLessThanOrEqualTo(9).isGreaterThanOrEqualTo(0);
    }

    @Test
    void 우승자_검증_1명() {
        List<RacingCar> cars = new ArrayList<>();

        RacingCar winner = new RacingCar("winner");
        winner.go().go().go();
        cars.add(winner);

        RacingCar woogie = new RacingCar("woogie");
        woogie.go();
        cars.add(woogie);

        List<RacingCar> winners = RacingUtil.whoIsWinners(cars);

        assertThat(winners).hasSize(1);

        RacingCar who = winners.get(0);

        assertThat(who.name()).isEqualTo("winner");

    }

    @Test
    void 우승자_검증_공동() {
        List<RacingCar> cars = new ArrayList<>();

        RacingCar winner = new RacingCar("winner");
        winner.go().go().go();
        cars.add(winner);

        RacingCar winner2 = new RacingCar("winner2");
        winner2.go().go().go();
        cars.add(winner2);

        RacingCar winner3 = new RacingCar("winner3");
        winner3.go().go().go();
        cars.add(winner3);

        RacingCar loser = new RacingCar("loser");
        loser.go();
        cars.add(loser);

        List<RacingCar> winners = RacingUtil.whoIsWinners(cars);

        assertThat(winners).hasSize(3);

        assertThat(winners.stream().map(w -> w.name()).toArray()).contains("winner", "winner2", "winner3");
    }

}
