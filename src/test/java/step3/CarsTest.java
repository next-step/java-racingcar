package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.Car;
import step3.model.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private Cars TestCar;

    private void init(int carCount) {
        TestCar = Cars.generateCars(carCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void 입력된_숫자만큼의_Car_생성(int count) {
        init(count);
        assertThat(TestCar.getCarSize()).isEqualTo(count);
    }

    @ParameterizedTest
    @CsvSource({"1,0", "3,0", "5,1"})
    void 자동차들_이동_테스트(int testBound, int result) {
        Cars cars = new Cars(List.of(new Car(0, bound -> testBound)));
        cars.checkForwardConditionAndGo();

        assertThat(cars.getCars().get(0).getDistance()).isEqualTo(result);

    }

}
