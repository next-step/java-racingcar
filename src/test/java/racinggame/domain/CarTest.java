package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("Car 움직임 테스트")
    @Test
    public void moveCarsTest() {
        String[] carNames = {"a", "b"};
        Cars cars = new Cars(carNames);
        cars.getCars().get(0).move(0);
        cars.getCars().get(1).move(5);
        Assertions.assertThat(cars.getCars().get(0).getLocation()).isEqualTo(0);
        Assertions.assertThat(cars.getCars().get(1).getLocation()).isEqualTo(1);

    }

    @DisplayName("Car 위치값 얻기 테스트")
    @Test
    public void getLocationTest(){
        Car car = new Car("a", 7);
        Assertions.assertThat(car.getLocation()).isEqualTo(7);
    }
}
