package car.domain;

import car.util.Movable;
import car.util.RandomCarMovable;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("움직일 수 있을 시, 정해진 만큼 움직인다")
    void 자동자_움직_가능() {
        Movable movable = new RandomCarMovable();
        Cars cars = new Cars(new CarNames("hello"));
        cars.race(movable);
        if (movable.getMovable()) {
            Assertions.assertEquals(cars.getCars().get(0).getPosition(), movable.getMovingSize());
        }
    }

    @Test
    @DisplayName("움직일 수 없을 시, 안 움직인다.")
    void 자동자_멈춤() {
        Movable movable = new RandomCarMovable();
        Cars cars = new Cars(new CarNames("hello"));
        cars.race(movable);
        if (!movable.getMovable()) {
            Assertions.assertEquals(cars.getCars().get(0).getPosition(), 0);
        }
    }


    @Test
    @DisplayName("우승자를 구한다.")
    void 우승자_구하기() {
        Cars cars = new Cars(new CarNames("hello,jonga"));

        int maxPos = cars.getCars().stream().map(Car::getPosition)
            .max(Comparator.comparing(x -> x)).orElseThrow(() -> new RuntimeException());
        List<Car> winner = cars.selectWinners();

        winner.forEach((w) -> {
            Assertions.assertEquals(maxPos, w.getPosition());
        });
    }
}
