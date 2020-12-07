package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void carMoveTest(){
        //given
        Car car = new Car("test");

        // when
        car.moveLocation();

        // then
        assertThat(car.getLocation()).isEqualTo(2);
    }
    
}