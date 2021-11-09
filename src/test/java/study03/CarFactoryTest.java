package study03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study03.Car;
import study03.CarFactory;

import java.lang.reflect.Field;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {
    @Test
    @DisplayName("객체 생성 시 car 객체 수 확인")
    void car갯수() throws NoSuchFieldException, IllegalAccessException {
        int expect = 3;

        CarFactory carFactory = new CarFactory(expect);
        Field cars = CarFactory.class.getDeclaredField("cars");
        cars.setAccessible(true);
        List<Car> carList = (List<Car>) cars.get(carFactory);
        assertThat(carList.size()).isEqualTo(expect);
    }
}