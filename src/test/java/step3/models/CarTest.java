package step3.models;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.models.Car;

public class CarTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1,false",
            "3,false",
            "4,true",
            "9,true"
    })
    void Given_Integer_GreaterThanFour_When_Move_Then_MoveForward(int number, boolean expected) {
        Car car = new Car();

        Car moveCar = car.move(number);

        assertThat(car.getPosition() != moveCar.getPosition()).isEqualTo(expected);
    }
}
