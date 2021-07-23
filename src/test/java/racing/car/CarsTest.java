package racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;


class CarsTest {
    private Cars initCars(int carSize) {
        Cars cars = new Cars();
        for (int i = 0; i < carSize; i++)
            cars.add(new Car());
        return cars;
    }

    @ValueSource(ints = {
            10, 100, 1000
    })
    @DisplayName("Car Add Test")
    @ParameterizedTest
    public void addTest(int size) {
        Cars cars = initCars(size);

        assertThat(cars.size())
                .isEqualTo(size);
    }

    // cars.iterator().hasNext() 를 이용해서 테스트를 만들어보면 어떨까요? :)
    @ValueSource(ints = { 0, 1, 100, 1000 })
    @DisplayName("Car Iterator Test With For")
    @ParameterizedTest
    public void carIteratorForTest(int size) {
        Cars cars = initCars(size);

        Iterator<Car> iterator = cars.iterator();
        for (int i = 0; i < size; i++) {
            iterator.next();
        }
        assertThat(iterator.hasNext())
                .isEqualTo(false);
    }

    @ValueSource(ints = { 0, 1, 100, 1000 })
    @DisplayName("Car Test With While")
    @ParameterizedTest
    public void carIteratorWhileTest(int size) {
        Cars cars = initCars(size);

        Iterator<Car> iterator = cars.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
    }

    // 요구사항 "주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다." 에 대한 테스트를 추가 해보면 어떨까요?
    // 꼭 Cars가 아니여도 상관이 없습니다. 🤔
    @CsvSource({
            "5,100,FULL,true",
            "100,100,MIN,true",
            "100,100,EMPTY,false"
    })
    @DisplayName("주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.")
    @ParameterizedTest
    public void moveAllTest(int carSize, int turnSize, String fuelName, boolean movement) {
        Cars cars = initCars(carSize);
        Fuel fuel = Fuel.valueOf(fuelName);

        for (int i = 0; i < turnSize; i++) {
            cars.moveAll(fuel);
        }

        for (Car iCar : cars) {
            assertThat(
                    iCar.getLocation().hasValue()
            ).withFailMessage("요청한대로 이동하지 않았습니다.")
                    .isEqualTo(movement);
        }
    }
}