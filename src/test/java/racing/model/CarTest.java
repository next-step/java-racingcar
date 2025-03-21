package racing.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

    @ParameterizedTest()
    @CsvSource(value = {"pobi,crong,honux:3", "A,B:2"}, delimiter = ':')
    void 차이름으로_차_생성(String inputText, int expectedCarSize) {
        List<Car> cars = Car.createCars(inputText);
        assertThat(cars.size()).isEqualTo(expectedCarSize);
        assertThat(cars.get(0).getName()).isEqualTo(inputText.split(",")[0]);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:1", "2:1", "3:1", "4:2", "5:2",
            "6:2", "7:2", "8:2", "9:2"}, delimiter = ':')
    void 전진_조건(int number, int expectedPosition) {
        Car car = Car.of("name");
        car.move(number);
        assertThat(car.isPosition(expectedPosition)).isTrue();
    }


}
