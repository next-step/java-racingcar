package race.domian;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    void 우승자_찾기() {
        Cars cars = new Cars(List.of("a","b","c"));
        cars.move(() -> true);
        assertThat(cars.findWinners()).isEqualTo(new ArrayList<>(List.of("a","b","c")));
    }
}