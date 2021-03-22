package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("Car 객체 제대로 가져오는지 테스트")
    void getCars() {
        // given
        int numberOfCars = 3;
        String scoreSymbol = "-";
        List<Car> expectedList = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            expectedList.add(new Car(scoreSymbol));
        }
        Car expected = expectedList.get(0);

        // when
        Cars cars = new Cars(numberOfCars, scoreSymbol);
        List<Car> actualList = cars.getCars();
        Car actual = actualList.get(0);

        // then
        assertThat(actual).isEqualToComparingFieldByField(expected);
    }
}
