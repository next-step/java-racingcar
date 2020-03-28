package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    public void createCarsTest() {
        String names = "a,b,c";
        Cars cars = new Cars(names);
        assertThat(cars.getCars()).hasSize(3);
        assertThat(cars.getCars()).contains(new Car("a"), new Car("b"), new Car("c"));
    }
}
