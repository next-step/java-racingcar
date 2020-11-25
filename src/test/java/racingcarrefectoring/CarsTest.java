package racingcarrefectoring;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class CarsTest {

    @Test
    @DisplayName("자동차 객체가 잘 만들어지는가")
    public void createCars(){
        Cars cars = Cars.createCars("포비,코난,베니");
        Car pobiCar = new Car("포비");
        Car conanCar = new Car("코난");
        Car bennyCar = new Car("베니");
        assertTrue(cars.getCar().Equals(pobiCar));
        assertTrue(cars.getCar().Equals(conanCar));
        assertTrue(cars.getCar().Equals(bennyCar));
    }

    @Test
    @DisplayName("자동차 객체의 수를 제대로 반환하는가")
    public void getCarsCount(){
        Cars cars = Cars.create("포비,코난,베니,베니둘");
        assertEquals(cars.getCount(),4);
    }

}
