package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("모든 자동차 중에 이기는 자동차 이름을 반환하는데 성공")
    void getWinningCarsSuccess() {
        Set<Car> mockCarSet = new HashSet<>();
        Car mockCar1 = new Car("a");
        Car mockCar2 = new Car("b");
        Car mockCar3 = new Car("c");

        mockCar1.move(() -> true);
        mockCar1.move(() -> true);
        mockCar2.move(() -> true);

        mockCarSet.add(mockCar1);
        mockCarSet.add(mockCar2);
        mockCarSet.add(mockCar3);

        Cars mockCars = new Cars(mockCarSet);

        Set<String> expected = new HashSet<>();
        expected.add("a");

        assertThat(mockCars.getWinningCars())
                .isEqualTo(expected);
    }

}
