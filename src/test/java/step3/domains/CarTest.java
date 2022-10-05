package step3.domains;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1,false",
            "3,false",
            "4,true",
            "9,true"
    })
    void Given_Integer_GreaterThanFour_When_Move_Then_MoveForward(int number, boolean isMove) {
        Car car = new Car("car", number);

        Car moveCar = car.move(() -> isMove);

        assertThat(!car.equals(moveCar)).isEqualTo(isMove);
    }
}
