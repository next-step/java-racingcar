package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @ParameterizedTest(name = "자동차 객체 3개 생성")
    @ValueSource(ints = {3})
    void addCars_inputNumberCarsSize(int number) {
        Cars cars = new Cars(number);
        assertThat(cars.size()).isEqualTo(number);
    }

    @ParameterizedTest(name = "자동차 경주 결과 출력")
    @CsvSource(value = {"3,5"})
    void carsResult_distanceResult(int carNumber, int playNumber) {
        Cars cars = new Cars(carNumber);
        for (int i = 0; i < playNumber; i++) {
            cars.moveAll();
        }

        for (int i = 0; i < cars.size(); i++) {
            List<Car> carList = cars.list();
            carList.forEach(car -> assertThat(result(car.distanceDriven())).isNotEmpty());
        }
    }

    private String result(int distanceDriven) {
        String result = "";
        for (int i = 0; i < distanceDriven; i++) {
            result += "-";
        }
        return result;
    }
}
