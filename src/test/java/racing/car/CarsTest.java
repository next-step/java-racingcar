package racing.car;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import util.RandomUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;


class CarsTest {
    private static Random random;

    @BeforeAll
    public static void setUp() {
        random = new Random();
    }

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
    @DisplayName("Car Iterator Test")
    @ParameterizedTest
    public void carIteratorTest(int size) {
        Cars cars = initCars(size);

        Iterator<Car> iterator = cars.iterator();
        for (int i = 0; i < size; i++) {
            iterator.next();
        }
        assertThat(iterator.hasNext())
                .isEqualTo(false);
    }

    // 요구사항 "주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다." 에 대한 테스트를 추가 해보면 어떨까요?
    // 꼭 Cars가 아니여도 상관이 없습니다. 🤔
    @CsvSource({
            "100,5,false",
            "100,100,true",
            "100,200,true",
            "100,1000,false"
    })
    @DisplayName("Car Move All Test")
    @ParameterizedTest
    public void moveAllTest(int carSize, int turnSize, boolean movement) {
        Cars cars = initCars(carSize);

        for (int i = 0; i < turnSize; i++)
            cars.moveAll(movement);

        for (Car iCar : cars) {
            assertThat(
                    iCar.getLocation().getValue() > 0
            ).withFailMessage(
                    String.format("%s 상태에서 반대로 행동함 [%d]", (movement ? "movement" : "not movement"), iCar.getLocation().getValue())
            ).isEqualTo(movement);
        }
    }
}