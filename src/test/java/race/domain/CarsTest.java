package race.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import race.RaceRule;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void init() {
        cars = new Cars(3);
    }

    @Test
    void goForward_test() {
        List<Integer> firstMileages = cars.goForward(new RaceRule());
        assertThat(firstMileages.get(0)).isEqualTo(1);
        assertThat(firstMileages.get(1)).isEqualTo(1);
        assertThat(firstMileages.get(2)).isEqualTo(1);

        List<Integer> secondMileages = cars.goForward(new RaceRule());
        assertThat(secondMileages.get(0)).isEqualTo(1);
        assertThat(secondMileages.get(1)).isEqualTo(1);
        assertThat(secondMileages.get(2)).isEqualTo(1);

        List<Integer> thirdMileages = cars.goForward(new RaceRule());
        assertThat(thirdMileages.get(0)).isEqualTo(1);
        assertThat(thirdMileages.get(1)).isEqualTo(1);
        assertThat(thirdMileages.get(2)).isEqualTo(1);
    }

}
