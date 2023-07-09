package car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import car.domain.Car;
import car.domain.CarNames;
import car.domain.Cars;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("우승자를 구한다.")
    void 우승자_구하기() {
        Cars cars = new Cars(new CarNames("hello, jonga"));
        int carMaxPosition = cars.getCars().stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new NoSuchElementException("자동차 간의 최대 위치가 존재 하지 않습니다."));

        List<Car> winner = cars.selectWinners();

        for (Car car : winner) {
            assertThat(car).extracting("position").isEqualTo(carMaxPosition);
        }
    }

}
