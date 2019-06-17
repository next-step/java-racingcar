package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CarFactoryTest {

    @Test
    void generateWithPlayerCount() {
        List<Car> cars = CarFactory.generate(5);

        assertThat(cars.size()).isNotZero();
        assertThat(cars.size()).isEqualTo(5);
    }

    @Test
    void generateWithNames() {
        String[] names = {"pobi", "tobi", "sobi"};
        List<Car> cars = CarFactory.generate(names);

        assertThat(cars.size()).isEqualTo(3);
        assertThat(cars.get(0).toString()).isEqualTo("pobi");
        assertThat(cars.get(1).toString()).isEqualTo("tobi");
        assertThat(cars.get(2).toString()).isEqualTo("sobi");
    }


}
