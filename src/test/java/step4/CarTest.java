package step4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void go() {
        //given
        Car car = new Car("a");
        car.setMovableStrategy(() -> true);

        //when
        car.go();

        //then
        assertThat(car).extracting("position").containsOnly(1);
    }
}