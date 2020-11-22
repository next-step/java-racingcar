package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        List<String> carName = new ArrayList<>();
        carName.add("car1");
        carName.add("car2");
        carName.add("car3");
        cars = new Cars(carName);
    }

    @Test
    @DisplayName("자동차 이름 목록으로 자동차 목록을 가져오는지 확인")
    public void get_cars_by_name() {
        List<String> carNames = new ArrayList<>();
        carNames.add("car3");
        List<Car> carsByName = cars.getCarsByName(carNames);
        assertThat(carsByName.get(0).getName()).isEqualTo(carNames.get(0));
    }
}
