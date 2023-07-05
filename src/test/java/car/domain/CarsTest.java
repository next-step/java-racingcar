package car.domain;

import car.util.Movable;
import car.util.RandomCarMovable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    @DisplayName("움직일 수 있을 시, 정해진 만큼 움직인다")
    void 자동자_움직_가능 () {
        Movable movable = new RandomCarMovable();
        Cars cars = new Cars(new CarNames("hello"));
        cars.race(movable);
        if (movable.getMovable()) {
            Assertions.assertEquals(cars.getCars().get(0).getPosition(), movable.getMovingSize());
        }
    }

    @Test
    @DisplayName("움직일 수 없을 시, 안 움직인다.")
    void 자동자_멈춤 () {
        Movable movable = new RandomCarMovable();
        Cars cars = new Cars(new CarNames("hello"));
        cars.race(movable);
        if (!movable.getMovable()) {
            Assertions.assertEquals(cars.getCars().get(0).getPosition(), 0);
        }
    }


}
