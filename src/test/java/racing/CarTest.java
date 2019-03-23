package racing;

import org.junit.Test;
import racing.dto.Car;

import java.util.ArrayList;
import java.util.List;

public class CarTest {

    @Test
    public void 우승자한명() {
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car("pobi", 4));
        cars.add(new Car("jypweback", 5));
        cars.add(new Car("honus", 3));
    }
}