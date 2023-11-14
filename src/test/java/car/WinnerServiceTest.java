package car;

import car.domain.Car;
import car.service.WinnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerServiceTest {
    private WinnerService allCars;
    private List<Car> cars;

    @BeforeEach
    void setCars() {
        cars = new ArrayList<Car>();

        cars.add(new Car("pobi", 3));
        cars.add(new Car("crong", 5));
        cars.add(new Car("honux", 6));

        allCars = new WinnerService(cars);
    }

    @DisplayName("우승자 리스트")
    @Test
    void 우승자_리스트() {
        assertThat(allCars.winnersNameList().contains("honux")).isTrue();
    }
}
