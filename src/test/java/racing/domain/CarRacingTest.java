package racing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {


    @ParameterizedTest
    @CsvSource(value = {"1,false", "2,false", "3,false", "4,true", "5,true",
            "6,true", "7,true", "8,true", "9,true", "10,true"})
    void 전진가능여부(int input, boolean expected) {
        assertThat(RandomNumber.canForword(input)).isEqualTo(expected);
    }

    @Test
    void Car_forward_position() {
        Car car = new Car();
        car.forward();
        System.out.println(car.toString());
    }
}
