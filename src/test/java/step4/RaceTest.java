package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceTest {

    Cars cars; Round round; Race race; Fuel fuel;

    @BeforeEach
    void setUp() {
        cars = new Cars("peter,kassie,oak");
        round = new Round(3);
        race = new Race(cars, round);
        fuel = new Fuel() {
            @Override
            protected int getRandom() {
                return 4;
            }
        };
    }

    @Test
    void create() {
        assertThat(race).isEqualTo(new Race(cars, new Round(3)));
    }

    @Test
    void start() {
        List<Car> list = race.start(fuel);
        assertThat(list.get(0).getPosition()).isEqualTo(1);
    }

    @Test
    void cars_and_round_is_valid() {
        assertThatThrownBy(() -> new Race(null, null)).isInstanceOf(IllegalArgumentException.class) ;
    }
}