package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarsTest {

    @Test
    @DisplayName("Car 객체 제대로 가져오는지 테스트")
    void getCars() {
        // given
        int numberOfCars = 3;
        String scoreSymbol = "-";
        List<Car> expected = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            expected.add(new Car(scoreSymbol));
        }

        // when
        Cars cars = new Cars(numberOfCars, scoreSymbol);
        List<Car> actual = cars.getCars();

        // then
        assertEquals(actual.size(), expected.size());
    }
}
