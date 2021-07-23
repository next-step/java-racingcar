package racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
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
}