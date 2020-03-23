package domain;

import org.junit.jupiter.api.Test;
import util.CarFactory;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {

    @Test
    public void testCreateCars() {
        // Given
        List<String> names = new ArrayList<>();
        names.add("aaa");
        names.add("bbb");
        names.add("ccc");
        // When
        List<Car> cars = CarFactory.createCars(names);
        // Then
        assertThat(cars).hasSize(names.size());
    }
}
