package step4;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {

    @Test
    void create() {
        int rounds = 3;
        String names = "peter,kassie,oak";
        Cars cars = new Cars(names);
        Round round = new Round(rounds);

        Race race = new Race(cars, round);

        assertThat(race).isEqualTo(new Race(cars, new Round(rounds)));
    }

    @Test
    void start() {
        Fuel fuel = new Fuel() {
            @Override
            protected int getRandom() {
                return 4;
            }
        };

        int rounds = 3;
        String names = "peter,kassie,oak";
        Cars cars = new Cars(names);
        Round round = new Round(rounds);
        Race race = new Race(cars, round);

        List<Car> list = race.start(fuel);

        assertThat(list.get(0).getPosition()).isEqualTo(1);
    }
}