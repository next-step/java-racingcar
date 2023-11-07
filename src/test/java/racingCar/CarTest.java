package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("Car 클래스가 전진하면 distance 에 '-'이 추가된다. ")
    void generateCarClass(){
        Car car = new Car();
        car.forward();
        assertThat(car.toString()).isEqualTo("-");
    }

    @Test
    @DisplayName("Car 클래스의 toString은 Car의 현재 distance를 return한다.")
    void printDistance(){
        Car car = new Car();
        car.forward();
        car.forward();
        car.forward();
        assertThat(car.toString()).isEqualTo("---");
    }

}
