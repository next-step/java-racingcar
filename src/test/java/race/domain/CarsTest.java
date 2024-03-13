package race.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import race.utils.RaceTestRule;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void init() {
        cars = new Cars(3, new String[]{"임형준", "임횽준", "임항준"});
    }

    @Test
    void goForward_test() {
        List<Integer> firstMileages = cars.goForward(() -> 4);
        assertThat(firstMileages.get(0)).isEqualTo(1);
        assertThat(firstMileages.get(1)).isEqualTo(1);
        assertThat(firstMileages.get(2)).isEqualTo(1);

        List<Integer> secondMileages = cars.goForward(() -> 4);
        assertThat(secondMileages.get(0)).isEqualTo(2);
        assertThat(secondMileages.get(1)).isEqualTo(2);
        assertThat(secondMileages.get(2)).isEqualTo(2);

        List<Integer> thirdMileages = cars.goForward(() -> 4);
        assertThat(thirdMileages.get(0)).isEqualTo(3);
        assertThat(thirdMileages.get(1)).isEqualTo(3);
        assertThat(thirdMileages.get(2)).isEqualTo(3);
    }

}
