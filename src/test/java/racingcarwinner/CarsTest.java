package racingcarwinner;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertTrue;

public class CarsTest {

    @Test
    @DisplayName("자동차 객체 리스트 생성이 잘 되는가")
    public void create(){
        Cars cars = Cars.createCars("포비,코난,베니");
        assertTrue(cars.getCar(0).equals(new Car("포비")));
        assertTrue(cars.getCar(0).equals(new Car("코난")));
        assertTrue(cars.getCar(0).equals(new Car("베니")));
    }

    @Test
    @DisplayName("자동차 객체 반환을 잘 하는가")
    public void getCar(){
        Cars cars = Cars.createCars("베니");
        Car car = new Car("베니");
        assertTrue(car.equals(cars.getCar(0)));
    }

    @Test
    @DisplayName("자동차 댓수 반환을 잘 하는가")
    public void getCount(){
        Cars cars = Cars.createCars("포비,코난,베니,베니2");
        assertTrue(cars.getCount() == 4);
    }
}
