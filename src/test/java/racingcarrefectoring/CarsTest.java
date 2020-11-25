package racingcarrefectoring;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import racingcarrefectoring.model.Car;
import racingcarrefectoring.model.Cars;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CarsTest {

    @Test
    @DisplayName("자동차 객체가 잘 만들어지는가")
    public void createCars(){
        Cars cars = new Cars("포비,코난,베니");
        Car pobiCar = new Car("포비");
        Car conanCar = new Car("코난");
        Car bennyCar = new Car("베니");
        assertTrue(cars.getCar(0).equals(pobiCar));
        assertTrue(cars.getCar(1).equals(conanCar));
        assertTrue(cars.getCar(2).equals(bennyCar));
    }

    @Test
    @DisplayName("자동차 객체의 수를 제대로 반환하는가")
    public void getCarsCount(){
        Cars cars = new Cars("포비,코난,베니,베니둘");
        assertEquals(cars.getCount(),4);
    }

}
