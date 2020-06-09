package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceTest {

    Cars cars; Race race; Fuel fuel;

    @BeforeEach
    void setUp() {
        cars = new Cars("peter,kassie,oak");
        race = new Race(cars, 3);
        fuel = new Fuel() {
            @Override
            public boolean isValid() {
                return true;
            }
        };
    }

    @Test
    void create() {
        assertThat(race).isEqualTo(new Race(cars, 3));
    }

    @Test
    void cars_and_round_is_valid() {
        assertThatThrownBy(() -> new Race(null, 0)).isInstanceOf(IllegalArgumentException.class) ;
    }
}