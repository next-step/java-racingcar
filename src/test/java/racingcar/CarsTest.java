package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private static final String TEST_CAR_NAME = "carTest";
    private Cars testCar;

    private void init(String carNames) {
        testCar = Cars.generateCars(carNames);
    }

//    @ParameterizedTest
//    @ValueSource(ints = {1, 3, 5})
//    void 입력된_숫자만큼의_Car_생성(int count) {
//        init(count);
//        assertThat(TestCar.getCarSize()).isEqualTo(count);
//    }

    @ParameterizedTest
    @CsvSource(value = {"철수:1", "철수, 영희:2", "철수, 영희, 영수:3"}, delimiter = ':')
    void 입력된_이름의_갯수만큼의_Car_생성(String names, int count) {

        init(names);
        assertThat(testCar.getCarSize()).isEqualTo(count);
    }


    @ParameterizedTest
    @CsvSource(value = {"철수", "철수, 영희", "철수, 영희, 영수"}, delimiter = ':')
    void 입력된_이름을_자동차이름_부여(String carNames) {
        String[] names = carNames.split(",");
        init(carNames);

        for (Car car : testCar.getCars()) {
            assertThat(car.getName()).containsAnyOf(names);
        }
    }

    @ParameterizedTest
    @CsvSource({"1,0", "3,0", "5,1"})
    void 자동차들_이동_테스트(int testBound, int result) {
        Cars cars = new Cars(List.of(new Car(TEST_CAR_NAME, bound -> testBound)));
        cars.checkForwardConditionAndGo();

        assertThat(cars.getCars().get(0).getDistance()).isEqualTo(result);

    }

    @Test
    void 우승자_테스트() {
        List<Car> testCars = new ArrayList<>();
        testCars.add(new Car("철수", 4));
        testCars.add(new Car("영희", 2));
        testCars.add(new Car("영수", 3));

        testCar = new Cars(testCars);
        String winner = testCar.getWinner();

        assertThat("철수".equals(winner)).isTrue();
    }

}
