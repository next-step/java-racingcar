package race;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        List<String> firstMileages = cars.goForward(3, 1);
        assertThat(firstMileages.get(0)).isEqualTo("-");
        assertThat(firstMileages.get(1)).isEqualTo("-");
        assertThat(firstMileages.get(2)).isEqualTo("-");

        List<String> secondMileages = cars.goForward(3, 2);
        assertThat(secondMileages.get(0)).isEqualTo("--");
        assertThat(secondMileages.get(1)).isEqualTo("--");
        assertThat(secondMileages.get(2)).isEqualTo("--");

        List<String> thirdMileages = cars.goForward(3, 3);
        assertThat(thirdMileages.get(0)).isEqualTo("---");
        assertThat(thirdMileages.get(1)).isEqualTo("---");
        assertThat(thirdMileages.get(2)).isEqualTo("---");
    }

}
