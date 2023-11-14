package car;

import car.domain.Car;
import car.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarServiceTest {

    private List<Car> oneWinners = new ArrayList<Car>();

    @BeforeEach
    void setCars() {
        oneWinners.add(new Car("pobi", 4));
        oneWinners.add(new Car("crong", 6));
        oneWinners.add(new Car("honux", 8));
    }

    @DisplayName("N대 자동차 생성")
    @Test
    void n대자동차_생성_테스트() {
        String[] names = {"pobi", "crong", "honux"};
        assertEquals(CarService.generate(names).size(), oneWinners.size());
    }

}
