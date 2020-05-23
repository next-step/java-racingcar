package step4.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

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