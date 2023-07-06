package car;

import car.domain.Car;
import car.domain.CarNames;
import car.domain.Cars;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {


    @Test
    @DisplayName("우승자를 구한다.")
    void 우승자_구하기() {
        Cars cars = new Cars(new CarNames("hello,jonga"));

        int maxPos = cars.getCars().stream().map(Car::getPosition)
            .max(Comparator.comparing(x -> x))
            .orElseThrow(() -> new NoSuchElementException("자동차 간의 최대 위치가 존재 하지 않습니다."));
        List<Car> winner = cars.selectWinners();

        winner.forEach((w) -> {
            Assertions.assertEquals(maxPos, w.getPosition());
        });
    }
}
