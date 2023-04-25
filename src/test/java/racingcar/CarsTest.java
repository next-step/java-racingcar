package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @DisplayName("요청된 양만큼 Car 생성 확인")
    @Test
    void car() {
        Cars cars = new Cars(createCarNames());
        List<Car> carList = cars.getCars();
        assertThat(carList.size()).isEqualTo(3);
    }

    private List<String> createCarNames() {
        List<String> carsNames = new ArrayList<>();
        carsNames.add("car1");
        carsNames.add("car2");
        carsNames.add("car3");
        return carsNames;
    }

}