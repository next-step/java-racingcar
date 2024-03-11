package carRacing;

import car.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {


    @Test
    void 한번_이동_테스트(){
        Car car = new Car();
        car.move(1);
        System.out.println("car.getLocation() = " + car.getLocation());
        assertThat(car.getLocation()).containsAnyOf("", "-");
    }


    @Test
    void 두번이상_이동_테스트(){
        Car car = new Car();

        car.move(2);
        System.out.println("car.getLocation() = " + car.getLocation());
        assertThat(car.getLocation()).containsAnyOf("", "-", "--");
    }


}