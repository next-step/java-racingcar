package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.race.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ListTest {

    @Test
    public void test() {
        List<Car> cars = new ArrayList<>(null);
        cars.add(new Car());
        assertThat(cars.size()).isEqualTo(1);
    }
}
