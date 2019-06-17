package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarsTest {
    @Test
    void Cars는_여러대의_Car를_다루는_일급_컬렉션이다() {
        List<String> names = Arrays.asList("yong", "pobi", "crong", "honux");
        Cars cars = new Cars(names);

        assertThat(cars).isInstanceOf(Cars.class);
    }

    @Test
    void Cars는_여러대의_차를_움직일_수_있다() {
        List<String> names = Arrays.asList("yong", "pobi", "crong", "honux");
        Cars cars = new Cars(names);
        List<CarInformation> positions = cars.move();

        assertThat(positions.size()).isEqualTo(names.size());
    }
}