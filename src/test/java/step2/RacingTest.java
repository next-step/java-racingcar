package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.Dao.RacingData;
import step2.Model.Car;
import step2.Model.DefaultMove;
import step2.Model.Racing;

import static org.junit.jupiter.api.Assertions.assertAll;

class RacingTest {

    Racing racing;

    @BeforeEach
    void setUp() {
        racing = new Racing(new RacingData(new String[]{"car1", "car2", "car3"}, 5),
                new DefaultMove());
    }

    @Test
    void race() {
        racing.race(1);
        assertAll(
                () -> assertTrue(racing.getCar(0).getMoveOfTurn(1)),
                () -> assertTrue(racing.getCar(1).getMoveOfTurn(1)),
                () -> assertTrue(racing.getCar(2).getMoveOfTurn(1))
        );
    }

    @Test
    void moveTest() {
        Car car = racing.getCar(0);
        racing.move(car, 1);
        racing.move(car, 2);
        racing.move(car, 4);
        assertAll(
                () -> assertFalse(car.getMoveOfTurn(0)),
                () -> assertTrue(car.getMoveOfTurn(1)),
                () -> assertTrue(car.getMoveOfTurn(2)),
                () -> assertFalse(car.getMoveOfTurn(3)),
                () -> assertTrue(car.getMoveOfTurn(4))
        );
    }

}