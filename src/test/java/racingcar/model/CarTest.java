package racingcar.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void carInitTest(){
        String name = "pobi";

        Car car = new Car(name);

        assertEquals(name, car.getName());
        assertEquals(0, car.getPosition());
    }

    @Test
    void moveTest(){

        Car car = new Car("pobi");

        car.move(true);
        assertEquals(1, car.getPosition());

        car.move(false);
        assertEquals(1, car.getPosition());
    }
}
