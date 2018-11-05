package racinggame.car;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VictoryCarTest {

    List<Car> cars;

    @Test
    public void 레이싱_순위_1등(){
        cars = Arrays.asList(new Car("pobi", 1), new Car("crong", 5), new Car("pobi", 3));
        VictoryCar victoryCar =  new VictoryCar(cars);


        assertEquals(victoryCar.getVictorCar().size(), 1);
        assertEquals(victoryCar.getMaxLocation(), 5);
    }

    @Test
    public void 레이싱_순위_공동1등(){
        cars = Arrays.asList(new Car("pobi", 1), new Car("crong", 5), new Car("pobi", 5));
        VictoryCar victoryCar =  new VictoryCar(cars);


        assertEquals(victoryCar.getVictorCar().size(), 2);
        assertEquals(victoryCar.getMaxLocation(), 5);
    }

}