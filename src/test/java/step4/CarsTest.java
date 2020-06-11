package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step4.mock.MockFuel;
import step4.model.Car;
import step4.model.Cars;
import step4.model.Fuel;
import step4.model.Result;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    Cars cars; List<Car> result; Fuel fuel;

    @BeforeEach
    void setUp() {
        cars = new Cars("peter,kassie,oak");
        result = getResult();
        fuel = new MockFuel();
    }

    @Test
    void create() {
        assertThat(cars).isEqualTo(new Cars("peter,kassie,oak"));
    }

    @Test
    void move() {
        Result movedCars = cars.move(fuel);
        assertThat(movedCars.getResult().get(0).getPosition()).isEqualTo(1);
    }

    @Test
    void valid_number_of_car() {
        assertThatThrownBy(() -> cars.split("pater,kassie")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void create_cars_from_name() {
        assertThat(cars.getCars()).isEqualTo(result);
    }

    @Test
    void name_is_valid() {
        assertThatThrownBy(() -> new Cars("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Cars(null)).isInstanceOf(IllegalArgumentException.class);
    }

    private List<Car> getResult() {
        List<Car> result = new ArrayList<>();
        result.add(Car.of("peter"));
        result.add(Car.of("kassie"));
        result.add(Car.of("oak"));
        return result;
    }
}