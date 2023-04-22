package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("자동차 객체 2개 생성")
    void addCars_inputNumberCarsSize() {
        String[] names = {"pobi", "conan"};
        Cars cars = new Cars(names);
        assertThat(cars.size()).isEqualTo(names.length);
    }

    @Test
    @DisplayName("자동차 경주 결과 출력")
    void carsResult_distanceResult() {
        String[] names = {"pobi", "conan"};
        int playCount = 5;

        Cars cars = new Cars(names);
        for (int i = 0; i < playCount; i++) {
            cars.moveAll();
        }

        for (int i = 0; i < cars.size(); i++) {
            List<Car> carList = cars.list();
            carList.forEach(car -> assertThat(car.distanceDriven()).isNotNegative());
        }
    }

}
