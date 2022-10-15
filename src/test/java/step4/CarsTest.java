package step4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarsTest {

    @Test
    public void 우승한_자동차_목록을_반환할_수_있다() {
        Car car1 = getCar("test1", 1);
        Car car2 = getCar("test1", 2);
        Car car3 = getCar("test1", 3);
        Car car4 = getCar("test1", 3);
        Cars cars = new Cars(List.of(car1, car2, car3, car4));
        assertEquals(cars.getWinners(), new Cars(List.of(car3, car4)));
    }

    private Car getCar(String name, int location) {
        Car car = new Car(name, new MoveStrategy());
        for (int i = 0; i < location; i++) {
            car.moveOrStop();
        }
        return car;
    }
}
